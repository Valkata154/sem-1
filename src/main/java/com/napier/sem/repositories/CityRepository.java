package com.napier.sem.repositories;

import com.napier.sem.domain.City;
import com.napier.sem.domain.Country;
import com.napier.sem.storage.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CityRepository implements ICityRepository {

    private HashMap<Integer, City> cities = new HashMap<>();

    public CityRepository(Database db) {

        ResultSet result = db.query("SELECT * FROM city");
        try {
            while (result.next()) {
                // Fetch and parse data
                int id = result.getInt("ID");
                String name = result.getString("Name");
                String countryCode = result.getString("CountryCode");
                String district = result.getString("District");
                int population = result.getInt("Population");
                // Create city
                City city = new City(id, name, countryCode, district, population);

                cities.put(id, city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<City> getAll() {
        return cities.values();
    }

    @Override
    public City getId(int id) {
        return cities.get(id);
    }

    /**
     *This method returns a list with all the cities in the world, in a continent, in a region, in a country or in a district ordered by population.
     * By default it returns the list with all the countries in the world.
     * @param countryR gets the country repository in order to get missing information for certain reports
     * @param where dictates whether we are comparing within a continent, a region, a country or a district
     * @param name chooses the continent, region, country or district
     * @param nProvided says the number of cities that should be selected from the resulting list
     *
     * @return A list with either all or the first N cities in the world, in a continent, in a region, in a country or in a district ordered by population.
     */
    public Collection<City> getAllByPopulation(CountryRepository countryR, String where, String name, int nProvided){
        switch (where){
            case "district":
                List<City> reportDistrict = new ArrayList<>();
                for(City city : cities.values()){
                    if(city.getDistrict().equals(name)){
                        reportDistrict.add(city);
                    }
                }
                reportDistrict.sort(Comparator.comparing(City::getPopulation).reversed());
                if(nProvided == 0){
                    return reportDistrict;
                }
                else{
                    return reportDistrict.subList(0,nProvided);
                }
            case "country":
                List<City> reportCountry = new ArrayList<>();
                String codeCountry = "";
                for(Country country : countryR.getAll()){
                    if(country.getName().equals(name)){
                        codeCountry = country.getISO3Code();
                        break;
                    }
                }
                for(City city : cities.values()){
                    if(city.getCountryCode().equals(codeCountry)){
                        reportCountry.add(city);
                    }
                }
                reportCountry.sort(Comparator.comparing(City::getPopulation).reversed());
                if(nProvided == 0){
                    return reportCountry;
                }
                else{
                    return reportCountry.subList(0,nProvided);
                }
            case "region":
                List<City> reportRegion = new ArrayList<>();
                List<Country> countriesInRegion = new ArrayList<>();
                for(Country country : countryR.getAll()){
                    if(country.getRegion().equals(name)){
                        countriesInRegion.add(country);
                    }
                }
                for(Country country : countriesInRegion) {
                    for (City city : cities.values()) {
                        if (city.getCountryCode().equals(country.getISO3Code())) {
                            reportRegion.add(city);
                        }
                    }
                }
                reportRegion.sort(Comparator.comparing(City::getPopulation).reversed());
                if(nProvided == 0){
                    return reportRegion;
                }
                else{
                    return reportRegion.subList(0,nProvided);
                }
            case "continent":
                List<City> reportContinent = new ArrayList<>();
                List<Country> countriesInContinent = new ArrayList<>();
                for(Country country : countryR.getAll()){
                    if(country.getContinent().equals(name)){
                        countriesInContinent.add(country);
                    }
                }
                for(Country country : countriesInContinent) {
                    for (City city : cities.values()) {
                        if (city.getCountryCode().equals(country.getISO3Code())) {
                            reportContinent.add(city);
                        }
                    }
                }
                reportContinent.sort(Comparator.comparing(City::getPopulation).reversed());
                if(nProvided == 0){
                    return reportContinent;
                }
                else{
                    return reportContinent.subList(0,nProvided);
                }
            default:
                List<City> report = new ArrayList<>(cities.values());
                report.sort(Comparator.comparing(City::getPopulation).reversed());
                if(nProvided == 0){
                    return report;
                }
                else{
                    return report.subList(0,nProvided);
                }

        }

    }
}
