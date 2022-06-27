package com.example.fragment_demo2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    // khai báo key dùng cho Bundle
    // Bundle : giúp truyền nhận dữ liệu từ ngoài vào Actibity và Fragment
    private static final String ARG_CONTENT = "content";

    // khai báo thuộc tính , đây chính là các value chứa các giá trị của key (1)
    private String mContent;

    public SecondFragment() {
        // Required empty public constructor
    }

    // đầu vào  dữ liệu  cho Fragment
    // bên trong phương thức này  sẽ tự dộng tạo Bundle, rồi tự tạo các bộ key/value chính là các param vừa nhận
    // rồi nhét vào Bundle, rồi gửi qua Fragment được khởi tạo ngay chính trong phương thức này luôn, đó chính là SecondFragment
    public static SecondFragment newInstance(String content) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    // các bộ key/value sẽ được lấy ra dùng thông qua Bundle được đóng gói ở newInstance trên kia và truyền đi
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        TextView tvContent = (TextView) view.findViewById(R.id.tvContent);
        if (!TextUtils.isEmpty(mContent)) {
            tvContent.setText(mContent);
        }

        return view;
    }
}