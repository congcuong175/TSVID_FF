package com.example.tsvid_ff.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tsvid_ff.R;
import com.google.android.material.textfield.TextInputEditText;
import static com.example.tsvid_ff.Activity.LoginActivity.dbContext;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;
    TextInputEditText edt_tip_masv,edt_tip_hoten,edt_tip_ngaysinh,edt_tip_nganhhoc,edt_tip_lop,edt_tip_khoahoc;
    ImageView imv_anh;
    int REQUEST_CODE_IMAGE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        onClick();
        imv_anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE_IMAGE);
            }
        });
    }
    private void initView()
    {
        edt_tip_masv=findViewById(R.id.edt_masv);
        edt_tip_hoten=findViewById(R.id.edt_hoten);
        edt_tip_ngaysinh=findViewById(R.id.edt_ngaysinh);
        edt_tip_nganhhoc=findViewById(R.id.edt_nganhhoc);
        edt_tip_lop=findViewById(R.id.edt_lop);
        edt_tip_khoahoc=findViewById(R.id.edt_khoahoc);
        btn_register=findViewById(R.id.btnDangky);
        imv_anh=findViewById(R.id.imv_anh);
    }
    public  void onClick()
    {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE_IMAGE&&requestCode==RESULT_OK&&data!=null)
        {
            Bitmap bitmap= (Bitmap) data.getExtras().get("data");
            imv_anh.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}