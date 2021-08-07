package com.example.tsvid_ff.Activity;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tsvid_ff.Common.ValidateData;
import com.example.tsvid_ff.Database.DBContext;
import com.example.tsvid_ff.Entity.Account;
import com.example.tsvid_ff.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;

import static com.example.tsvid_ff.Activity.LoginActivity.dbContext;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;
    TextInputEditText edt_tip_masv, edt_tip_hoten, edt_tip_ngaysinh, edt_tip_nganhhoc, edt_tip_lop, edt_tip_khoahoc;
    ImageView imv_anh;
    TextInputLayout edt_noti_id, edt_noti_name, edt_noti_birth, edt_noti_faculty, edt_noti_classroom, edt_noti_scholatics;
    int REQUEST_CODE_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        onClick();

    }

    private void initView() {
        edt_tip_masv = findViewById(R.id.edt_id_register);
        edt_tip_hoten = findViewById(R.id.edt_name_register);
        edt_tip_ngaysinh = findViewById(R.id.dpk_birth_register);
        edt_tip_nganhhoc = findViewById(R.id.edt_faculty_register);
        edt_tip_lop = findViewById(R.id.edt_classroom_register);
        edt_tip_khoahoc = findViewById(R.id.edt_scholatics_register);
        btn_register = findViewById(R.id.btn_register_register);
        imv_anh = findViewById(R.id.img_capture_register);

        edt_noti_id = findViewById(R.id.edt_noti_id_register);
        edt_noti_name = findViewById(R.id.edt_noti_name_register);
        edt_noti_birth = findViewById(R.id.edt_noti_birth_register);
        edt_noti_faculty = findViewById(R.id.edt_noti_faculty_register);
        edt_noti_classroom = findViewById(R.id.edt_noti_classroom_register);
        edt_noti_scholatics = findViewById(R.id.edt_noti_scholatics_register);
    }

    public void onClick() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_noti_id.setError("");
                edt_noti_name.setError("");
                edt_noti_birth.setError("");
                edt_noti_faculty.setError("");
                edt_noti_classroom.setError("");
                edt_noti_scholatics.setError("");

                if (!ValidateData.checkUniqueID(edt_tip_masv.getText().toString())) {
                    edt_noti_id.setError("Mã sinh viên đã tồn tại");
                }
                if (!ValidateData.checkEmpty(edt_tip_masv.getText().toString())) {
                    edt_noti_id.setError("Mã sinh viên không được để trống");
                }
                if (!ValidateData.checkEmpty(edt_tip_hoten.getText().toString())) {
                    edt_noti_name.setError("Họ tên không được để trống");
                }
                if (!ValidateData.checkEmpty(edt_tip_ngaysinh.getText().toString())) {
                    edt_noti_birth.setError("Ngày sinh không được để trống");
                }
                if (!ValidateData.checkEmpty(edt_tip_nganhhoc.getText().toString())) {
                    edt_noti_faculty.setError("Ngành học không được để trống");
                }
                if (!ValidateData.checkEmpty(edt_tip_lop.getText().toString())) {
                    edt_noti_classroom.setError("Lớp học không được để trống");
                }
                if (!ValidateData.checkEmpty(edt_tip_khoahoc.getText().toString())) {
                    edt_noti_scholatics.setError("Năm học không được để trống");
                }else{
                    Toast.makeText(getApplicationContext(),"Thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
        imv_anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });
        edt_tip_ngaysinh.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                setDatePickerDialog();
            }
        });

    }



    //show DatePickerDialog
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setDatePickerDialog() {
        int selectedYear = LocalDate.now().getYear();
        int selectedMonth = LocalDate.now().getMonthValue();
        int selectedDay = LocalDate.now().getDayOfMonth();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edt_tip_ngaysinh.setText(String.format("%s - %s - %s", dayOfMonth, month, year));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, selectedYear, selectedMonth, selectedDay);
        datePickerDialog.show();
    }

    //Capture
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imv_anh.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}