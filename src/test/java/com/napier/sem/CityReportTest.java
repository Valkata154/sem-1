package com.napier.sem;

import com.napier.sem.domain.dto.CityReportDTO;
import com.napier.sem.domain.dto.CountryReportDTO;
import com.napier.sem.reports.CityReports;
import com.napier.sem.reports.CountryReports;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityReportTest {

    private static CityReports reports;
    private static CountryRepositoryMock country;

    @BeforeAll
    static void prepare() {
        reports = new CityReports(new CityRepositoryMock());
        country = new CountryRepositoryMock();
    }

    @Test
    void getFromWorld() {
        CityReportDTO city = reports.getAllByPopulation(country,"","",0).get(0);
        assertEquals(1780000,city.getPopulation());
        assertEquals("Amsterdam", city.getName());
        assertEquals("Netherlands",city.getCountry());
        assertEquals("Noord-Holland",city.getDistrict());
        assertEquals("Name: Amsterdam Country: Netherlands District: Noord-Holland Population: 1780000\n", city.toString());
    }

    @Test
    void getFromContinent() {
        CityReportDTO city = reports.getAllByPopulation(country,"continent","Europe",0).get(0);
        assertEquals(1780000,city.getPopulation());
        assertEquals("Amsterdam", city.getName());
        assertEquals("Netherlands",city.getCountry());
        assertEquals("Noord-Holland",city.getDistrict());
        assertEquals("Name: Amsterdam Country: Netherlands District: Noord-Holland Population: 1780000\n", city.toString());
    }
    @Test
    void getFromRegion() {
        CityReportDTO city = reports.getAllByPopulation(country,"region","Western Europe",0).get(0);
        assertEquals(1780000,city.getPopulation());
        assertEquals("Amsterdam", city.getName());
        assertEquals("Netherlands",city.getCountry());
        assertEquals("Noord-Holland",city.getDistrict());
        assertEquals("Name: Amsterdam Country: Netherlands District: Noord-Holland Population: 1780000\n", city.toString());
    }
    @Test
    void getFromCountry() {
        CityReportDTO city = reports.getAllByPopulation(country,"country","Netherlands",0).get(0);
        assertEquals(1780000,city.getPopulation());
        assertEquals("Amsterdam", city.getName());
        assertEquals("Netherlands",city.getCountry());
        assertEquals("Noord-Holland",city.getDistrict());
        assertEquals("Name: Amsterdam Country: Netherlands District: Noord-Holland Population: 1780000\n", city.toString());
    }
    @Test
    void getFromDistrict() {
        CityReportDTO city = reports.getAllByPopulation(country,"district","Noord-Holland",0).get(0);
        assertEquals(1780000,city.getPopulation());
        assertEquals("Amsterdam", city.getName());
        assertEquals("Netherlands",city.getCountry());
        assertEquals("Noord-Holland",city.getDistrict());
        assertEquals("Name: Amsterdam Country: Netherlands District: Noord-Holland Population: 1780000\n", city.toString());
    }

}
