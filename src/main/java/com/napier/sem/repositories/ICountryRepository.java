package com.napier.sem.repositories;

import com.napier.sem.domain.Country;

import java.util.Collection;

public interface ICountryRepository {
    Collection<Country> getAll();

    Country getCode(String code);
}
