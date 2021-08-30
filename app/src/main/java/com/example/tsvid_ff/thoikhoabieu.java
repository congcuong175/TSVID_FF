package com.example.tsvid_ff;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.tsvid_ff.Fragment.HomeFragment;

import org.jetbrains.annotations.NotNull;


public class thoikhoabieu extends Fragment {

    LinearLayout mau,mau1,mau2,mau3,mau4,mau5;
    public thoikhoabieu() {
        // Required empty public constructor
    }
    HomeFragment mainActivity = (HomeFragment) getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                NavController navController = Navigation.findNavController(getView());
                navController.navigate(R.id.navi);
            }
        });
        return inflater.inflate(R.layout.fragment_thoikhoabieu, container, false);

    }
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mau=view.findViewById(R.id.mau);
        mau1=view.findViewById(R.id.mau1);
        mau2=view.findViewById(R.id.mau2);
        mau3=view.findViewById(R.id.mau3);
        mau4=view.findViewById(R.id.mau4);
        mau5=view.findViewById(R.id.mau5);
       mau1.setBackgroundColor(getResources().getColor(R.color.purple_500));
    }


}