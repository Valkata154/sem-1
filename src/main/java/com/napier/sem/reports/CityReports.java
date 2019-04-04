package com.napier.sem.reports;

import com.napier.sem.domain.City;
import com.napier.sem.domain.Country;
import com.napier.sem.domain.dto.CityReportDTO;
import com.napier.sem.domain.dto.CountryReportDTO;
import com.napier.sem.repositories.CityRepository;
import com.napier.sem.repositories.CountryRepository;
import com.napier.sem.repositories.ICityRepository;
import com.napier.sem.repositories.ICountryRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CityReports {

    private ICountryRepository countryRepository;
    private ICityRepository cityRepository;

    public CityReports(ICityRepository countryRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     *This method returns a list with all the cities in the world, in a continent, in a region, in a country or in a district ordered by population.
     * By default it returns the list with all the countries in the world.
     * @param countryR gets the country repository in order to get missing information for certain reports
     * @param where dictates whether we are comparing within a continent, a region, a country or a district
     * @param name chooses the continent, region, country or district
     * @param nProvided says the number of cities that should be selected from the resulting list
     *
     * @return A list with either all or the first N cities in the world, in a continent, in a region, in a country or in a district ordered by population.
     */
    public Collection<CityReportDTO> getAllByPopulation(CountryRepository countryR, String where, String name, int nProvided) {
        switch (where) {
            case "district":
                List<CityReportDTO> reportDistrict = new ArrayList<>();
                for (City city : cityRepository.getAll()) {
                    if (city.getDistrict().equals(name)) {
                        CityReportDTO citydto = new CityReportDTO(city.getName(), countryR.getCode(city.getCountryCode()).getName(), city.getDistrict(), city.getPopulation());
                        reportDistrict.add(citydto);
                    }
                }
                reportDistrict.sort(Comparator.comparing(CityReportDTO::getPopulation).reversed());
                if (nProvided == 0) {
                    return reportDistrict;
                } else {
                    return reportDistrict.subList(0, nProvided);
                }
            case "country":
                List<CityReportDTO> reportCountry = new ArrayList<>();
                String codeCountry = "";
                for (Country country : countryR.getAll()) {
                    if (country.getName().equals(name)) {
                        codeCountry = country.getISO3Code();
                        break;
                    }
                }
                for (City city : cityRepository.getAll()) {
                    if (city.getCountryCode().equals(codeCountry)) {
                        CityReportDTO citydto = new CityReportDTO(city.getName(), "", city.getDistrict(), city.getPopulation());
                        reportCountry.add(citydto);
                    }
                }
                reportCountry.sort(Comparator.comparing(CityReportDTO::getPopulation).reversed());
                if (nProvided == 0) {
                    return reportCountry;
                } else {
                    return reportCountry.subList(0, nProvided);
                }
            case "region":
                List<CityReportDTO> reportRegion = new ArrayList<>();
                List<Country> countriesInRegion = new ArrayList<>();
                for (Country country : countryR.getAll()) {
                    if (country.getRegion().equals(name)) {
                        countriesInRegion.add(country);
                    }
                }
                for (Country country : countriesInRegion) {
                    for (City city : cityRepository.getAll()) {
                        if (city.getCountryCode().equals(country.getISO3Code())) {
                            CityReportDTO citydto = new CityReportDTO(city.getName(), "", city.getDistrict(), city.getPopulation());
                            reportRegion.add(citydto);
                        }
                    }
                }
                reportRegion.sort(Comparator.comparing(CityReportDTO::getPopulation).reversed());
                if (nProvided == 0) {
                    return reportRegion;
                } else {
                    return reportRegion.subList(0, nProvided);
                }
            case "continent":
                List<CityReportDTO> reportContinent = new ArrayList<>();
                List<Country> countriesInContinent = new ArrayList<>();
                for (Country country : countryR.getAll()) {
                    if (country.getContinent().equals(name)) {
                        countriesInContinent.add(country);
                    }
                }
                for (Country country : countriesInContinent) {
                    for (City city : cityRepository.getAll()) {
                        if (city.getCountryCode().equals(country.getISO3Code())) {
                            CityReportDTO citydto = new CityReportDTO(city.getName(), "", city.getDistrict(), city.getPopulation());
                            reportContinent.add(citydto);
                        }
                    }
                }
                reportContinent.sort(Comparator.comparing(CityReportDTO::getPopulation).reversed());
                if (nProvided == 0) {
                    return reportContinent;
                } else {
                    return reportContinent.subList(0, nProvided);
                }
            default:
                List<CityReportDTO> report = new ArrayList<>();
                for (City city : cityRepository.getAll()) {
                    CityReportDTO citydto = new CityReportDTO(city.getName(), "", city.getDistrict(), city.getPopulation());
                    report.add(citydto);
                }
                report.sort(Comparator.comparing(CityReportDTO::getPopulation).reversed());
                if (nProvided == 0) {
                    return report;
                } else {
                    return report.subList(0, nProvided);
                }

        }
    }
}
