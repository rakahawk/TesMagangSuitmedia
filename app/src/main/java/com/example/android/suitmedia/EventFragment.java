package com.example.android.suitmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Yudhistira Caraka on 11/20/2018.
 */

public class EventFragment extends Fragment {

    private View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Context x;
    public Activity a;
    @Override
    public void onAttach(Context context) {
        x = context;
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        a = activity;
        super.onAttach(activity);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_event, container, false);
        loadData();
        return v;

    }

    private void loadData(){
        String keterangan1 = "Acara seminar A ini diadakan di tempat bla bla bla bla";
        String keterangan2 = "Acara Pesta Ulangtahun  A ini diadakan di tempat bla bla bla bla";
        String keterangan3 = "Acara Pesta Ulangtahun  B ini diadakan di tempat bla bla bla bla";
        String keterangan4 = "Acara seminar B ini diadakan di tempat bla bla bla bla";

        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("Acara Seminar A","24-10-2018",R.drawable.new_statesman_events,keterangan1));
        events.add(new Event("Acara Pesta Ulangtahun A","25-10-2018",R.drawable.pesta1,keterangan2));
        events.add(new Event("Acara Pesta Ulangtahun B","26-10-2018",R.drawable.pesta2,keterangan3));
        events.add(new Event("Acara Seminar B","27-10-2018",R.drawable.new_statesman_events,keterangan4));

        EventAdapter eventAdapter = new EventAdapter(getActivity(), events);

        ListView listView = (ListView)v.findViewById(R.id.listItem);


        listView.setAdapter(eventAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentGetData = getActivity().getIntent();
                String nama  = intentGetData.getStringExtra("nama");
                String guest = "";
                if (intentGetData.hasExtra("guest")){
                    guest =  intentGetData.getStringExtra("guest");
                }

                Event evnt = events.get(i);
                Intent newIntent = new Intent(getActivity(),SecondActivity.class);
                newIntent.putExtra("event",evnt.getNama());
                newIntent.putExtra("nama", nama);
                newIntent.putExtra("guest",guest);
                startActivity(newIntent);
            }
        });
    }


}
