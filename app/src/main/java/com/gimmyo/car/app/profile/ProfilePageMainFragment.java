package com.gimmyo.car.app.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gimmyo.car.app.R;

/**
 * Created by Jon on 9/6/2017.
 */

public class ProfilePageMainFragment extends Fragment {
    public static ProfilePageMainFragment newInstance() {
        ProfilePageMainFragment fragment = new ProfilePageMainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_main_fragment, container, false);
    }
}
