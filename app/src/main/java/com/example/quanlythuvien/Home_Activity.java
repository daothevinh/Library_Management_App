package com.example.quanlythuvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quanlythuvien.Fragment.Borrow_Book_Fragment;

public class Home_Activity extends BaseActivity {
    Button btnCancel_Home_BorrowBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, new Borrow_Book_Fragment());
        fragmentTransaction.commit();

        btnCancel_Home_BorrowBook = findViewById(R.id.buttonCancel_Home_BorrowBook);

        btnCancel_Home_BorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}