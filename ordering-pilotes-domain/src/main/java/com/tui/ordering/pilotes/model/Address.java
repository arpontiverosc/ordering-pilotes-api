package com.tui.ordering.pilotes.model;

public class Address {

    private final String addressId;
    private final String street;
    private final String postcode;
    private final String city;
    private final String country;

    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.street = builder.street;
        this.postcode = builder.postcode;
        this.city = builder.city;
        this.country = builder.country;
    }

    public String getAddressId() {
        return addressId;
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

    @Override
    public String toString() {
        return addressId + '\'' + ", " + street + '\'' + ", " + postcode + '\'' + ", " + city + '\'' + ", " + country + '\'';
    }

    public static final class Builder {

        private String addressId;
        private String street;
        private String postcode;
        private String city;
        private String country;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
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

        public Address build() {
            return new Address(this);
        }
    }
}
