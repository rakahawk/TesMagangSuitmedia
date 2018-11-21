package com.example.android.suitmedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView guest,event;
    TextView nama;

    String tamu,acara,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nama  = (TextView)findViewById(R.id.name2);
        guest = (TextView)findViewById(R.id.guest);
        event = (TextView)findViewById(R.id.event);
        //Get Intent Data
        final Intent intentGetData = getIntent();

        name = intentGetData.getStringExtra("nama");
        nama.setText(name);

        if (intentGetData.hasExtra("guest")){
            tamu = intentGetData.getStringExtra("guest");
            guest.setText(tamu);
        }else {
            guest.setText("Pilih Guest");
        }

        if (intentGetData.hasExtra("event")){
            if (intentGetData.getStringExtra("event") == null){
                event.setText("Pilih Event");
            }else {
                acara = intentGetData.getStringExtra("event");
                event.setText(acara);
            }
        }else {
            event.setText("Pilih Event");
        }

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(SecondActivity.this,ThirdActivity.class);
                newIntent.putExtra("nama",name);
                newIntent.putExtra("event",event.getText().toString());
                startActivity(newIntent);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent2 = new Intent(SecondActivity.this,FourthActivity.class);
                newIntent2.putExtra("nama",name);
                newIntent2.putExtra("guest",guest.getText().toString());
                newIntent2.putExtra("event",intentGetData.getStringExtra("event"));
                startActivity(newIntent2);
            }
        });

    }
}
