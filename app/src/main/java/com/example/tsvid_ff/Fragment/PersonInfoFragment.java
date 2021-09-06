package com.example.tsvid_ff.Fragment;

import static com.example.tsvid_ff.Common.AccountCommon.acc;

import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tsvid_ff.R;
import com.squareup.picasso.Picasso;


public class PersonInfoFragment extends Fragment {

    TextView tvName,tvDate,tvFaculty,tvScholastic,tvId,tvClassroom;
    ImageView imv1;
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

    TextView textView,textView1;
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
        textView1=view.findViewById(R.id.thoikhoabieu);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.thoikhoabieu2);
            }
        });
        Init(view);

    }
    private void Init(View view)
    {
        imv1= view.findViewById(R.id.img_capture_ttcn);
        tvName=view.findViewById(R.id.tv_name_ttcn);
        tvDate=view.findViewById(R.id.tv_date_ttcn);
        tvFaculty=view.findViewById(R.id.tv_faculty_ttcn);
        tvScholastic=view.findViewById(R.id.tv_scholastic_ttcn);
        tvId=view.findViewById(R.id.tv_id_ttcn);
        tvClassroom=view.findViewById(R.id.tv_classroom_ttcn);
        tvId.setText("Mã SV: "+acc.getId());
        tvName.setText(acc.getName());
        tvDate.setText(acc.getDatetime());
        tvFaculty.setText(acc.getFaculty());
        tvScholastic.setText(acc.getScholastic());
        tvClassroom.setText(acc.getClassroom());
        Picasso.get().load(Uri.parse(acc.getImage())).into(imv1);
    }
}