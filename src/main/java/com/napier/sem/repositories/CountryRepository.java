package com.napier.sem.repositories;

import com.napier.sem.domain.City;
import com.napier.sem.domain.Country;
import com.napier.sem.storage.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CountryRepository implements ICountryRepository {

    private HashMap<String, Country> countries = new HashMap<>();

    public CountryRepository(Database db) {

        ResultSet result = db.query("SELECT * FROM country");
        try {
            while (result.next()) {
                // Fetch and parse data
                String code = result.getString("Code");
                String name = result.getString("Name");
                String continent = result.getString("Continent");
                String region = result.getString("Region");
                float surfaceArea = result.getFloat("SurfaceArea");
                int indepYear = result.getInt("IndepYear");
                int population = result.getInt("Population");
                float lifeExpectancy = result.getInt("LifeExpectancy");
                float GNP = result.getInt("GNP");
                float GNPOld = result.getInt("GNPOld");
                String localName = result.getString("LocalName");
                String governmentForm = result.getString("GovernmentForm");
                String headOfState = result.getString("HeadOfState");
                int capital = result.getInt("Capital");
                String code2 = result.getString("Code2");
                // Create city
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, GNP, GNPOld, localName, governmentForm, headOfState, capital, code2);

                countries.put(code, country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Country> getAll() {
        return countries.values();
    }

    @Override
    public Country getCode(String code) {
        return countries.get(code);
    }


    public String GetRegionPopulationReport(String r){
        int region_population = 0;
        int number_of_countries = 0;
        String result;

        for(Country country : countries.values()){
            if(country.getRegion().equals(r)){
                region_population += country.getPopulation();
                number_of_countries++;

            }
        }
        result = "Region: " + r + ", population: " + region_population + ", number of countries: " + number_of_countries;
        return result;


    }
    public String GetCountryPopulationReport(String c){
        String result;
        int popln = 0;
        for(Country country : countries.values()){
            if(country.getName().equals(c)){
                popln = country.getPopulation();
            }

        }
        result = "Country: " + c + ", population: " + popln;
        return result;

    }
    public void GetContinentPopulationReport(String c){
        int continent_population = 0;
        int number_of_countries = 0;

        for(Country country : countries.values()){
            if(country.getContinent().equals(c)){
                continent_population += country.getPopulation();
                number_of_countries++;
            }
        }
        System.out.println("continent: " + c + ", population: " + continent_population + ", number of countries: " + number_of_countries);

    }
    public void GetWorldPopulationReport()
    {
        int world_population = 0;

        for(Country country : countries.values()){
            world_population += country.getPopulation();
        }
        System.out.println("Population of the world: " + world_population);
    }

}
