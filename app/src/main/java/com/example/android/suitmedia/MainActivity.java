package com.example.android.suitmedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView next;
    EditText nama;
    String kata= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText)findViewById(R.id.name);
        next = (TextView)findViewById(R.id.send);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kata = nama.getText().toString().trim();
                String potong = kata.replaceAll("\\s","");
                if (TextUtils.isEmpty(kata)){
                    nama.setError("Required");
                }else {
                    if (isPolindrome(potong)){
                        Toast.makeText(MainActivity.this, kata + " is Polindrome", Toast.LENGTH_SHORT).show();
                    }else {
                        nama.setText("");
                        Toast.makeText(MainActivity.this, kata + " is not Polindrome", Toast.LENGTH_SHORT).show();
                    }
                    Intent kirim = new Intent(MainActivity.this,SecondActivity.class);
                    //Intent kirim = new Intent(MainActivity.this,FourthActivity.class);
                    kirim.putExtra("nama",kata);
                    nama.setText("");
                    startActivity(kirim);
                    finish();
                }
            }
        });
    }

    private boolean isPolindrome(String word){
        String polindrome;
        StringBuffer temp = new StringBuffer(word);
        polindrome = temp.reverse().toString().trim();
        String polin = polindrome.replaceAll("\\s","");
        if (word.equalsIgnoreCase(polin)){
            return true;
        }else {
            return false;
        }
    }
}
