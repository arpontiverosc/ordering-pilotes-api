package com.tui.ordering.pilotes.port.in.model;

public class UpdateOrderCommand {

    private final String orderId;
    private final String userIdentifier;
    private final OrderAddress deliveryAddress;
    private final Integer pilotesNumber;
    private final String email;

    private UpdateOrderCommand(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.deliveryAddress = builder.deliveryAddress;
        this.pilotesNumber = builder.pilotesNumber;
        this.orderId = builder.orderId;
        this.email = builder.email;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public OrderAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public Integer getPilotesNumber() {
        return pilotesNumber;
    }

    public String getOrderId() {
        return orderId;
    }


    public String getEmail() {
        return email;
    }

    public static final class Builder {

        private String orderId;
        private String userIdentifier;
        private OrderAddress deliveryAddress;
        private int pilotesNumber;
        private String email;


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

        public Builder deliveryAddress(OrderAddress deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder pilotes(Integer pilotesNumber) {
            this.pilotesNumber = pilotesNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UpdateOrderCommand build() {
            return new UpdateOrderCommand(this);
        }
    }
}
