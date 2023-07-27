package com.mycode.sparkspay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ReceiverDetails extends AppCompatActivity {

    String Data_Base = "customerdb";

    TextView textViewName;
    TextView textViewAc;
    TextView textViewMob;
    TextView textViewLoc;
    TextView textViewAge;
    TextView textViewGen;

    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_details);

        DB_Handler handler = new DB_Handler(this, Data_Base, null, 1);

        textViewName = findViewById(R.id.recvName);
        textViewAc = findViewById(R.id.recvAc);
        textViewMob = findViewById(R.id.recvMob);
        textViewLoc = findViewById(R.id.recvLoc);
        textViewAge = findViewById(R.id.recvAge);
        textViewGen = findViewById(R.id.recvGen);

        button = findViewById(R.id.buttonContTras);

        List<Customers> customers = handler.getCustomer();

        Intent intent = getIntent();
        int index = intent.getIntExtra("gulu", -1);
        String senderName = intent.getStringExtra("gulubis");

        textViewName.setText(customers.get(index).getName());
        textViewAc.setText(customers.get(index).getAcNo());
        textViewMob.setText(customers.get(index).getMob());
        textViewLoc.setText(customers.get(index).getEmail());
        textViewAge.setText(String.valueOf(customers.get(index).getBalance()));
        textViewGen.setText(customers.get(index).getGender());

        String receiverName = customers.get(index).getName();

        handler.close();

        Intent intent1 = new Intent(this, PaymentPage.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1.putExtra("senderGulu", senderName);
                intent1.putExtra("receiverGulu", receiverName);
                startActivity(intent1);
            }
        });
    }
}