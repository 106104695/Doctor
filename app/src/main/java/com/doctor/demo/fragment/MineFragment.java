package com.doctor.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doctor.demo.R;

/**
 * Created by HDY on 2016/12/27.
 */

public class MineFragment extends Fragment {
    private View mRootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){

            mRootView = inflater.inflate(R.layout.fragment_mine,container,false);
        }

        return mRootView;
    }
}
