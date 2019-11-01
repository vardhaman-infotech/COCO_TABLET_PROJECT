package com.pcube.cocotab.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcube.cocotab.Activity.HomeActivity;
import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.FragmentBabyMonitorBinding;


public class BabyMonitorFragment extends Fragment {

    FragmentBabyMonitorBinding binding;

    public BabyMonitorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_baby_monitor, container, false);
        View view = binding.getRoot();

        ((HomeActivity) getActivity()).showTopBar();

        return view;
    }

}
