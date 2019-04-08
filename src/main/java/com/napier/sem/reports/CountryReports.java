package com.napier.sem.reports;

import com.napier.sem.domain.Country;
import com.napier.sem.domain.dto.CountryReportDTO;
import com.napier.sem.repositories.CityRepository;
import com.napier.sem.repositories.ICityRepository;
import com.napier.sem.repositories.ICountryRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CountryReports {

    private ICountryRepository countryRepository;

    public CountryReports(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     *This method returns a list with all the countries in the world, in a continent or in a region ordered by population.
     * By default it returns the list with all the countries in the world.
     * @param cityR gets the city repository in order to get missing information for certain reports
     * @param where dictates whether we are comparing within a continent or a region
     * @param name chooses the continent or region
     * @param nProvided says the number of countries that should be selected from the resulting list
     *
     * @return A list with either all or the first N countries in the world, in a continent or in a region ordered by population.
     */
    public Collection<CountryReportDTO> getAllByPopulation(CityRepository cityR, String where, String name, int nProvided){
        switch (where){
            case "continent":
                List<CountryReportDTO> reportContinent = new ArrayList<>();
                for (Country country : countryRepository.getAll()){
                    if(country.getContinent().equals(name)){
                        String capital = "No capital";
                        if(cityR.getId(country.getCapital()) != null){
                            capital = cityR.getId(country.getCapital()).getName();
                        }
                        CountryReportDTO countrydto= new CountryReportDTO(country.getISO3Code(), country.getName(), country.getContinent(), country.getRegion(), country.getPopulation(), capital);
                        reportContinent.add(countrydto);
                    }
                }
                reportContinent.sort(Comparator.comparing(CountryReportDTO::getPopulation).reversed());
                if(nProvided == 0){
                    return reportContinent;
                }
                else {
                    return reportContinent.subList(0,nProvided);
                }
            case "region":
                List<CountryReportDTO> reportRegion = new ArrayList<>();
                for (Country country : countryRepository.getAll()){
                    if(country.getRegion().equals(name)){
                        String capital = "No capital";
                        if(cityR.getId(country.getCapital()) != null){
                            capital = cityR.getId(country.getCapital()).getName();
                        }
                        CountryReportDTO countrydto= new CountryReportDTO(country.getISO3Code(), country.getName(), country.getContinent(), country.getRegion(), country.getPopulation(), capital);
                        reportRegion.add(countrydto);
                    }
                }
                reportRegion.sort(Comparator.comparing(CountryReportDTO::getPopulation).reversed());
                if(nProvided == 0){
                    return reportRegion;
                }
                else {
                    return reportRegion.subList(0,nProvided);
                }
            default:
                List<CountryReportDTO> report = new ArrayList<>();
                for(Country country : countryRepository.getAll()){
                    String capital = "No capital";
                    if(cityR.getId(country.getCapital()) != null){
                        capital = cityR.getId(country.getCapital()).getName();
                    }

                    CountryReportDTO countrydto = new CountryReportDTO(country.getISO3Code(), country.getName(), country.getContinent(), country.getRegion(), country.getPopulation(), capital);
                    report.add(countrydto);
                }
                report.sort(Comparator.comparing(CountryReportDTO::getPopulation).reversed());
                if(nProvided == 0){
                    return report;
                }
                else {
                    return report.subList(0,nProvided);
                }
        }

    }
}
