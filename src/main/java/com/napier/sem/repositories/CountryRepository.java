package com.napier.sem.repositories;

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

    /*
     *This method returns a list with all the countries in the world ordered by population.
     */
    public Collection<Country> getAllByPopulation(){
        List<Country> report = new ArrayList<>(countries.values());
        report.sort(Comparator.comparing(Country::getPopulation).reversed());
        return report;
    }
}
