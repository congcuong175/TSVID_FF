package com.example.tsvid_ff.Fragment;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tsvid_ff.Activity.MainActivity;
import com.example.tsvid_ff.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class IDCardFragment extends Fragment {


    public IDCardFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       container.setRotation(90);
        container.setScaleX(1.3f);
        container.setScaleY(1.3f);
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                NavController navController = Navigation.findNavController(getView());
                navController.navigate(R.id.navi);
                container.setScaleX(0.99f);
                container.setScaleY(0.99f);
                container.setRotation(-0.00000000001f);
            }
        });
        return inflater.inflate(R.layout.fragment_id_card, container, false);
    }

}