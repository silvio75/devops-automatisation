package tech.jpa.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomersRepositoryTest {
    @Autowired
    CustomersRepository customersRepository;

    @Test
    public void shouldReturnAllCustomers() {
        //Arrange
        Customer customerOne = Customer.builder().id(1).email("t_sylvere@hotmail.fr").build();
        Customer customerTwo = Customer.builder().id(2).email("test@test.fr").build();
        this.customersRepository.saveAll(List.of(customerOne, customerTwo));
        //Act
        final List<Customer> customerList = this.customersRepository.findAll();

        //Asserts
        Assertions.assertEquals(2, customerList.size());
    }

    @Test
    public void shouldReturnCustomerByEmail() {
        //Arrange
        Customer customerOne = Customer.builder().id(1).email("t_sylvere@hotmail.fr").build();
        Customer customerTwo = Customer.builder().id(2).email("test@test.fr").build();
        this.customersRepository.saveAll(List.of(customerOne, customerTwo));
        //Act
        final Customer customer= this.customersRepository.findByEmail("test@test.fr");

        //Asserts
        Assertions.assertEquals(2, customer.getId());
        Assertions.assertEquals("test@test.fr", customer.getEmail());
    }
}
