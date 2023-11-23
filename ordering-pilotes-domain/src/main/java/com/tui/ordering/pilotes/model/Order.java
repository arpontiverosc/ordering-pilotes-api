package com.tui.ordering.pilotes.model;



public class Order {

    private final String orderId;
    private final String userIdentifier;
    private final Address deliveryAddress;
    private final int pilotes;
    private final double orderTotal;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.userIdentifier = builder.userIdentifier;
        this.orderTotal = builder.orderTotal;
        this.pilotes = builder.pilotes;
        this.deliveryAddress = builder.deliveryAddress;
    }

    public String getUserIdentier() {
        return userIdentifier;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getPilotes() {
        return pilotes;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getOrderId() {
        return orderId;
    }

    public static final class Builder {
        private String orderId;
        private String userIdentifier;
        private Address deliveryAddress;
        private int pilotes;
        private double orderTotal;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder userIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder deliveryAddress(Address deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder pilotes(int pilotes) {
            this.pilotes = pilotes;
            return this;
        }

        public Builder orderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
