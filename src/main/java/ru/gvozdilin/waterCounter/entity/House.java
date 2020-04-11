package ru.gvozdilin.waterCounter.entity;

public class House {
    private String address;
    private long indication;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getIndication() {
        return indication;
    }

    public void setIndication(long indication) {
        this.indication = indication;
    }

}
