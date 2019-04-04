package com.napier.sem.domain.dto;

public class CountryReportDTO {

    private final String code;
    private final String name;
    private final String continent;
    private final String region;
    private final int population;
    private final String capital;

    public String getCode() {
        return code;
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

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public CountryReportDTO(String code, String name, String continent, String region, int population, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Code: " + code + " Name: " + name + " Continent: " + continent + " Region: " + region + " Population: " + population + " Capital: " + capital;
    }
}
