package tech.jpa.customers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path="customers")
public class CustomersController {

    private final CutomersService cutomersService;


    public CustomersController(CutomersService cutomersService) {
        this.cutomersService = cutomersService;
    }
    @GetMapping
    public List<CustomerDTO> search(){
        return this.cutomersService.search();
    }

    @GetMapping(path="{id}")
    public CustomerDTO read(@PathVariable int id){
        return this.cutomersService.read(id);
    }
}
