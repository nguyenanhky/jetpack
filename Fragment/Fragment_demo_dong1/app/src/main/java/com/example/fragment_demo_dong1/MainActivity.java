package com.example.fragment_demo_dong1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button btnadd_a, btnadd_b,btnadd_c, btnback;
    private Button btnremove_a, btnremove_b, btnremove_c, btnpop_a;

    private FragmentA fragment;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    private FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addConstrols();

        manager = getSupportFragmentManager();

    }
    public void addA(View v){
        transaction=manager.beginTransaction();
        fragment=new FragmentA();
        transaction.replace(R.id.frame,fragment,"fa");
        transaction.addToBackStack("aa");// addToBackStack() để quay lại fragment truoc do
        transaction.commit();// gióng như một lời cam kết thay đổi
    }
    public void removeA(View v){
        // commit() : Cho dù bạn có quản lý hiển thị Fragment bằng add(), replace() hay remove()
        // thi bạn cũng phải gọi commit() cuối cùng
        // để FragmentTransaction biết sẽ bắt đầu thực hiện các transaction mà bạn đã ra lệnh đó
        transaction=manager.beginTransaction();
        fragment=(FragmentA)getSupportFragmentManager().
                findFragmentByTag("fa");
        transaction.remove(fragment);
        transaction.commit();
    }
    public void addB(View v){
        // de triệu hồi FragmentTransaction thì  phải thông qua phương thức beginTransaction(); từ  FragmentManager.
        transaction=manager.beginTransaction();
        fragmentB=new FragmentB();
        transaction.replace(R.id.frame,fragmentB,"fb");// thay thay the frame bang fb
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void removeB(View v){
        transaction=manager.beginTransaction();
        fragmentB=(FragmentB)getSupportFragmentManager().
                findFragmentByTag("fb");
        transaction.remove(fragment);
        transaction.commit();
    }

    public void addC(View v){
        transaction=manager.beginTransaction();
        fragmentC=new FragmentC();
        transaction.replace(R.id.frame,fragmentC,"fc");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void removeC(View v){
        transaction=manager.beginTransaction();
        fragmentC=(FragmentC)getSupportFragmentManager().
                findFragmentByTag("fc");// sử dụng getsubpportFragmentManager()  khi hiển thị Fragment lên Activity
        transaction.remove(fragment);
        transaction.commit();
    }
    public void back(View v){
        getSupportFragmentManager().popBackStack();
    }
    // day la cua he thong tren android
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else
            super.onBackPressed();
    }
    public void popA(View v){
        getSupportFragmentManager().popBackStack("aa",0);
    }
    private void addConstrols() {
        btnadd_a = findViewById(R.id.btnadd_A);
        btnadd_b = findViewById(R.id.btnadd_B);
        btnadd_c = findViewById(R.id.btnadd_C);
        btnback = findViewById(R.id.btnback);

        btnremove_a = findViewById(R.id.btnremove_A);
        btnremove_b = findViewById(R.id.btnremove_B);
        btnremove_c = findViewById(R.id.btnremove_C);

        btnpop_a = findViewById(R.id.btn_popA);
    }
}