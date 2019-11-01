package com.pcube.cocotab.Fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcube.cocotab.Activity.HomeActivity;
import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);
        View view = binding.getRoot();
        ((HomeActivity) getActivity()).showTopBar();

       // binding.seek.setEndAngle(90);
       // binding.seek.setRotation(285);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}
