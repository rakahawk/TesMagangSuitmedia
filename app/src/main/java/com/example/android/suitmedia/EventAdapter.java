package com.example.android.suitmedia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yudhistira Caraka on 11/3/2018.
 */

public class EventAdapter extends ArrayAdapter<Event> {


    public EventAdapter(Context context, ArrayList<Event>event){
        super(context,0,event);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View listItemView = convertView;
       if (listItemView == null){
           listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_event,parent,false);
       }

       Event currentEvent = getItem(position);

       ImageView imageEvent = (ImageView)listItemView.findViewById(R.id.gambarEvent);
       TextView namaEvent = (TextView)listItemView.findViewById(R.id.namaEvent);
       TextView tglEvent = (TextView)listItemView.findViewById(R.id.tglEvent);
       TextView keterangan = (TextView)listItemView.findViewById(R.id.keterangan);

       namaEvent.setText(currentEvent.getNama());
       tglEvent.setText(currentEvent.getTanggal());
       imageEvent.setImageResource(currentEvent.getGambar());
       keterangan.setText(currentEvent.getKeterangan());

       return listItemView;
    }



}
