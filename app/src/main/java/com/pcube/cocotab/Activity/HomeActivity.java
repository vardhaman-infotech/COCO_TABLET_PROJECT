package com.pcube.cocotab.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pcube.cocotab.Fragments.AlexaFragment;
import com.pcube.cocotab.Fragments.BabyMonitorFragment;
import com.pcube.cocotab.Fragments.HomeFragment;
import com.pcube.cocotab.Fragments.InterComFragment;
import com.pcube.cocotab.Fragments.MainDoorFragment;
import com.pcube.cocotab.Fragments.SecurityFragment;
import com.pcube.cocotab.R;
import com.pcube.cocotab.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomeBinding binding;
    HomeFragment homeFragment = new HomeFragment();
    SecurityFragment securityFragment = new SecurityFragment();
    BabyMonitorFragment babyMonitorFragment = new BabyMonitorFragment();
    InterComFragment interComFragment = new InterComFragment();
    MainDoorFragment mainDoorFragment = new MainDoorFragment();
    AlexaFragment alexaFragment = new AlexaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        openFragment(homeFragment);

        binding.ivSecurityCam.setOnClickListener(this);
        binding.ivKid.setOnClickListener(this);
        binding.ivIntercom.setOnClickListener(this);
        binding.ivHome.setOnClickListener(this);
        binding.ivVideoCall.setOnClickListener(this);

    }

    public void openFragment(final Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivSecurityCam:
                binding.llRoot.setBackgroundResource(R.drawable.gradient_security_top_bar);
                openFragment(securityFragment);
                break;

            case R.id.ivKid:
                binding.llRoot.setBackgroundResource((R.drawable.gradient_layout_bg));
                openFragment(babyMonitorFragment);
                break;

            case R.id.ivIntercom:
                binding.llRoot.setBackgroundResource(R.color.white);
                openFragment(interComFragment);
                break;

            case R.id.ivHome:
                //openFragment(alexaFragment);
                startActivity(new Intent(this, AlexaActivity.class));
                break;

            case R.id.ivVideoCall:
                openFragment(mainDoorFragment);
                break;
        }
    }


    public void hideTopBar(){
        binding.llRoot.setVisibility(View.GONE);
    }

    public void showTopBar(){
        binding.llRoot.setVisibility(View.VISIBLE);
    }
}
