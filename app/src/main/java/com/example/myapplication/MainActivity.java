package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.Product;
import com.example.myapplication.service.Stock;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    protected static Stock stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        stock = new Stock(new LinkedList<Product>());
        setContentView(R.layout.activity_main);
    }

    public void search(View view) {
        Intent intent = new Intent(this, FindingProduct.class);
        startActivity(intent);
    }

    public void addProduct(View view) {

        String name, date;
        Integer inStock, priceForOne;
        Toast toast;
        EditText reader;

        try {
            reader = findViewById(R.id.nameOfProduct);
            name = reader.getText().toString().trim();

            if (name ==""){
                throw new Exception();
            }

            reader = findViewById(R.id.dateOfAdding);
            date = reader.getText().toString().trim();

            if (date ==""){
                throw new Exception();
            }

            reader = findViewById(R.id.numberInStock);

            inStock = Integer.parseInt( reader.getText().toString().trim() );

            reader = findViewById(R.id.priceForOne);
            priceForOne = Integer.parseInt( reader.getText().toString().trim() );

            Product product = new Product(
                    name,
                    date,
                    inStock,
                    priceForOne);

            boolean flag = stock.addProduct(product);

            if (!flag) {
                toast = Toast.makeText(this, "You already have this product!", Toast.LENGTH_LONG);
            } else {
                toast = Toast.makeText(this, "OK", Toast.LENGTH_LONG);
            }
        } catch (Exception exception) {

            toast = Toast.makeText(this, "возникла ошибка!", Toast.LENGTH_LONG);

        }

        toast.show();

    }
}