package com.doctor.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doctor.demo.R;
public class SearchFragment extends Fragment {
    private View mRootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){

            mRootView = inflater.inflate(R.layout.fragment_search,container,false);
        }

        return mRootView;
    }
}
