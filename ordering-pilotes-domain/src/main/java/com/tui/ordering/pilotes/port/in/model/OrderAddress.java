package com.tui.ordering.pilotes.port.in.model;

public class OrderAddress {

    private final String street;
    private final String postcode;
    private final String city;
    private final String country;

    private OrderAddress(Builder builder) {
        this.street = builder.street;
        this.postcode = builder.postcode;
        this.city = builder.city;
        this.country = builder.country;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }


    public static final class Builder {
        private String street;
        private String postcode;
        private String city;
        private String country;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public OrderAddress build() {
            return new OrderAddress(this);
        }
    }
}
