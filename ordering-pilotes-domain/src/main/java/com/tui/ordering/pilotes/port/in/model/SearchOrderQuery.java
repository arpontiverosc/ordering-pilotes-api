package com.tui.ordering.pilotes.port.in.model;

public class SearchOrderQuery {

    private final String orderId;
    private final Integer pilotesNumber;
    private final String customerId;
    private final String customerFirstName;
    private final String customerLastName;

    public SearchOrderQuery(Builder builder) {
        this.orderId = builder.orderId;
        this.pilotesNumber = builder.pilotesNumber;
        this.customerId = builder.customerId;
        this.customerFirstName = builder.customerFirstName;
        this.customerLastName = builder.customerLastName;
    }

    public String getOrderId() {
        return orderId;
    }

    public Integer getPilotesNumber() {
        return pilotesNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }


    public static final class Builder {
        private String orderId;
        private Integer pilotesNumber;
        private String customerId;
        private String customerFirstName;
        private String customerLastName;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder pilotesNumber(Integer pilotesNumber) {
            this.pilotesNumber = pilotesNumber;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder customerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public SearchOrderQuery build() {
            return new SearchOrderQuery(this);
        }
    }
}
