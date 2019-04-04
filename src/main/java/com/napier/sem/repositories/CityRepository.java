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

    public void GetCityPopulationReport(String c){
        for(City city : cities.values()){
            if(city.getName().equals(c)){
                System.out.println(city.getName() + ", " + city.getCountryCode() + ", " + city.getDistrict() + ", " +  "population: " + city.getPopulation());
            }
        }
    }
    public void GetDistrictPopulationReport(String d){
        int district_population = 0;
        int number_of_cities = 0;
        for(City city : cities.values()){
            if(city.getDistrict().equals(d)){
                district_population += city.getPopulation();
                number_of_cities++;
            }
        }
        System.out.println("district: " + d + ", population: " + district_population + ", number of cities: " + number_of_cities);
    }
}
