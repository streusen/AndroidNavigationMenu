package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment= new HomeFragment();
    ProfileFragment profileFragment=new ProfileFragment();
    SettingsFragment settingsFragment=new SettingsFragment();
    NotificationFragment notificationFragment=new NotificationFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                int itemID=item.getItemId();
                if (itemID==R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                }
                else if(itemID==R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                }
                else if(itemID==R.id.notification){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                }
                else if(itemID==R.id.settings){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
                }

                return false;
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}