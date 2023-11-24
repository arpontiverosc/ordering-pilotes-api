package com.tui.ordering.pilotes.port.in.model;

public class UpdateOrderCommand {

    private final String orderId;
    private final String userIdentifier;
    private final OrderAddress deliveryAddress;
    private final int pilotesNumber;

    private UpdateOrderCommand(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.deliveryAddress = builder.deliveryAddress;
        this.pilotesNumber = builder.pilotesNumber;
        this.orderId = builder.orderId;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public OrderAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getPilotesNumber() {
        return pilotesNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public static final class Builder {

        private String orderId;
        private String userIdentifier;
        private OrderAddress deliveryAddress;
        private int pilotesNumber;

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

        public Builder pilotes(int pilotesNumber) {
            this.pilotesNumber = pilotesNumber;
            return this;
        }

        public UpdateOrderCommand build() {
            return new UpdateOrderCommand(this);
        }
    }
}
