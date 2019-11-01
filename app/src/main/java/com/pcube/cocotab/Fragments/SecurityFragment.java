package com.pcube.cocotab.Fragments;


import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.FragmentSecurityBinding;
import com.rm.rmswitch.RMSwitch;
import com.rm.rmswitch.RMTristateSwitch;


public class SecurityFragment extends Fragment {

    FragmentSecurityBinding binding;

    public SecurityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_security, container, false);
        View view = binding.getRoot();


        binding.mSwitch.setSwitchToggleCheckedDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_switch_thumb));

        binding.mSwitch.setSwitchToggleNotCheckedDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.custom_switch_thumb));
        binding.mSwitch.setSwitchDesign(RMTristateSwitch.DESIGN_LARGE);

        binding.mSwitch1.setSwitchToggleCheckedDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_switch_thumb));

        binding.mSwitch1.setSwitchToggleNotCheckedDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.custom_switch_thumb));
        binding.mSwitch1.setSwitchDesign(RMTristateSwitch.DESIGN_LARGE);

        binding.mSwitch2.setSwitchToggleCheckedDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_switch_thumb));

        binding.mSwitch2.setSwitchToggleNotCheckedDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.custom_switch_thumb));
        binding.mSwitch2.setSwitchDesign(RMTristateSwitch.DESIGN_LARGE);


        binding.mSwitch.addSwitchObserver(new RMSwitch.RMSwitchObserver() {
            @Override
            public void onCheckStateChange(RMSwitch switchView, boolean isChecked) {
                if (isChecked){
                    binding.toggleLock.setVisibility(View.VISIBLE);
                }else {
                    binding.toggleLock.setVisibility(View.GONE);
                }

            }
        });

        binding.mSwitch1.addSwitchObserver(new RMSwitch.RMSwitchObserver() {
            @Override
            public void onCheckStateChange(RMSwitch switchView, boolean isChecked) {
                if (isChecked){
                    binding.toggleLock1.setVisibility(View.VISIBLE);
                }else {
                    binding.toggleLock1.setVisibility(View.GONE);
                }

            }
        });

        binding.mSwitch2.addSwitchObserver(new RMSwitch.RMSwitchObserver() {
            @Override
            public void onCheckStateChange(RMSwitch switchView, boolean isChecked) {
                if (isChecked){
                    binding.toggleLock2.setVisibility(View.VISIBLE);
                }else {
                    binding.toggleLock2.setVisibility(View.GONE);
                }

            }
        });

        return view;

    }

}
