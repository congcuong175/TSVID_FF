package com.example.tsvid_ff.Fragment;


import static com.example.tsvid_ff.Activity.LoginActivity.dbContext;
import static com.example.tsvid_ff.Common.AccountCommon.ID_ACCOUNT;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.tsvid_ff.Entity.Account;
import com.example.tsvid_ff.R;
import com.squareup.picasso.Picasso;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import static com.example.tsvid_ff.Common.AccountCommon.acc;

import java.util.ArrayList;

public class HomeFragment extends AppCompatActivity {

    MeowBottomNavigation meowBottomNavigation;
    public Toolbar toolbar;
    DrawerLayout drawerLayout;
    ArrayList<String> arrayList;
   public static ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        meowBottomNavigation=findViewById(R.id.a1);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.tb);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_account_circle_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_assignment_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_search_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_support_agent_24));
        meowBottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        navController.navigate(R.id.TTCN);
                        toolbar.setTitle("QU???N L?? C?? NH??N");

                        break;
                    case 2:
                        navController.navigate(R.id.dichVu);
                        toolbar.setTitle("D???CH V???");
                        break;

                    case 3:
                        navController.navigate(R.id.traCuu);
                        toolbar.setTitle("TRA C???U TH??NG TIN");
                        break;
                    case 4:
                        navController.navigate(R.id.hoTro);
                        toolbar.setTitle("TRUNG T??M H??? TR???");
                        break;
                }
                return null;
            }
        });

        meowBottomNavigation.show(1,true);
        adads();


        arrayList=new ArrayList<>();
        arrayList.add("Tu???n 1");
        arrayList.add("Tu???n 2");
        arrayList.add("Tu???n 3");
        arrayList.add("Tu???n 4");
        arrayList.add("Tu???n 5");
        arrayList.add("Tu???n 6");
        arrayAdapter=new ArrayAdapter<>(getApplicationContext(),R.layout.texttuanhoc,arrayList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.thongbao, menu);
        return true;
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