package com.napier.sem;

import com.napier.sem.domain.City;
import com.napier.sem.domain.Country;
import com.napier.sem.repositories.ICityRepository;

import java.util.Collection;
import java.util.HashMap;

public class CityRepositoryMock implements ICityRepository {
    private HashMap<Integer, City> cities = new HashMap<>();

    CityRepositoryMock() {
        cities.put(5, new City(5, "Amsterdam", "NDL", "Noord-Holland", 1780000));
        cities.put(654, new City(654,"Barcelona","ESP","Katalonia",1503451));
        cities.put(3813, new City(3813, "Washington", "USA", "District of Columbia", 572059));
        }

    @Override
    public Collection<City> getAll() {
        return cities.values();
    }

    @Override
    public City getId(int id) {
        return cities.get(id);
    }
}
