package com.example.quanlythuvien.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlythuvien.Fragment.Book_Information_Fragment;
import com.example.quanlythuvien.Fragment.Borrow_Book_Fragment;
import com.example.quanlythuvien.Fragment.Create_Membership_Card_Fragment;
import com.example.quanlythuvien.Fragment.Home_Fragment;

public class ViewPager_Adapter extends FragmentStateAdapter {
    public ViewPager_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Create_Membership_Card_Fragment();
            case 2:
                return new Book_Information_Fragment();
            default:
                return new Home_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
