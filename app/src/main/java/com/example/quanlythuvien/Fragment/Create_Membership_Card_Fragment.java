package com.example.quanlythuvien.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.ToastUtils;
import com.example.quanlythuvien.Main_Activity;
import com.example.quanlythuvien.R;
import com.example.quanlythuvien.databinding.FragmentCreateMembershipCardBinding;
import com.example.quanlythuvien.db.RemoteApiService;
import com.example.quanlythuvien.model.TheDocGia;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Create_Membership_Card_Fragment extends BaseFragment {
    FragmentCreateMembershipCardBinding fragmentCreateMembershipCardBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentCreateMembershipCardBinding = FragmentCreateMembershipCardBinding.inflate(inflater, container, false);
        return fragmentCreateMembershipCardBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btnMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hovaten = fragmentCreateMembershipCardBinding.textViewHovaTen.getText() + "";
                String loadDocGia = fragmentCreateMembershipCardBinding.textViewLoaiDocGia.getText() + "";
                String ngaySinh = fragmentCreateMembershipCardBinding.textViewNgaySinh.getText() + "";
                String diaChi = fragmentCreateMembershipCardBinding.textViewDiaChi.getText() + "";
                String email = fragmentCreateMembershipCardBinding.textViewEmail.getText() + "";
                String NgayLapThe = fragmentCreateMembershipCardBinding.textViewNgayLapThe.getText() + "";
                TheDocGia theDocGia = new TheDocGia();
                theDocGia.hovaten = hovaten;
                theDocGia.loaiDocgia = loadDocGia;
                theDocGia.NgaySinh = ngaySinh;
                theDocGia.Diachi = diaChi;
                theDocGia.Mail = email;
                theDocGia.NgayLapThe = NgayLapThe;
                if (TextUtils.isEmpty(theDocGia.Mail)) {
                    ToastUtils.showLong("Email không được để trống");
                }
                showLoading();
                RemoteApiService.Creator.newRetrofitInstance().create(RemoteApiService.class).addTheDocGia(theDocGia.Mail, theDocGia).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<TheDocGia>() {
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
        fragmentCreateMembershipCardBinding.textViewNgaySinh.setText("");
        fragmentCreateMembershipCardBinding.textViewDiaChi.setText("");
        fragmentCreateMembershipCardBinding.textViewEmail.setText("");
        fragmentCreateMembershipCardBinding.textViewNgayLapThe.setText("");
        fragmentCreateMembershipCardBinding.textViewHovaTen.setText("");
        fragmentCreateMembershipCardBinding.textViewLoaiDocGia.setText("");
    }


}
