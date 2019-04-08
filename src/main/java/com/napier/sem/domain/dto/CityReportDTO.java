package com.napier.sem.domain.dto;


public class CityReportDTO {

    private final String name;
    private final String country;
    private final String district;
    private final int population;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }



    public CityReportDTO(String name, String country, String district, int population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    @Override
    public String toString() {
        return " Name: " + name + " Country: " + country + " District: " + district + " Population: " + population + "\n";
    }
}
