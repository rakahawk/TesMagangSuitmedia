package com.example.android.suitmedia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yudhistira Caraka on 11/3/2018.
 */

public class GuestAdapter extends ArrayAdapter<Guest> {

    public GuestAdapter(@NonNull Context context, ArrayList<Guest>guest) {
        super(context, 0,guest);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridListItem = convertView;
        if (gridListItem == null){
            gridListItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_guest,parent,false);
        }

        Guest currentGuest = getItem(position);

        ImageView gmbarGuest = (ImageView)gridListItem.findViewById(R.id.gambarGuest);
        TextView namaGuest = (TextView)gridListItem.findViewById(R.id.namaGuest);

        gmbarGuest.setImageResource(currentGuest.getGambar());
        namaGuest.setText(currentGuest.getName());


        return gridListItem;
    }
}
