package com.example.tsvid_ff.Fragment;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tsvid_ff.Activity.MainActivity;
import com.example.tsvid_ff.Entity.Account;
import com.example.tsvid_ff.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import static com.example.tsvid_ff.Common.AccountCommon.ID_ACCOUNT;
import static com.example.tsvid_ff.Activity.LoginActivity.dbContext;
import static com.example.tsvid_ff.Common.AccountCommon.acc;

public class IDCardFragment extends Fragment {

    TextView tvName,tvDate,tvFaculty,tvScholastic,tvId,tvClassroom;
    ImageView imv1;
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
            }
        });
        return inflater.inflate(R.layout.fragment_id_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Init(view);
    }
    private void Init(View view)
    {
        imv1= view.findViewById(R.id.img_capture_idcard);
        tvName=view.findViewById(R.id.tv_name_idcard);
        tvDate=view.findViewById(R.id.tv_date_idcard);
        tvFaculty=view.findViewById(R.id.tv_faculty_idcard);
        tvScholastic=view.findViewById(R.id.tv_scholastic_idcard);
        tvId=view.findViewById(R.id.tv_id_idcard);
        tvClassroom=view.findViewById(R.id.tv_classroom_idcard);
        tvId.setText("Mã SV: "+acc.getId());
        tvName.setText(acc.getName());
        tvDate.setText(acc.getDatetime());
        tvFaculty.setText(acc.getFaculty());
        tvScholastic.setText(acc.getScholastic());
        tvClassroom.setText(acc.getClassroom());
        Picasso.get().load(Uri.parse(acc.getImage())).into(imv1);
    }
}