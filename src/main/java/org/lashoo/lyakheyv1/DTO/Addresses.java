package org.lashoo.lyakheyv1.DTO;

public record Addresses(String streetName, String city, String State, String zipcode) {
    @Override
    public String toString() {
        return "{" +
                "\"streetName\":\"" + streetName +
                ", \"city\":\"" + city +
                ", \"State\":\"" + State +
                ", \"zipcode\":\"" + zipcode +
                "\"}"
        ;


//        "cities\":[\"Amsterdam\", \"Tamassint\"]}";
    }
}



