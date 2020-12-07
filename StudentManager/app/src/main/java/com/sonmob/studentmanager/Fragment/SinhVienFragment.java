package com.sonmob.studentmanager.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sonmob.studentmanager.Adapter.LopAdapter;
import com.sonmob.studentmanager.Adapter.SinhVienAdapter;
import com.sonmob.studentmanager.DAO.LopDao;
import com.sonmob.studentmanager.DAO.SinhVienDao;
import com.sonmob.studentmanager.Database.DBHelper;
import com.sonmob.studentmanager.MainActivity;
import com.sonmob.studentmanager.Model.Lop;
import com.sonmob.studentmanager.Model.SinhVien;
import com.sonmob.studentmanager.R;

import java.util.ArrayList;


public class SinhVienFragment extends Fragment {
    private RecyclerView rcvSinhVien;
    private View mView;
    private MainActivity mainActivity;
    private SinhVienAdapter sinhVienAdapter;
    private SinhVienDao sinhVienDao;
    private ImageView xoaLop;
    private FloatingActionButton fabsinhvien;
    //Context context;

    ArrayList<SinhVien> dsSinhVien = new ArrayList<>();


    public SinhVienFragment() {
        // Required empty public constructor
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_sinh_vien, container, false);
        mainActivity = (MainActivity) getActivity();

        rcvSinhVien = mView.findViewById(R.id.rcv_sinhvien);
        fabsinhvien = mView.findViewById(R.id.fab_sv);
        xoaLop = mView.findViewById(R.id.tv_delete);


        DBHelper dbHelper = new DBHelper(mainActivity);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcvSinhVien.setLayoutManager(linearLayoutManager);

        sinhVienDao = new SinhVienDao(mainActivity);
        dsSinhVien = sinhVienDao.getALL();

        sinhVienAdapter = new SinhVienAdapter();
        sinhVienAdapter.setDataSinhvien(dsSinhVien);
        rcvSinhVien.setAdapter(sinhVienAdapter);


        return  mView;
    }
}