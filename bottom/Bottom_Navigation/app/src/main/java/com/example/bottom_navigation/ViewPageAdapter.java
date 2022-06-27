package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bottom_navigation.fragment.FragmentHome;
import com.example.bottom_navigation.fragment.Fragment_Favorite;
import com.example.bottom_navigation.fragment.Fragment_page;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new FragmentHome();

            case 1:
                return new Fragment_Favorite();

            case 2:
                return new Fragment_page();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;// tra ve so luong Fragment
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
