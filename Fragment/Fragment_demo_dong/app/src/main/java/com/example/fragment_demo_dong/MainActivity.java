package com.example.fragment_demo_dong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private Button btA, btB;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btA = findViewById(R.id.addA);
        btB = findViewById(R.id.addB);
        btA.setOnClickListener(this);
        btB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();

        if(view==btA){
            fragment=new Fragment_a();
            transaction.replace(R.id.layout,fragment);
        }
        if(view==btB){
            fragment=new Fragment_b();
            transaction.replace(R.id.layout,fragment);
        }
        transaction.commit();

    }

}