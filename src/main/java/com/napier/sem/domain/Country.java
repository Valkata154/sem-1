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

    public String getISO3Code() {
        return ISO3Code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public int getIndependenceYear() {
        return independenceYear;
    }

    public int getPopulation() {
        return population;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public float getGNP() {
        return GNP;
    }

    public float getGNPOld() {
        return GNPOld;
    }

    public String getLocalName() {
        return localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public String getISO2Code() {
        return ISO2Code;
    }
}
