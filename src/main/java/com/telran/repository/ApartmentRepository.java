package com.telran.repository;

import com.telran.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    //Apartment             - findBy        + FieldName + AND/OR + AnotherField
    //List<Apartment>       - findAllBy     + FieldName

    List<Apartment> findAllByOwner(String owner);
    List<Apartment> findAllByOwnerAndCity(String owner, String city);
    List<Apartment> findAllByOwnerAndCityAndStreet(String owner, String city, String street);

    List<Apartment> findAllByPriceGreaterThanAndPriceLessThan(Integer priceMin /*500_000*/, Integer priceMax);

    //todo
    //Price min only
    //price max only


    List<Apartment> findByOwnerAndCityAndPriceGreaterThan(String owner, String city, Integer minPrice);
    List<Apartment> findByOwnerAndCityAndPriceGreaterThanAndPriceLessThan(String owner, String city, Integer minPrice, Integer maxPrice);






    //JPQL (Java Persistence Query Language)
    @Query(value = "select a from Apartment a where a.city = :city and a.owner = :owner")
    Apartment abc(@Param("owner") String owner, @Param("city") String city);
}
