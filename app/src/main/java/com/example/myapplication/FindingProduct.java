package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FindingProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_product);
    }

    public void printInfo(View view) {

        TextView textView = findViewById(R.id.output);
        EditText editText = findViewById(R.id.input);

        String ans = MainActivity.stock.getProduct(editText.getText().toString());

        textView.setText(ans);

    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}