package com.example.quanlythuvien.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlythuvien.R;
import com.example.quanlythuvien.model.Information_BorrowBook;

import java.util.List;

public class Borrow_Book_Adapter extends RecyclerView.Adapter<Borrow_Book_Adapter.ViewHolder_Information_Borrow_Book> {
    private List<Information_BorrowBook> information_borrowBookList;
    private Context context;

    public Borrow_Book_Adapter(List<Information_BorrowBook> information_borrowBookList) {
        this.information_borrowBookList = information_borrowBookList;
    }

    public void setData(List<Information_BorrowBook> list){
        this.information_borrowBookList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder_Information_Borrow_Book onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.row_information_borrow_book, parent, false);

        return new ViewHolder_Information_Borrow_Book(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Information_Borrow_Book holder, int position) {
        Information_BorrowBook information_borrowBook = information_borrowBookList.get(position);
        if (information_borrowBook == null) {
            return;
        }
        holder.txtOrdinalNumbers_BorrowBook.setText(information_borrowBook.getOrdinalNumbers() + "");
        holder.txtBookId_Borrow_Book.setText(information_borrowBook.getBookId());
        holder.txtBookName_Borrow_Book.setText(information_borrowBook.getBookName());
        holder.txtCategory_Borrow_Book.setText(information_borrowBook.getCategory());
        holder.txtAuthor_Borrow_Book.setText(information_borrowBook.getAuthor());


    }

    @Override
    public int getItemCount() {
        if (information_borrowBookList != null) {
            return information_borrowBookList.size();
        }
        return 0;
    }

    public class ViewHolder_Information_Borrow_Book extends RecyclerView.ViewHolder {
        TextView txtOrdinalNumbers_BorrowBook;
        TextView txtBookId_Borrow_Book, txtBookName_Borrow_Book, txtCategory_Borrow_Book, txtAuthor_Borrow_Book;

        public ViewHolder_Information_Borrow_Book(@NonNull View itemView) {
            super(itemView);
            txtOrdinalNumbers_BorrowBook = itemView.findViewById(R.id.textViewOrdinalNumbers_BorrowBook);
            txtBookId_Borrow_Book = itemView.findViewById(R.id.textViewBookId_BorrowBook);
            txtBookName_Borrow_Book = itemView.findViewById(R.id.textViewBookName_BorrowBook);
            txtCategory_Borrow_Book = itemView.findViewById(R.id.textViewCategory_BorrowBook);
            txtAuthor_Borrow_Book = itemView.findViewById(R.id.textViewAuthor_BorrowBook);
        }
    }
}
