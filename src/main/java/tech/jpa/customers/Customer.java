package tech.jpa.customers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;

    // Constructeur privé utilisé par le Builder
    Customer(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
    }

    public Customer(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public Customer() {

    }

    // Getters
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }



    // Classe Builder
    public static class Builder {
        private int id;
        private String email;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
    // Méthode statique pour obtenir un Builder
    public static Builder builder() {
        return new Builder();
    }
}
