package com.gimmyo.car.app.BidBoard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gimmyo.car.app.R;

/**
 * Created by jonegalado on 7/27/17, Gimmyo Project.
 */

public class BidBoardHome extends AppCompatActivity implements BidBoardListFragment.OnBidBoardItemSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root_layout, BidBoardListFragment.newInstance(), "bidBoardList")
                    .commit();
        }
    }

    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void OnBidBoardItemSelected(int imageResId, String name, String description, String url) {
        final BidBoardDetailsFragment detailsFragment =
                BidBoardDetailsFragment.newInstance(imageResId, name, description, url);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, detailsFragment, "bidBoardDetails")
                .commit();
    }
}
