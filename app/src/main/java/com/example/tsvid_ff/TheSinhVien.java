package com.example.tsvid_ff;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tsvid_ff.Activity.MainActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class TheSinhVien extends Fragment {


    public TheSinhVien() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_the_sinh_vien, container, false);
    }

}