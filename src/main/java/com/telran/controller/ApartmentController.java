package com.telran.controller;

import com.telran.entity.Apartment;
import com.telran.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/apartments")
public class ApartmentController {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @GetMapping("/location")
    public List<Apartment> searchApartments(
            @RequestParam(value = "owner", required = false) String owner,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "street", required = false) String street) {
        if (owner == null) {
            return new ArrayList<>();
        }

        //Передали owner в запросе
        if (city != null && street != null) {
            return apartmentRepository.findAllByOwnerAndCityAndStreet(owner, city, street);
        }

        if (city != null) {
            return apartmentRepository.findAllByOwnerAndCity(owner, city);
        }

        return apartmentRepository.findAllByOwner(owner);

    }

    @GetMapping("/price")
    public List<Apartment> searchByPriceRange(@RequestParam(value = "price-min", required = false) Integer priceMin,
                                              @RequestParam(value = "price-max", required = false) Integer priceMax) {
        if (priceMin == null && priceMax == null) {
//            return apartmentRepository.findAll();
            return new ArrayList<>();
        }

        if (priceMin != null && priceMax != null) {
            return apartmentRepository.findAllByPriceGreaterThanAndPriceLessThan(priceMin, priceMax);
        }

        return apartmentRepository.findAll();
    }
}
