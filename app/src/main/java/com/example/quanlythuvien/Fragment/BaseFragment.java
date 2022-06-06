package com.example.quanlythuvien.Fragment;

import androidx.fragment.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.quanlythuvien.BaseActivity;
import com.example.quanlythuvien.R;
import com.utility.DebugLog;

public class BaseFragment extends Fragment {
    public void showLoading() {
        if (requireActivity() instanceof BaseActivity) {
            ((BaseActivity) requireActivity()).showLoading();
        }
    }

    public void showLoading(String showLoading) {
        if (requireActivity() instanceof BaseActivity) {
            ((BaseActivity) requireActivity()).hideLoading();
            ((BaseActivity) requireActivity()).showLoading(showLoading);
        }
    }

    public void hideLoading() {
        if (requireActivity() instanceof BaseActivity) {
            ((BaseActivity) requireActivity()).hideLoading();
        }
    }

    public void close() {
        requireActivity().onBackPressed();
    }
}
