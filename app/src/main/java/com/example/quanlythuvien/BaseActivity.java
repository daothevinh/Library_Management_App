package com.example.quanlythuvien;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.utility.DebugLog;

public class BaseActivity extends AppCompatActivity {
    TextView txt;
    private MaterialDialog mProgressDialog;

    public void showLoading() {
        hideLoading();
        try {
            mProgressDialog = new MaterialDialog.Builder(this)
                    .content(R.string.msg_please_wait)
                    .progress(true, 0)
                    .show();
        } catch (Exception e) {
            DebugLog.loge(e);
        }
    }

    public void showLoading(String message) {
        hideLoading();
        try {
            mProgressDialog = new MaterialDialog.Builder(this)
                    .content(message)
                    .progress(true, 0)
                    .show();
        } catch (Exception e) {
            DebugLog.loge(e);
        }
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
        mProgressDialog = null;
    }
}
