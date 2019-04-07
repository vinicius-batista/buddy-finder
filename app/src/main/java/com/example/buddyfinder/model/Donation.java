package com.example.buddyfinder.model;

public class Donation {
    private String kind;
    private String quantity;
    private String description;
    private String status;

    public Donation(String kind, String quantity, String description) {
        this.kind = kind;
        this.quantity = quantity;
        this.description = description;
        this.status = "open";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
