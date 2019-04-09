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
}
