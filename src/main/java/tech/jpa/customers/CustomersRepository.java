package tech.jpa.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer,Integer> {

    // Utilisation d'une projection pour retourner un DTO
    //@Query("SELECT new tech.jpa.customers.CustomerDTO(c.id, c.email) FROM Customer c WHERE c.email = :email")
    //CustomerDTO findByEmail(@Param("email") String email);

    Customer findByEmail(String mail);
}
