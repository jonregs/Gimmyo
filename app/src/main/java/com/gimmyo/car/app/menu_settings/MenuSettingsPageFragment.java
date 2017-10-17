package com.gimmyo.car.app.menu_settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gimmyo.car.app.R;

/**
 * Created by Jon on 9/6/2017.
 */

public class MenuSettingsPageFragment extends Fragment {
    public static MenuSettingsPageFragment newInstance() {
        MenuSettingsPageFragment fragment = new MenuSettingsPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_settings_main_fragment, container, false);
    }
}