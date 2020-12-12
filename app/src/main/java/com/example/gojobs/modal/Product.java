package com.example.gojobs.modal;

public class Product {
    private String id;
    private String name;
    private String price;
    private String category;
    private int yearManufacture;
    private String image;

    public Product(String name, String category, String price, int yearManufacture) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.yearManufacture = yearManufacture;
    }

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", image=" + image +
                '}';
    }
}
