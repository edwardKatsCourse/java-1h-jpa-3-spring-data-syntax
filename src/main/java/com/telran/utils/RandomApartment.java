package com.telran.utils;

import com.telran.entity.Apartment;

import java.util.Random;

public class RandomApartment {

    private static final String[] CITIES = {"Haifa", "Tel-Aviv"};
    private static final String[] STREETS = {
            "Rotshild",
            "Balfur",
            "Perlshtein",
            "Ha-Banim",
            "Weizman",
            "Ben-Gurion",
            "Herzl",
            "Ha-Galil",
            "Dan"
    };

    private static final String[] OWNERS = {
            "David Dale",
            "Shir Morgan",
            "Mara Smish",
            "Yosi Simons"
    };

    private static final Integer MIN_PRICE = 500_000;
    private static final Integer MAX_PRICE = 5_000_000;

    private static final Integer MIN_HOUSE_NUMBER = 1;
    private static final Integer MAX_HOUSE_NUMBER = 50;


    private static String getCity() {
        Random random = new Random();
        int randomIndex = random.nextInt(CITIES.length);
        return CITIES[randomIndex];
    }

    private static String getOwner() {
        Random random = new Random();
        int randomIndex = random.nextInt(OWNERS.length);
        return OWNERS[randomIndex];
    }

    private static String getStreet() {
        Random random = new Random();
        int randomIndex = random.nextInt(STREETS.length);
        return STREETS[randomIndex];
    }

    private static Integer getPrice() {
        Random random = new Random();
        Integer randomValue = random.nextInt(MAX_PRICE) + MIN_PRICE; //0 -> 500_000 | 5_000_000 -> 5_500_000
        return randomValue;
    }

    private static Integer getHouseNumber() {
        Random random = new Random();
        Integer randomValue = random.nextInt(MAX_HOUSE_NUMBER) + MIN_HOUSE_NUMBER;
        return randomValue;
    }

    public static Apartment getApartment() {
        return Apartment.builder()
                .city(getCity())
                .houseNumber(getHouseNumber())
                .price(getPrice())
                .owner(getOwner())
                .street(getStreet())
                .build();
    }





}
