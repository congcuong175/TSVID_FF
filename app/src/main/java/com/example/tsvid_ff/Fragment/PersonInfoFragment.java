package com.example.tsvid_ff.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tsvid_ff.R;


public class PersonInfoFragment extends Fragment {


    public PersonInfoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.setScaleX(0.99f);
        container.setScaleY(0.99f);
        container.setRotation(-0.00000000001f);
        return inflater.inflate(R.layout.fragment_t_t_c_n, container, false);
    }

    TextView textView;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        textView=view.findViewById(R.id.tsv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.IDCardFragment);
            }
        });
    }

}