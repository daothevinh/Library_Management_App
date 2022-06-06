package com.example.quanlythuvien.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.ToastUtils;
import com.example.quanlythuvien.R;
import com.example.quanlythuvien.databinding.FragmentBookInformationBinding;
import com.example.quanlythuvien.databinding.FragmentCreateMembershipCardBinding;
import com.example.quanlythuvien.db.RemoteApiService;
import com.example.quanlythuvien.model.TheDocGia;
import com.example.quanlythuvien.model.ThongTinSach;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Book_Information_Fragment extends BaseFragment {
    FragmentBookInformationBinding fragmentBookInformationBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBookInformationBinding = FragmentBookInformationBinding.inflate(inflater, container, false);
        return fragmentBookInformationBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentBookInformationBinding.btnAddBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoading();
                ThongTinSach thongTinSach = new ThongTinSach(fragmentBookInformationBinding.textViewBookName.getText() + "",
                        fragmentBookInformationBinding.textViewTheLoai.getText() + "",
                        fragmentBookInformationBinding.textViewTacGia.getText() + "",
                        fragmentBookInformationBinding.textViewNamXuatBan.getText() + "",
                        fragmentBookInformationBinding.textViewNhaXuatBan.getText() + "",
                        fragmentBookInformationBinding.textViewNgayNhap.getText() + "",
                        fragmentBookInformationBinding.textVieweTriGia.getText() + "");
                RemoteApiService.Creator.newRetrofitInstance().create(RemoteApiService.class).addThongTinSach(thongTinSach.tenSach, thongTinSach).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<TheDocGia>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(TheDocGia theDocGia) {
                        ToastUtils.showLong("Thêm độc giải thành công");
                        clearAll();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
            }
        });
    }

    private void clearAll() {
        fragmentBookInformationBinding.textViewBookName.setText("");
        fragmentBookInformationBinding.textViewTheLoai.setText("");
        fragmentBookInformationBinding.textViewTacGia.setText("");
        fragmentBookInformationBinding.textViewNamXuatBan.setText("");
        fragmentBookInformationBinding.textViewNhaXuatBan.setText("");
        fragmentBookInformationBinding.textViewNgayNhap.setText("");
        fragmentBookInformationBinding.textVieweTriGia.setText("");
    }
}
