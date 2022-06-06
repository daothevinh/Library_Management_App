package com.example.quanlythuvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quanlythuvien.Adapter.ViewPager_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Main_Activity extends BaseActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2;
    private ViewPager_Adapter viewPager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        viewPager_adapter = new ViewPager_Adapter(this);
        viewPager2.setAdapter(viewPager_adapter);

        viewPager2.setCurrentItem(1);
        bottomNavigationView.getMenu().findItem(R.id.homeBottom).setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.homeBottom:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.userBottom:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.bookInformationBottom:
                        viewPager2.setCurrentItem(2);
                }
                return true;
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.homeBottom).setChecked(true);
                        break;
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.userBottom).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.bookInformationBottom).setChecked(true);
                        break;
                }
            }
        });
    }

    private void init() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager2);

    }
}