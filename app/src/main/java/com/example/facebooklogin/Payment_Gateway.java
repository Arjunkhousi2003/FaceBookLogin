  package com.example.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

  public class Payment_Gateway extends AppCompatActivity {

    Button pay_buttom;
    EditText pay_money;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_gateway);

        pay_buttom=findViewById(R.id.pay);
        pay_money=findViewById(R.id.payment_button);


        pay_buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Payment_Gateway.this,PayUPaymentActivity.class);
                startActivity(i);
            }
        });





    }
}