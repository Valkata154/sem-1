package com.napier.sem.repositories;

import com.napier.sem.domain.Country;
import com.napier.sem.storage.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;

public class CountryRepository implements ICountryRepository {

    private HashMap<String, Country> cities = new HashMap<>();

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

                cities.put(code, country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Country> getAll() {
        return cities.values();
    }

    @Override
    public Country getCode(String code) {
        return cities.get(code);
    }
}
