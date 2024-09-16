package org.meicode.meimall;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<GroceryItem> items;
    private String address;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private double totalPrice;
    private String paymentMethod;
    private boolean success;

    public Order(ArrayList<GroceryItem> items, String address, String zipCode, String phoneNumber, String email, double totalPrice, String paymentMethod, boolean success) {
        this.id = Utils.getOrderId();
        this.items = items;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.success = success;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<GroceryItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<GroceryItem> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", success=" + success +
                '}';
    }
}
