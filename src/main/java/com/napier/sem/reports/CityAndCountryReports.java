package com.napier.sem.reports;

import com.napier.sem.domain.City;
import com.napier.sem.domain.Country;
import com.napier.sem.domain.dto.CityReportDTO;
import com.napier.sem.domain.dto.CountryReportDTO;
import com.napier.sem.repositories.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CityAndCountryReports {

    private ICountryRepository countryRepository;
    private ICityRepository cityRepository;

    public CityAndCountryReports(ICityRepository cityRepository, ICountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }



    public String GetCountryPopulationReport(String c){
        String result;
        double total_population = 0;
        double population_in_cities = 0;
        double population_outside_of_cities;
        String countryCode = null;
        for(Country country : countryRepository.getAll()){
            if(country.getName().equals(c)){
                total_population = country.getPopulation();
                countryCode = country.getISO3Code();
            }
        }
        for(City city : cityRepository.getAll()){
            if(city.getCountryCode().equals(countryCode)){
                population_in_cities += city.getPopulation();
            }
        }

        population_outside_of_cities = total_population - population_in_cities;

        double percentage_in_cities = (population_in_cities / total_population) * 100;
        double percentage_outside_of_cities = 100 - percentage_in_cities;
        result = "Country: " + c + ", total_population: " + total_population + ", population living in cities: " + population_in_cities + " ("+percentage_in_cities+"%)" + ", outside of cities: " + population_outside_of_cities + " ("+percentage_outside_of_cities+"%)";
        return result;

    }




}
