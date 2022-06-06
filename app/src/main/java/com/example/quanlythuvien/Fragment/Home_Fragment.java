package com.example.quanlythuvien.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlythuvien.Home_Activity;
import com.example.quanlythuvien.R;

public class Home_Fragment extends BaseFragment {
    Button btn_HomeFragment_BorrowBook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_HomeFragment_BorrowBook = view.findViewById(R.id.button_HomeFragment_BorrowBook);
        btn_HomeFragment_BorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Home_Activity.class);
                startActivity(intent);
            }
        });


        return view;

    }

}
