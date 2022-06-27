package com.example.fragment_demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_demo.R;

public class FragmentA extends Fragment {

    public FragmentA() {
        // Required empty public constructor
    }

    // thực hiện giao diện (View), trả view là giao diện file XML tương ứng Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
