package com.example.prarrambh;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

ListView lview;
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;

TextView uname, ucollege;

String pr[] = {"Literary Arts", "Fine Arts", "Performing Arts", "Sports"};
int primg2[] = {R.drawable.la2,R.drawable.fa2,R.drawable.pa2,R.drawable.sport1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawl);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.ss, "", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ss1, "Group Dance", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ss2, "", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ssing, "Singing", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ssing1, "", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.sshr, "Sher-O-Shayeri", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.scar, "Carrom Competition", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.scar2, "", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.sdare, "Dare to eat", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.sches, "Chess", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.sches1, "", ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);


        lview = findViewById(R.id.prParts);
        listAdap practivity = new listAdap(getApplicationContext(), pr, primg2);
        lview.setAdapter(practivity);

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, list1.class));
                }
                if (i == 1) {
                    startActivity(new Intent(MainActivity.this, list2.class));
                }
                if (i == 2) {
                    startActivity(new Intent(MainActivity.this, list3.class));
                }
                if (i == 3) {
                    startActivity(new Intent(MainActivity.this, list4.class));
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.nav_facebook){
            gotoUrl("https://www.facebook.com/Prarrambh");
        } else if (id==R.id.nav_instagram) {
            gotoUrl("https://www.instagram.com/prarrambh/");
        } else if (id==R.id.nav_youtube) {
            gotoUrl("https://www.youtube.com/c/PrarrambhNaviMumbaiOfficial");
        } else if (id==R.id.nav_web) {
            gotoUrl("https://setrgc.edu.in/");
        }
        else if (id==R.id.nav_info) {
            gotoUrl("https://setrgc.edu.in/prarambh-2/");
        }
        else if (id==R.id.nav_schedule){
            startActivity(new Intent(MainActivity.this,list1.class));
        }
        else if (id==R.id.nav_logout){
            logoutUser();
            return true;
        }
        return true;
    }
    private void logoutUser() {
        FirebaseAuth.getInstance().signOut();
        // Redirect to login activity
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    }


