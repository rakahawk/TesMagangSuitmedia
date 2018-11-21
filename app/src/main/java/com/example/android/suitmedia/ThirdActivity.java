package com.example.android.suitmedia;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


// Guest
public class ThirdActivity extends AppCompatActivity {

    GridView grid;

    SwipeRefreshLayout refreshLayout;

    String name,birthdate;

    int counter = 0;

    int id;

    ArrayList<Guest> guestsList;

    private String TAG = ThirdActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        grid = (GridView)findViewById(R.id.gridview);
        guestsList = new ArrayList<Guest>();

        refreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);

        final ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        refreshLayout.setRefreshing(false);
                        if (manager.getActiveNetworkInfo() != null){
                            if (counter == 0 ){
                                if (manager.getActiveNetworkInfo() != null){
                                    new GetGuest().execute();
                                    counter = 1;
                                }else {
                                    Toast.makeText(ThirdActivity.this, "Silahkan nyalakan internet terlebih dahulu", Toast.LENGTH_SHORT).show();
                                }
                            }
                            counter = 1;
                        }else {
                            Toast.makeText(ThirdActivity.this, "Silahkan nyalakan internet terlebih dahulu", Toast.LENGTH_SHORT).show();
                        }
                    }

                }, 1000); // Delay in millis

            }
        });

        if (counter == 0 ){
            if (manager.getActiveNetworkInfo() != null){
                new GetGuest().execute();
                counter = 1;
            }else {
                Toast.makeText(this, "Silahkan nyalakan internet terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private class GetGuest extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ThirdActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String url = "https://dry-sierra-6832.herokuapp.com/api/people/";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);

                    int lenth = jsonArray.length();

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        id = jsonObject.getInt("id");
                        name = jsonObject.getString("name");
                        birthdate = jsonObject.getString("birthdate");

                        Log.d("name",name);

                        Guest guest = new Guest(id,name,birthdate,R.drawable.index);

                        guestsList.add(guest);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            GuestAdapter gsA = new GuestAdapter(ThirdActivity.this, guestsList);

            grid.setAdapter(gsA);

            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intentGetData = getIntent();
                    String nama = intentGetData.getStringExtra("nama");
                    String event = "";
                    if (intentGetData.hasExtra("event")){
                        event = intentGetData.getStringExtra("event");
                    }


                    Guest gst = guestsList.get(i);
                    String tanggal = gst.getBirthday();

                    String tgl = tanggal.substring(8);
                    int tglSubt = Integer.parseInt(tgl);

                    String bulan = tanggal.substring(5,7);
                    int bulanSubt = Integer.parseInt(bulan);

                    if (tglSubt % 2 == 0 && tglSubt % 3 == 0){
                        Toast.makeText(ThirdActivity.this, tglSubt + " iOs", Toast.LENGTH_SHORT).show();
                    }else if (tglSubt % 2 == 0){
                        Toast.makeText(ThirdActivity.this, tglSubt + " blackberry", Toast.LENGTH_SHORT).show();
                    }else if (tglSubt % 3 == 0){
                        Toast.makeText(ThirdActivity.this, tglSubt + " android", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ThirdActivity.this, tglSubt + " feature phone", Toast.LENGTH_SHORT).show();
                    }

                    isPrimeNumber(bulanSubt);

                    Intent newIntent = new Intent(ThirdActivity.this,SecondActivity.class);
                    newIntent.putExtra("guest",gst.getName());
                    newIntent.putExtra("nama", nama);
                    newIntent.putExtra("event",event);
                    startActivity(newIntent);
                    finish();
                }
            });
        }
    }

    private void isPrimeNumber(int bulaan) {
        int num = bulaan, i = 2;
        boolean prima = false;
        while(i <= num/2) {
            if(num % i == 0) {
                prima = true;
                break;
            }
            ++i;
        }

        if (!prima)
            Toast.makeText(this, bulaan + " bulan prima", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, bulaan + " bukan bulan prima", Toast.LENGTH_SHORT).show();
    }

}
