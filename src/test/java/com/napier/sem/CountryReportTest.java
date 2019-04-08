package com.napier.sem;

import com.napier.sem.domain.dto.CountryReportDTO;
import com.napier.sem.reports.CountryReports;
import com.napier.sem.reports.LanguageReports;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryReportTest {

    private static CountryReports reports;
    private static CityRepositoryMock city;

    @BeforeAll
    static void prepare() {
        reports = new CountryReports(new CountryRepositoryMock());
        city = new CityRepositoryMock();
    }

    @Test
    void getFromWorld() {
        CountryReportDTO country = reports.getAllByPopulation(city,"","",0).get(0);
        assertEquals(3000,country.getPopulation());
        assertEquals("United States", country.getName());
        assertEquals("North America",country.getContinent());
        assertEquals("USA",country.getCode());
        assertEquals("North America", country.getRegion());
        assertEquals("Washington", country.getCapital());
        assertEquals("Code: USA Name: United States Continent: North America Region: North America Population: 3000 Capital: Washington\n", country.toString());
    }

    @Test
    void getFromContinent(){

        CountryReportDTO country = reports.getAllByPopulation(city,"continent","North America", 0).get(0);

        assertEquals(3000,country.getPopulation());
        assertEquals("United States", country.getName());
        assertEquals("North America",country.getContinent());
        assertEquals("USA",country.getCode());
        assertEquals("North America", country.getRegion());
        assertEquals("Washington", country.getCapital());
        assertEquals("Code: USA Name: United States Continent: North America Region: North America Population: 3000 Capital: Washington\n", country.toString());
    }

    @Test
    void getFromRegion(){

        CountryReportDTO country = reports.getAllByPopulation(city,"region","North America", 0).get(0);

        assertEquals(3000,country.getPopulation());
        assertEquals("United States", country.getName());
        assertEquals("North America",country.getContinent());
        assertEquals("USA",country.getCode());
        assertEquals("North America", country.getRegion());
        assertEquals("Washington", country.getCapital());
        assertEquals("Code: USA Name: United States Continent: North America Region: North America Population: 3000 Capital: Washington\n", country.toString());
    }

}
