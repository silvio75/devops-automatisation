package tech.jpa.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class CutomersServiceTest {
   // on veut simuler la couche inférieur du service qui est repository
    // on ne veut pas l'utiliser, on faire une copie de cette couche avec des mocks
    @Mock
    CustomersRepository  customersRepository;

    //on veut tester le customerservice => on injecte la classe à tester
    // mettre à disposition la classe à tester
     @InjectMocks
    CutomersService cutomersService;
    @Test
    void shouldReturnAllCustomers() {
     //Arrange
     Customer customerOne = Customer.builder().id(1).email("t_sylvere@hotmail.fr").build();
     Customer customerTwo = Customer.builder().id(2).email("test@test.fr").build();
     // quand on demande à bdd de retourne une list elle retourne des mock
     // Simuler le comportement du repository pour retourner une liste
     //when(customersRepository.findAll()).thenReturn(List.of(customerOne, customerTwo));

     // Act
     final List<CustomerDTO> customerList = this.cutomersService.search();

     //Asserts
     Assertions.assertEquals(2, customerList.size());
    }


 @Test
 void shouldReturnCustomersForId() {
  //Arrange
  Customer customerOne = Customer.builder().id(1).email("t_sylvere@hotmail.fr").build();

  // quand on demande à bdd de retourne une list elle retourne des mock
  // Simuler le comportement du repository pour retourner une liste
//  when(this.customersRepository.findById(1)).thenReturn(Optional.of(customerOne));

  // Act
  final CustomerDTO customer = this.cutomersService.read(1);

  //Asserts
  Assertions.assertEquals(customerOne.getId(), customer.getId());
 }


 @Test
 void shouldThrowException() {
  //Arrange
// when(this.customersRepository.findById(anyInt())).thenReturn(Optional.empty());

  // Act
  //Asserts
  IllegalAccessException exception = assertThrows(IllegalAccessException.class,
          () -> this.cutomersService.read(1));

  assertEquals("no customer for id",exception.getMessage() );
 }




}