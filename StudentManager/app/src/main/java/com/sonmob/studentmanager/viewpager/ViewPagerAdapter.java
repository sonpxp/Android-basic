package com.sonmob.studentmanager.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.sonmob.studentmanager.Fragment.LopFragment;
import com.sonmob.studentmanager.Fragment.SinhVienFragment;
import com.sonmob.studentmanager.Fragment.ToiFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LopFragment();
            case 1:
                return new SinhVienFragment();
            case 2:
                return new ToiFragment();
            default:
                return new LopFragment();
        }

    }

    @Override
    public int getCount() {
        return 3; // return so luong tab fragment = o day co 3 tab
    }
}
