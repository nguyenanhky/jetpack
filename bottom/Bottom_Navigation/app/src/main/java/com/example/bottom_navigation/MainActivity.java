package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager mviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addConstrols();
        addEvents();

    }

    private void addEvents() {
        setupviewpage();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        //Toast.makeText(MainActivity.this,"anh ky",Toast.LENGTH_SHORT).show();
                        mviewPager.setCurrentItem(0);
                        break;
                    case R.id.action_favorite:
                        //Toast.makeText(MainActivity.this,"ngoc anh",Toast.LENGTH_SHORT).show();
                        mviewPager.setCurrentItem(1);
                        break;
                    case R.id.action_black:
                        //Toast.makeText(MainActivity.this,"tran ngoc anh",Toast.LENGTH_SHORT).show();
                        mviewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }

    private void addConstrols() {
        navigationView = findViewById(R.id.bottom_nav);
        mviewPager = findViewById(R.id.view_page);


    }

    private void setupviewpage() {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mviewPager.setAdapter(viewPageAdapter);
        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.action_favorite).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.action_black).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}