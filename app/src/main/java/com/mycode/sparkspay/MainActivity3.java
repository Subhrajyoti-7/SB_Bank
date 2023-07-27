package com.mycode.sparkspay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    String Data_Base = "customerdb";

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        DB_Handler handler = new DB_Handler(this, Data_Base, null, 1);
        textView1 = findViewById(R.id.textView10);
        textView2 = findViewById(R.id.textView11);
        textView3 = findViewById(R.id.textView12);
        textView4 = findViewById(R.id.textView13);
        textView5 = findViewById(R.id.textView14);
        textView6 = findViewById(R.id.textView15);
        Intent intent = getIntent();

        int index = intent.getIntExtra(BiswalAdapter.EXTRA_NAME, -1);

        List<Customers> customers = handler.getCustomer();
        textView1.setText(customers.get(index).getName());
        textView2.setText(customers.get(index).getAcNo());
        textView3.setText(customers.get(index).getMob());
        textView4.setText(customers.get(index).getEmail());
        textView5.setText(String.valueOf(customers.get(index).getBalance()));
        textView6.setText(customers.get(index).getGender());

        String senderName = customers.get(index).getName();

        handler.close();

        button = findViewById(R.id.buttonRV);
        Intent intent1 = new Intent(this, SelectReceiver.class);
        button.setOnClickListener(v -> {
            intent1.putExtra("gulubis", senderName);
            startActivity(intent1);
        });
    }
}