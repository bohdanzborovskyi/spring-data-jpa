package com.example.springdatajpa;

import com.example.springdatajpa.model.Rental;
import com.example.springdatajpa.service.CustomerService;
import com.example.springdatajpa.service.FilmService;
import com.example.springdatajpa.service.RentalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringDataJpaApplicationTests {

    @Autowired
    RentalService rentalService;

    @Autowired
    FilmService filmService;

    @Autowired
    CustomerService customerService;


    @Test
    void contextLoads() {
    }

    @Test
    void findAllRentalByCustomerId()
    {
        List<Rental> rentals =  rentalService.findAllRentalByCustomerID(0L);
        assertThat(rentals.size()).isEqualTo(2);
        assertThat(rentals.get(0).getCustomer().getCustomer_id()).isEqualTo(0L);
    }

    @Test
    void findMoviesByActorFirstnameAndLastname()
    {
        assertThat(filmService.findAllByActors("Ivan","Bodrov").get(0).getTitle()).isEqualTo("Godzilla");
    }

    @Test
    void getCustomerAddress()
    {
        assertThat(customerService.getCustomerInfoAndAdress(0L).getAddress()).isEqualTo("Polish");
        assertThat(customerService.getCustomerInfoAndAdress(0L).getAddress2()).isEqualTo("Sosnowiec, ul.Rybak 18");
        assertThat(customerService.getCustomerInfoAndAdress(0L).getDistinct()).isEqualTo("Silesian");
        assertThat(customerService.getCustomerInfoAndAdress(0L).getPostal_code()).isEqualTo("41-200");
        assertThat(customerService.getCustomerInfoAndAdress(0L).getPhone()).isEqualTo("880-090-098");
    }


}
