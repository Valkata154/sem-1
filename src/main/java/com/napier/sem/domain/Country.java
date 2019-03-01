package com.napier.sem.domain;

public class Country {

    private final String ISO3Code;
    private final String name;
    private final String continent;
    private final String region;
    private final float surfaceArea;
    private final int independenceYear;
    private final int population;
    private final float lifeExpectancy;
    private final float GNP;
    private final float GNPOld;
    private final String localName;
    private final String governmentForm;
    private final String headOfState;
    private final int capital;
    private final String ISO2Code;

    public Country(String ISO3Code, String name, String continent, String region, float surfaceArea, int independenceYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String governmentForm, String headOfState, int capital, String ISO2Code) {

        this.ISO3Code = ISO3Code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.independenceYear = independenceYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.ISO2Code = ISO2Code;
    }

    /**
     * @return The ISO 3166-1 alpha-3 country code
     */
    public String getISO3Code() {
        return ISO3Code;
    }

    /**
     * @return The name of the country (in English)
     */
    public String getName() {
        return name;
    }

    /**
     * @return The continent of the country
     */
    public String getContinent() {
        return continent;
    }

    /**
     * @return The region of the country on the continent
     */
    public String getRegion() {
        return region;
    }

    /**
     * @return The surface area of the country
     */
    public float getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * @return The independence year
     */
    public int getIndependenceYear() {
        return independenceYear;
    }

    /**
     * @return The population of the country
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @return The average life expectancy
     */
    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * @return The GNP (Gross National Product) of the country
     */
    public float getGNP() {
        return GNP;
    }

    /**
     * @return No idea TODO: find out
     */
    public float getGNPOld() {
        return GNPOld;
    }

    /**
     * @return The local name of the country (in the local language)
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * @return The government form of the country
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     * @return The head of state of the country
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     * @return The capital of the country
     */
    public int getCapital() {
        return capital;
    }

    /**
     * @return The ISO 3166-1 alpha-2 country code
     */
    public String getISO2Code() {
        return ISO2Code;
    }

    @Override
    public String toString() {
        return this.getISO3Code() + ": " + this.getName();
    }
}
