package com.mycode.sparkspay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button, button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity2.class);
        button = findViewById(R.id.button2);
        button1 = findViewById(R.id.button1);

        button.setOnClickListener(v -> {
            startActivity(intent);
        });

        Intent transac = new Intent(this, TransactionHistory.class);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(transac);
            }
        });
    }
}