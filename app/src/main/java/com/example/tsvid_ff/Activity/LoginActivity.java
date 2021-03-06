package com.example.tsvid_ff.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tsvid_ff.Common.AccountCommon;
import com.example.tsvid_ff.Common.ValidateData;
import com.example.tsvid_ff.Database.DBContext;
import com.example.tsvid_ff.Entity.Account;
import com.example.tsvid_ff.Fragment.HomeFragment;
import com.example.tsvid_ff.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    //declare control

    TextInputEditText edt_account, edt_password;
    TextInputLayout edt_noti_account,edt_noti_password;
    TextView btn_register, btn_forgot, btn_login;
    ImageView btn_finger;
    TextView btn_privacy;
    public static DBContext dbContext;
    ArrayList<Account>accounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbContext = new DBContext();
        accounts=dbContext.getDataAccount();
         initView();
        onClick();

        }

    //initView
    private void initView() {
        edt_account = findViewById(R.id.edt_account_login);
        edt_password = findViewById(R.id.edt_password_login);
        btn_register = findViewById(R.id.btn_register_login);
        btn_forgot = findViewById(R.id.btn_forgot_login);
        btn_login = findViewById(R.id.btn_login_login);
        btn_finger = findViewById(R.id.btn_finger_login);
        btn_privacy = findViewById(R.id.btn_privacy_login);
        edt_noti_account = findViewById(R.id.edt_noti_account_login);
        edt_noti_password = findViewById(R.id.edt_noti_password_login);
    }

    //event on click;
    private void onClick() {
        //open RegisterActivity
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_noti_account.setError("");
                edt_noti_password.setError("");
                if(!ValidateData.checkEmpty(edt_account.getText().toString())){
                    edt_noti_account.setError("T??i kho???n kh??ng ???????c ????? tr???ng");
                }
                if(!ValidateData.checkEmpty(edt_password.getText().toString())){
                    edt_noti_password.setError("M???t kh???u kh??ng ???????c ????? tr???ng");
                }
                if(ValidateData.checkEmpty(edt_account.getText().toString())&&ValidateData.checkEmpty(edt_password.getText().toString())){
                    int i = AccountCommon.Login(accounts,edt_account.getText().toString(),edt_password.getText().toString());
                    switch (i){
                        case -1:
                            edt_noti_account.setError("T??i kho???n kh??ng ch??nh x??c");
                            break;
                        case 0:
                           startActivity(new Intent(LoginActivity.this, HomeFragment.class));
                            break;
                        case 1:
                            //login wiht admintranslator
                            break;
                        case 2:
                            edt_noti_password.setError("M???t kh???u kh??ng ch??nh x??c");
                            break;
                    }
                }

            }
        });

    }




    //disable back button
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "???n th??m 1 l???n n???a ????? tho??t", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}