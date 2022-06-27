package com.example.framgment_api_demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        Button button = view.findViewById(R.id.sendData2btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = view.findViewById(R.id.fragment2Data);
                Bundle result = new Bundle();
                result.putString("df2",editText.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFrom2",result);
                editText.setText("");
            }
        });

        getParentFragmentManager().setFragmentResultListener("dataFrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("df1");
                TextView textView  = view.findViewById(R.id.datafrom1);
                textView.setText(data);
            }
        });
        return view;
    }
}