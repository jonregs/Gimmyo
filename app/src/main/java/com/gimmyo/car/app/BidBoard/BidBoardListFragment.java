package com.gimmyo.car.app.BidBoard;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gimmyo.car.app.R;

/**
 * Created by Jon on 8/27/2017.
 */

public class BidBoardListFragment extends Fragment {

    private int[] mImageResIds;
    private String[] mNames;
    private String[] mDescriptions;
    private String[] mUrls;
    private OnBidBoardItemSelected mListener;

    public static BidBoardListFragment newInstance() {
        return new BidBoardListFragment();
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnBidBoardItemSelected) {
            mListener = (OnBidBoardItemSelected) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnRageComicSelected.");
        }

        // Get rage face names and descriptions.
        final Resources resources = context.getResources();
        mNames = resources.getStringArray(R.array.names);
        mDescriptions = resources.getStringArray(R.array.descriptions);
        mUrls = resources.getStringArray(R.array.urls);

        final TypedArray typedArray = resources.obtainTypedArray(R.array.images);
        final int imageCount = mNames.length;
        mImageResIds = new int[imageCount];
        for (int i = 0; i < imageCount; i++) {
            mImageResIds[i] = typedArray.getResourceId(i, 0);
        }
        typedArray.recycle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rage_comic_list, container, false);

        final Activity activity = getActivity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 2));
        recyclerView.setAdapter(new BidBoardListAdapter(activity));

        return view;
    }

    class BidBoardListAdapter extends RecyclerView.Adapter<ViewHolder> {

        private LayoutInflater mLayoutInflater;

        public BidBoardListAdapter (Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(mLayoutInflater.inflate(R.layout.recycler_item_rage_comic, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            final int imageResId = mImageResIds[position];
            final String names = mNames[position];
            final String description = mDescriptions[position];
            final String url = mUrls[position];
            viewHolder.setData(imageResId, names);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.OnBidBoardItemSelected(imageResId, names, description, url);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mNames.length;
        }
    }


    // This is being done so that you can define what will be presented in the viewholder, which in turn is provided to the list adapter.
    // Define here all elements that will be used and displayed on a card within the bidboard.
    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            //Get references to image and name.
            mImageView = (ImageView) itemView.findViewById(R.id.comic_image);
            mTextView = (TextView) itemView.findViewById(R.id.name);
        }

        private void setData(int imageResId, String name) {
            mImageView.setImageResource(imageResId);
            mTextView.setText(name);
        }
    }

    public interface OnBidBoardItemSelected {
        void OnBidBoardItemSelected(int imageResId, String name,
                                 String description, String url);
    }
}
