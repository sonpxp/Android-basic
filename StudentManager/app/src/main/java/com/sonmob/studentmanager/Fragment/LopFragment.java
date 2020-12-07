package com.sonmob.studentmanager.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sa90.materialarcmenu.ArcMenu;
import com.sonmob.studentmanager.Adapter.LopAdapter;
import com.sonmob.studentmanager.DAO.LopDao;
import com.sonmob.studentmanager.Database.DBHelper;
import com.sonmob.studentmanager.MainActivity;
import com.sonmob.studentmanager.Model.Lop;
import com.sonmob.studentmanager.R;

import java.util.ArrayList;
import java.util.List;


public class LopFragment extends Fragment {
    private RecyclerView rcvLop;
    private View mView;
    private MainActivity mainActivity;
    private LopAdapter lopAdapter;
    private LopDao lopDao;
    private FloatingActionButton fablop;

    public  static ArrayList<Lop> dsLop ;

    public LopFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_lop, container, false);
        mainActivity = (MainActivity) getActivity();
        //
        rcvLop = mView.findViewById(R.id.rcv_lop);
        fablop = mView.findViewById(R.id.fab);
        //
        dsLop = new ArrayList<>();
        DBHelper dbHelper = new DBHelper(mainActivity);
        //
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcvLop.setLayoutManager(linearLayoutManager);
        lopDao = new LopDao(mainActivity);
        dsLop = lopDao.getAll();

        lopAdapter = new LopAdapter();
        lopAdapter.setData(dsLop,mainActivity);
        rcvLop.setAdapter(lopAdapter);


        fablop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = AddLopFragment.newInstance();
                newFragment.show(getActivity().getSupportFragmentManager(), "dialog");
            }
        });


        return mView;
    }
}