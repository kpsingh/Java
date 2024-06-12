package com.java.optionals;

public class Address {
    private int lane;
    private String locality;
    private String ladmark;
    private Address address;

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLadmark() {
        return ladmark;
    }

    public void setLadmark(String ladmark) {
        this.ladmark = ladmark;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
