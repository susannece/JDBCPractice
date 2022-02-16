package se.lexicon.model;

import java.time.LocalDateTime;

public class ShoppingCartItem {
    private int id;
    private int amount;
    private double totalPrice;
    private Product item;
    private ShoppingCart cart;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(int id, int amount, double totalPrice, Product item, ShoppingCart cart) {
        this.id = id;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.item = item;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                ", item=" + item +
                ", cart=" + cart +
                '}';
    }
}