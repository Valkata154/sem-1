package com.napier.sem.repositories;

import com.napier.sem.domain.Country;

import java.util.Collection;

public interface ICountryRepository {
    /**
     * @return All countries in the database
     */
    Collection<Country> getAll();

    /**
     * @param code The ISO 3166-1 alpha-3 country code
     * @return A country from the database
     */
    Country getCode(String code);
}
