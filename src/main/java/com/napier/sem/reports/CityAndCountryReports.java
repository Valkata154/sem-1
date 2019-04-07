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

    //Generate report with the population of people, people living in cities, and people not living in cities in a given country

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

        if(c != null) {
            result = "Country: " + c + ", total_population: " + total_population + ", population living in cities: " + population_in_cities + " (" + percentage_in_cities + "%)" + ", outside of cities: " + population_outside_of_cities + " (" + percentage_outside_of_cities + "%)";
        }
        else {
            result = "Given country doesn't exist";
        }

        return result;

    }


    //Generate report with the population of a city

    public String GetCityPopulationReport(String c){
        String result;
        int population = 0;
        for(City city : cityRepository.getAll()){
            if(city.getName().equals(c)){
                population = city.getPopulation();
            }
        }

        if(c != null) {
            result = "City: " + c + ", population: " + population;
        }
        else{
            result = "Given city doesn't exist";
        }
        return result;
    }

    //Generate report with the population of a district

    public String GetDistrictPopulationReport(String d){
        int district_population = 0;
        int number_of_cities = 0;
        String result;

        for(City city : cityRepository.getAll()){
            if(city.getDistrict().equals(d)){
                district_population += city.getPopulation();
                number_of_cities++;
            }
        }

        if(d != null) {
            result = "District: " + d + ", population: " + district_population + ", number of cities: " + number_of_cities;
        }
        else{
            result = "Given district doesn't exist";
        }

        return result;
    }

    //Generate report with the population of a region

    public String GetRegionPopulationReport(String r){
        double region_population = 0;
        double population_in_cities = 0;
        double population_outside_of_cities;
        String result;
        ArrayList<Country> countries_in_region = new ArrayList<>();


        for(Country country : countryRepository.getAll()){
            if(country.getRegion().equals(r)){
                region_population += country.getPopulation();
                countries_in_region.add(country);
            }
        }
        for(Country c : countries_in_region){
            String code = c.getISO3Code();
            for(City city : cityRepository.getAll()){
                if(city.getCountryCode().equals(code)){
                    population_in_cities += city.getPopulation();
                }
            }
        }

        population_outside_of_cities = region_population - population_in_cities;

        double percentage_in_cities = (population_in_cities / region_population) * 100;
        double percentage_outside_of_cities = 100 - percentage_in_cities;

        if(r != null) {
            result = "Region: " + r + ", total population: " + region_population + ", population living in cities: " + population_in_cities + " (" + percentage_in_cities + "%)" + ", outside of cities: " + population_outside_of_cities + " (" + percentage_outside_of_cities + "%)";
        }
        else {
            result = "Given region doesn't exist";
        }

        return result;

    }

    //Generate report with the population of a continent

    public String GetContinentPopulationReport(String c){
        double continent_population = 0;
        double population_in_cities = 0;
        double population_outside_of_cities;
        String result;
        ArrayList<Country> countries_in_continent = new ArrayList<>();


        for(Country country : countryRepository.getAll()){
            if(country.getContinent().equals(c)){
                continent_population += country.getPopulation();
                countries_in_continent.add(country);

            }
        }

        for(Country country : countries_in_continent){
            String code = country.getISO3Code();
            for(City city : cityRepository.getAll()){
                if(city.getCountryCode().equals(code)){
                    population_in_cities += city.getPopulation();
                }
            }
        }

        population_outside_of_cities = continent_population - population_in_cities;

        double percentage_in_cities = (population_in_cities / continent_population) * 100;
        double percentage_outside_of_cities = 100 - percentage_in_cities;

        if(c != null) {
            result = "Continent: " + c + ", total population: " + continent_population + ", population living in cities: " + population_in_cities + " (" + percentage_in_cities + "%)" + ", outside of cities: " + population_outside_of_cities + " (" + percentage_outside_of_cities + "%)";
        }
        else {
            result = "Given continent doesn't exist";
        }

        return result;
    }

    //Generate the report of the population of the world

    public String GetWorldPopulationReport()
    {
        int world_population = 0;
        String result;

        for(Country country : countryRepository.getAll()){
            world_population += country.getPopulation();
        }

        result = "Population of the world: " + world_population;
        return result;
    }
}
