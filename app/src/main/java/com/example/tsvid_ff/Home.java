package com.example.tsvid_ff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class Home extends AppCompatActivity {

    MeowBottomNavigation meowBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        meowBottomNavigation=findViewById(R.id.a1);
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
                        break;
                    case 2:
                        fragment=new DichVu();break;
                    case 3:
                        fragment=new TraCuu();break;
                    case 4:
                        fragment=new HoTro();break;
                }
                loadfragmeny(fragment);
            }
        });
        meowBottomNavigation.show(1,true);
    }

    private void loadfragmeny(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.f1,fragment).commit();
    }
}