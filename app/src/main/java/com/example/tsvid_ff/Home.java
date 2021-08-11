package com.example.tsvid_ff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class Home extends AppCompatActivity {

    MeowBottomNavigation meowBottomNavigation;
    public Toolbar toolbar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        meowBottomNavigation=findViewById(R.id.a1);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.tb);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_account_circle_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_assignment_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_search_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_support_agent_24));
        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment=null;
                switch (item.getId()){
                    case 1:
                        fragment=new TTCN();
                        toolbar.setTitle("QUẢNG LÝ CÁ NHÂN");
                        break;
                    case 2:
                        fragment=new DichVu();
                        toolbar.setTitle("DỊCH VỤ");
                        break;
                    case 3:
                        fragment=new TraCuu();
                        toolbar.setTitle("TRA CỨU THÔNG TIN");
                        break;
                    case 4:
                        fragment=new HoTro();
                        toolbar.setTitle("TRUNG TÂM HỖ TRỢ");
                        break;
                }
                loadfragmeny(fragment);
            }
        });
        meowBottomNavigation.show(1,true);
        adads();
        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
            }
        });

    }

    private void loadfragmeny(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.f1,fragment).commit();
    }
    public void adads() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_toc_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

}