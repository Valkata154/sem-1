package com.napier.sem.repositories;

import com.napier.sem.domain.City;

import java.util.Collection;

public interface ICityRepository {
    /**
     * @return All cities in the database
     */
    Collection<City> getAll();

    /**
     * @param id The city id
     * @return A city from the database
     */
    City getId(int id);
}
