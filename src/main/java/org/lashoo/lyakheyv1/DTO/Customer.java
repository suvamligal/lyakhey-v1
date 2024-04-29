package org.lashoo.lyakheyv1.DTO;

import java.io.Serializable;
import java.util.List;

public record Customer(int id, String name, String username, String email, String password, List<Address> address) implements Serializable {

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + "\"" +
                ", \"username\":\"" + username + "\"" +
                ", \"email\":\"" + email + "\""  +
                ", \"password\":\"" + password + "\""  +
                ", \"address\":" + address +
                "}";

//        "cities\":[\"Amsterdam\", \"Tamassint\"]}";

    }

    public static class CustomerBuilder {
        private int id;
        private String name;
        private String username;
        private String email;
        private String password;
        private List<Address> address;

        public CustomerBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder username(String username) {
            this.username = username;
            return this;
        }

        public CustomerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder password(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder address(List<Address> address) {
            this.address = address;
            return this;
        }

        public Customer build(){
            return new Customer(id, name, username, email, password, address);
        }
    }

    public static CustomerBuilder builder(){
        return new CustomerBuilder();
    }

    public record Address(String streetName, String city, String State, String zipcode) {
        @Override
        public String toString() {
            return "{" +
                    "\"streetName\": \"" + streetName + "\"" +
                    ", \"city\":\"" + city + "\"" +
                    ", \"State\":\"" + State + "\"" +
                    ", \"zipcode\":\"" + zipcode + "\"" +
                    "}";
        }
    }
    }


