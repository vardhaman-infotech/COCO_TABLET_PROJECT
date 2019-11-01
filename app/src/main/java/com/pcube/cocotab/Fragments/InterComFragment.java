package com.pcube.cocotab.Fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcube.cocotab.Activity.HomeActivity;
import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.FragmentInterComBinding;


public class InterComFragment extends Fragment {

    FragmentInterComBinding binding;

    public InterComFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_inter_com, container, false);
        View view = binding.getRoot();

        ((HomeActivity) getActivity()).showTopBar();
        binding.ivVoicecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIncomingCallFragment(new IncomingCallFragment());
                //startActivity(new Intent(getActivity(), IncomingCallActivity.class));
            }
        });

        return view;
    }



    public void openIncomingCallFragment(final Fragment fragment) {
        ((HomeActivity) getActivity()).hideTopBar();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }


}
