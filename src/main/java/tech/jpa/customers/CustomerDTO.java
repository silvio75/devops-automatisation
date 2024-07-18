package tech.jpa.customers;

public class CustomerDTO {
    private int id;
    private String email;

    // Constructeur et getters
    public CustomerDTO(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
