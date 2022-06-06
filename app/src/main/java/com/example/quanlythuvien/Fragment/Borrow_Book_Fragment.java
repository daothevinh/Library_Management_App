package com.example.quanlythuvien.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlythuvien.Adapter.Borrow_Book_Adapter;
import com.example.quanlythuvien.R;
import com.example.quanlythuvien.model.Information_BorrowBook;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Borrow_Book_Fragment extends BaseFragment {
    private EditText edtUserName_BorrowBook, edtBorrowDate_BorrowBook;
    private RecyclerView recyclerView_BorrowBook;
    private Borrow_Book_Adapter borrow_book_adapter;
    private FloatingActionButton btnAddBook_BorrowBook;
    private Context context;
    private Information_BorrowBook object_Information_BorrowBook;
    private List<Information_BorrowBook> information_borrowBookList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrow_book, container, false);
        if (context == null) {
            context = getActivity();
        }
        connect(view);

        information_borrowBookList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView_BorrowBook.setLayoutManager(linearLayoutManager);
        borrow_book_adapter = new Borrow_Book_Adapter(information_borrowBookList);
//        borrow_book_adapter.setData(getData());
        recyclerView_BorrowBook.setAdapter(borrow_book_adapter);
        btnAddBook_BorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAddBook(view);
            }
        });
        return view;
    }

//    private List<Information_BorrowBook> getData() {
//        List<Information_BorrowBook> list = new ArrayList<>();
//        list.addAll(information_borrowBookList);
//
//        return list;
//    }


    private void openDialogAddBook(View view) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.information_dialog_borrow_book);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAttributes);
        EditText edtBookId_Dialog_BorrowBook = dialog.findViewById(R.id.editTextBookId_Dialog_BorrowBook);
        EditText edtBookName_Dialog_BorrowBook = dialog.findViewById(R.id.editTextBookName_Dialog_BorrowBook);
        EditText edtCategory_Dialog_BorrowBook = dialog.findViewById(R.id.editTextCategory_Dialog_BorrowBook);
        EditText edtAuthor_Dialog_BorrowBook = dialog.findViewById(R.id.editTextAuthor_Dialog_BorrowBook);
        Button btnCancel_Dialog_BorrowBook = dialog.findViewById(R.id.buttonCancel_Dialog_BorrowBook);
        Button btnAdd_Dialog_BorrowBook = dialog.findViewById(R.id.buttonAdd_Dialog_BorrowBook);

        btnCancel_Dialog_BorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnAdd_Dialog_BorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object_Information_BorrowBook = new Information_BorrowBook();
                object_Information_BorrowBook.setBookId(String.valueOf(edtBookId_Dialog_BorrowBook.getText()));
                object_Information_BorrowBook.setBookName(String.valueOf(edtBookName_Dialog_BorrowBook.getText()));
                object_Information_BorrowBook.setCategory(String.valueOf(edtCategory_Dialog_BorrowBook.getText()));
                object_Information_BorrowBook.setAuthor(String.valueOf(edtAuthor_Dialog_BorrowBook.getText()));

                information_borrowBookList.add(object_Information_BorrowBook);
                borrow_book_adapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void connect(View view) {
        edtUserName_BorrowBook = view.findViewById(R.id.editTextNameUser_BorrowBook);
        edtBorrowDate_BorrowBook = view.findViewById(R.id.editTextBorrowDate_BorrowBook);
        recyclerView_BorrowBook = view.findViewById(R.id.recyclerView_BorrowBook);
        btnAddBook_BorrowBook = view.findViewById(R.id.floatingButtonAddUser_BorrowBook);
    }
}
