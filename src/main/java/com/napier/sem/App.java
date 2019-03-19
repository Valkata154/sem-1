package com.napier.sem;

import com.napier.sem.reports.LanguageReports;
import com.napier.sem.repositories.CityRepository;
import com.napier.sem.repositories.CountryRepository;
import com.napier.sem.repositories.LanguageRepository;
import com.napier.sem.storage.Database;

public class App {

    private static Database db = null;

    public static void main(String[] args) {
        //Create a new Application
        App a = new App();

        db = new Database("mysql://mysql:3306/world", "root", "albert-sapo");

        CityRepository cityR = new CityRepository(db);
        CountryRepository countryR = new CountryRepository(db);
        LanguageRepository langR = new LanguageRepository(db);

        /*for(Country country : countryR.getAllByPopulation("","", 5)){
            System.out.println(country.toString());
        }*/
        /*for (City city : cityR.getAllByPopulation(countryR, "district", "Katalonia", 0)) {
            System.out.println(city.toString());
        }*/

        //cityR.GetCityPopulationReport("London");
        cityR.GetDistrictPopulationReport("England");


        // Languages reports
        LanguageReports languageReports = new LanguageReports(langR, countryR);
        System.out.println(languageReports.getLanguageSpeakers("Chinese"));
        System.out.println(languageReports.getLanguageSpeakers("English"));
        System.out.println(languageReports.getLanguageSpeakers("Hindi"));
        System.out.println(languageReports.getLanguageSpeakers("Spanish"));
        System.out.println(languageReports.getLanguageSpeakers("Arabic"));
        //Disconnect from database
        db.disconnect();
    }

}