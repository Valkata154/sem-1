package com.napier.sem.domain;

public class City {

    private final int id;
    private final String name;
    private final String countryCode;
    private final String district;
    private final int population;

    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    /**
     * @return int The population of the city
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @return The city identification number
     */
    public int getId() {
        return id;
    }

    /**
     * @return The name of the city
     */
    public String getName() {
        return name;
    }

    /**
     * @return The ISO 3166-1 alpha-3 country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @return The city district
     */
    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return this.getId() + ": " + this.getName();
    }
}
