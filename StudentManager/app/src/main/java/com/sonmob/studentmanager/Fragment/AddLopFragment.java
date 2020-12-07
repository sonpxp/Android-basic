package com.sonmob.studentmanager.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonmob.studentmanager.Adapter.LopAdapter;
import com.sonmob.studentmanager.DAO.LopDao;
import com.sonmob.studentmanager.MainActivity;
import com.sonmob.studentmanager.Model.Lop;
import com.sonmob.studentmanager.R;

import java.util.ArrayList;

public class AddLopFragment extends DialogFragment {
    Context mContext;
    private View mView;
    private MainActivity mainActivity;

    private EditText edtTenLop;
    private EditText edtMaLop;
    private Button btnSaveLop;
    private Button btnCancelLop;
    private LopDao lopDao;

    public AddLopFragment() {
        mContext = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_add_lop, container, false);
        mainActivity = (MainActivity) getActivity();

        edtTenLop = mView.findViewById(R.id.edt_tenLop);
        edtMaLop = mView.findViewById(R.id.edt_maLop);
        btnSaveLop = mView.findViewById(R.id.btn_save_lop);
        btnCancelLop = mView.findViewById(R.id.btn_cancel_lop);

        lopDao = new LopDao(mainActivity);
        final ArrayList<Lop> dsLop = new ArrayList<>();

        btnSaveLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtMaLop.getText().toString();
                String tenlop = edtTenLop.getText().toString();
                if (malop.equals("")) {
                    Toast.makeText(mainActivity, "Mã lớp không được để trống", Toast.LENGTH_SHORT).show();
                } else if (tenlop.equals("")) {
                    Toast.makeText(mainActivity, "Tên không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    Lop lop = new Lop(malop, tenlop);
                    if (lopDao.insert(lop)) {
                        dismiss();
//                        dsLop.clear();
//                        dsLop.addAll(lopDao.getAll());
                        Toast.makeText(mainActivity, "Them thanh cong", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mainActivity, "Them that bai", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        return mView;
    }

    public static AddLopFragment newInstance() {
        AddLopFragment f = new AddLopFragment();
        return f;
    }
}