package com.mycode.sparkspay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentPage extends AppCompatActivity {

    TextView textView1, textView2;
    EditText editText;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        textView1 = findViewById(R.id.sendertext);
        textView2 = findViewById(R.id.receiverText);
        editText = findViewById(R.id.amountInput);
        button = findViewById(R.id.payButton);

        Intent intent = getIntent();
        String senderName = intent.getStringExtra("senderGulu");
        String receiverName = intent.getStringExtra("receiverGulu");

        textView1.setText(senderName);
        textView2.setText(receiverName);

        button.setOnClickListener(v -> {

            String text = editText.getText().toString();
//            int amount = Integer.parseInt(text);
            if(!text.equals("")) {
                Toast.makeText(PaymentPage.this, "Payment of " + text + " is Done", Toast.LENGTH_SHORT).show();
                onButtonShowPopupWindowClick(v);
                editText.setText("");
                new Handler().postDelayed(() -> {
                    Intent intent1 = new Intent(PaymentPage.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                }, 5000);
            } else {
                finish();
                startActivity(getIntent());
                Toast.makeText(this, "Please Enter some amount", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(view, Gravity.START, 0, -400);

        // dismiss the popup window when touched
        popupView.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;
        });
    }
}