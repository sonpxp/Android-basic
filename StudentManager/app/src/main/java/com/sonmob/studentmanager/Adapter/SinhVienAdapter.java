package com.sonmob.studentmanager.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sonmob.studentmanager.DAO.LopDao;
import com.sonmob.studentmanager.DAO.SinhVienDao;
import com.sonmob.studentmanager.Model.Lop;
import com.sonmob.studentmanager.Model.SinhVien;
import com.sonmob.studentmanager.R;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder> {

    private List<SinhVien> mListSinhVien;
    SinhVienDao sinhVienDao;
    Activity context;

    public void setDataSinhvien(List<SinhVien> list){
        this.mListSinhVien = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien, parent, false);
        return new SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
        final SinhVien sinhVien = mListSinhVien.get(position);
        if (sinhVien  == null){
            return;
        }
        holder.tvmaSv.setText(sinhVien.getMaSv());
        holder.tvtenSv.setText(sinhVien.getTenSv());
        holder.tvemail.setText(sinhVien.getEmail());
        holder.tvmaLopSv.setText(sinhVien.getMaLop());
    }

    @Override
    public int getItemCount() {
        if (mListSinhVien != null){
            return mListSinhVien.size();
        }
        return 0;
    }

    public class SinhVienViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSV, ivXoaLop;
        private TextView tvmaSv,tvtenSv,tvemail,tvmaLopSv;
        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSV = itemView.findViewById(R.id.img_sinhvien);

            tvmaSv = itemView.findViewById(R.id.tv_maSv);
            tvtenSv = itemView.findViewById(R.id.tv_tenSv);
            tvemail = itemView.findViewById(R.id.tv_email);
            tvmaLopSv = itemView.findViewById(R.id.tv_maLopSv);
            ivXoaLop = itemView.findViewById(R.id.tv_delete);
        }
    }
}
