package com.napier.sem;

import com.napier.sem.domain.Country;
import com.napier.sem.repositories.CountryRepository;
import com.napier.sem.repositories.ICountryRepository;
import com.napier.sem.storage.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppIntegrationTest {
    private static ICountryRepository countryRepository;

    @BeforeAll
    static void init() {
        Database db = new Database("mysql://mysql:3306/world", "root", "albert-sapo");
        countryRepository = new CountryRepository(db);
    }

    @Test
    void testGetCountry() {
        Country bulgaria = countryRepository.getCode("BGR");
        assertEquals(bulgaria.getContinent(), "Europe");
    }
}
