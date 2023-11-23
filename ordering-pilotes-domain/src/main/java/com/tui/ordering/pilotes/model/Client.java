package com.tui.ordering.pilotes.model;

public class Client {

    private final String clientId;
    private final String firstName;
    private final String lastName;

    public Client(Builder builder) {
        this.clientId = builder.clientId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public static final class Builder {
        private String clientId;
        private String firstName;
        private String lastName;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}
