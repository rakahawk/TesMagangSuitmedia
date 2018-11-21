package com.example.android.suitmedia;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


// Event
public class FourthActivity extends AppCompatActivity {

    String name;

    int counter = 0;

    ImageView kembali,tambah;

   android.support.v4.app.Fragment fragmentSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        fragmentSelected = new EventFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome, fragmentSelected).commit();


        kembali = (ImageView)findViewById(R.id.kembali);
        tambah = (ImageView)findViewById(R.id.tambah);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentSelected = new MapsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome, fragmentSelected).commit();
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGetData = getIntent();
                String nama  = intentGetData.getStringExtra("nama");
                String guest = "";
                String eveent = "";
                if (intentGetData.hasExtra("guest")){
                    guest =  intentGetData.getStringExtra("guest");
                }
                if (intentGetData.hasExtra("event")){
                    eveent = intentGetData.getStringExtra("event");
                }
                Intent newIntent = new Intent(FourthActivity.this,SecondActivity.class);
                newIntent.putExtra("nama", nama);
                newIntent.putExtra("guest",guest);
                newIntent.putExtra("event",eveent);
                startActivity(newIntent);
                finish();
            }
            });

    }
}
