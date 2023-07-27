package com.mycode.sparkspay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BiswalAdapter extends ArrayAdapter<String> {

    public static final String EXTRA_NAME = "com.mycode.sparkspay.extra.NAME";
    private ArrayList<String> arr;
    private Context context;

    public BiswalAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> arr) {
        super(context, resource, arr);
        this.context = context;
        this.arr = arr;
    }

    public String getItem(int position) {
        return arr.get(position);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_all_customers, parent, false);
        TextView t = convertView.findViewById(R.id.textView4);
        t.setText(getItem(position));

        // Before returning the view, add Click listener
        Intent intent = new Intent(context, MainActivity3.class);
        convertView.setOnClickListener(v -> {
            intent.putExtra(EXTRA_NAME, position);
            context.startActivity(intent);
        });

        return convertView;
    }
}
