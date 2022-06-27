package com.example.fragmen_viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.fragmen_viewpager.Fragment.FragmentFood;
import com.example.fragmen_viewpager.Fragment.Fragment_trave;
import com.example.fragmen_viewpager.Fragment.Fragmentmovie;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // tra ve fre
        switch (position) {
            case 0:
                return new FragmentFood();
            case 1:
                return new Fragment_trave();
            case 3:
                return new Fragmentmovie();
            default:
                return new FragmentFood();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
