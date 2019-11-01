package com.pcube.cocotab.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.FragmentIncomingCallBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomingCallFragment extends Fragment {

    FragmentIncomingCallBinding binding;

    public IncomingCallFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_incoming_call, container, false);

        View view = binding.getRoot();


        return view;
    }

}
