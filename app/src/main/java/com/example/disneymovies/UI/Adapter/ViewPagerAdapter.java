package com.example.disneymovies.UI.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.disneymovies.UI.Fragment.LoginFragment;
import com.example.disneymovies.UI.Fragment.RegisterFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: return new RegisterFragment();
            case 0:
            default: return new LoginFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}