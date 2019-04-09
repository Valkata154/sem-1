package com.napier.sem;

import com.napier.sem.domain.dto.CountryReportDTO;
import com.napier.sem.reports.CityAndCountryReports;
import com.napier.sem.reports.CountryReports;
import com.napier.sem.reports.LanguageReports;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopulationReportTest {

    private static CityAndCountryReports reports;


    @BeforeAll
    static void prepare() {
        reports = new CityAndCountryReports(new CityRepositoryMock(), new CountryRepositoryMock());
    }

    @Test
    void CityPopulationTest(){
        assertEquals("City: Washington, population: 572059", reports.GetCityPopulationReport("Washington"));
    }

    @Test
    void DistrictPopulationTest(){
        assertEquals("District: District of Columbia, population: 572059, number of cities: 1", reports.GetDistrictPopulationReport("District of Columbia"));
    }

    @Test
    void CountryPopulationTest(){
        assertEquals("Country: United States, total population: 5000000, population living in cities: 572059 (11%), outside of cities: 4427941 (89%)", reports.GetCountryPopulationReport("United States"));
    }

    @Test
    void RegionPopulationTest(){
        assertEquals("Region: North America, total population: 5000000, population living in cities: 572059 (11%), outside of cities: 4427941 (89%)", reports.GetRegionPopulationReport("North America"));
    }

    @Test
    void ContinentPopulationTest(){
        assertEquals("Continent: North America, total population: 5000000, population living in cities: 572059 (11%), outside of cities: 4427941 (89%)", reports.GetContinentPopulationReport("North America"));

    }

    @Test
    void WorldPopulationTest(){
        assertEquals("Population of the world: 5002500", reports.GetWorldPopulationReport());
    }
}
