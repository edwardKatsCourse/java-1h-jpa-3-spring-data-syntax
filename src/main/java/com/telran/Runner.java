package com.telran;

import com.telran.entity.Apartment;
import com.telran.repository.ApartmentRepository;
import com.telran.utils.RandomApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ApartmentRepository apartmentRepository;


    @Override
    public void run(String... args) throws Exception {

        List<Apartment> apartments = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            apartments.add(RandomApartment.getApartment());
        }

        apartmentRepository.saveAll(apartments); //bulk / batch



        //100 / results = pages total
        //91-100

        //results = 10 (20) | pageNumber = 3
        //1-20
        //21-40
        //61-80

        //100 / results = pages total (5)



    }
}
