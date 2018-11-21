package com.example.android.suitmedia;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Yudhistira Caraka on 11/20/2018.
 */

public class MapsFragment extends Fragment {
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
        v = inflater.inflate(R.layout.fragment_maps, container, false);
        return v;

    }

}
