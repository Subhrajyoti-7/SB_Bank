package com.mycode.sparkspay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectReceiver extends AppCompatActivity {
    ListView listView;
    String Data_Base = "customerdb";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_receiver);

        DB_Handler handler = new DB_Handler(this, Data_Base, null, 1);

        Intent intent = getIntent();
        String senderName = intent.getStringExtra("gulubis");
        ArrayList<String> receivers = new ArrayList<>();
        List<Customers> customers = handler.getCustomer();
        for (Customers elements : customers) {
            receivers.add(elements.getName());
        }

        handler.close();

        ArrayAdapter ad = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, receivers);
        listView = findViewById(R.id.listViewRV);
        listView.setAdapter(ad);

        Intent receiver = new Intent(this, ReceiverDetails.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                receiver.putExtra("gulu", position);
                receiver.putExtra("gulubis", senderName);
                startActivity(receiver);
            }
        });
    }
}