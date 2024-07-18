package tech.jpa.customers;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CutomersService {
    CustomersRepository customersRepository;

    public CutomersService(CustomersRepository customersRepository) {

        this.customersRepository = customersRepository;
    }

    public List<CustomerDTO>  search(){
       final  List<CustomerDTO> collect = this.customersRepository.findAll().stream().map(customer -> {
            return new CustomerDTO(customer.getId(), customer.getEmail());
        }).collect(Collectors.toList());
        return collect;
    }

    public CustomerDTO read(int id){
       Customer customer= this.customersRepository.findById(id).orElseThrow(()->
               new IllegalArgumentException("no customer for id"));
       return new CustomerDTO(customer.getId(),customer.getEmail());
    }

}
