package com.napier.sem.repositories;

import com.napier.sem.domain.City;

import java.util.Collection;

public interface ICityRepository {
    Collection<City> getAll();

    City getId(int id);
}
