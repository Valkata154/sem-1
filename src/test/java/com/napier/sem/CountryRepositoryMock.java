package com.napier.sem;

import com.napier.sem.domain.Country;
import com.napier.sem.repositories.ICountryRepository;

import java.util.Collection;
import java.util.HashMap;

public class CountryRepositoryMock implements ICountryRepository {
    private HashMap<String, Country> countries = new HashMap<>();

    CountryRepositoryMock() {
        countries.put("BGR", new Country("BGR", "Bulgaria", "Europe", "Eastern Europe", 110994.00f, 1908, 1000, 70.9f, 12178.00f, 10169.00f, "Balgarija", "Republic", "Petar Stojanov", 539, "BG"));
        countries.put("USA", new Country("USA", "United States", "North America", "North America", 9363520.0f, 1776, 3000, 77.1f, 8510700.00f, 8110900.00f, "United States", "Federal Republic", "George W. Bush", 3813, "US"));
        countries.put("UGA", new Country("UGA", "Uganda", "Africa", "Eastern Africa", 241038.00f, 1962, 1000, 42.9f, 6313.00f, 6887.00f, "Uganda", "Republic", "Yoweri Museveni", 3425, "UG"));
    }

    @Override
    public Collection<Country> getAll() {
        return countries.values();
    }

    @Override
    public Country getCode(String code) {
        return countries.get(code);
    }
}
