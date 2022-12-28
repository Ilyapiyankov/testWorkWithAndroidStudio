package com.example.myapplication.model;


public class Product {

    private String name;
    private String date;
    private Integer howMany;
    private Integer price;

    public Product(String name, String date, Integer howMany, Integer price) {
        this.date = date;
        this.howMany = howMany;
        this.name = name;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Integer getHowMany() {
        return howMany;
    }

    public Product Copy() {
        return new Product(
                this.name,
                this.date,
                this.howMany,
                this.price
        );
    }

    @Override
    public String toString() {
        String ans = String.format(
                "название: %s\nдобавлен: %s\nвналичии: %d\nцена за штуку: %d",
                name,
                date,
                howMany,
                price
        );

        return ans;
    }
}
