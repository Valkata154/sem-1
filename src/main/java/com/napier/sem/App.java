package com.napier.sem;

import com.napier.sem.domain.Language;
import com.napier.sem.reports.CityAndCountryReports;
import com.napier.sem.reports.CityReports;
import com.napier.sem.reports.LanguageReports;
import com.napier.sem.reports.CountryReports;
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

        CityAndCountryReports candcreports = new CityAndCountryReports(cityR, countryR);

        //Population reports (Albert)

        //#1
        System.out.println(candcreports.GetCityPopulationReport("London"));
        //#2
        System.out.println(candcreports.GetDistrictPopulationReport("Katalonia"));
        //#3
        System.out.println(candcreports.GetCountryPopulationReport("Ukraine"));
        //#4
        System.out.println(candcreports.GetRegionPopulationReport("Eastern Europe"));
        //#5
        System.out.println(candcreports.GetContinentPopulationReport("Europe"));
        //#6
        System.out.println(candcreports.GetWorldPopulationReport());

        //Get by population reports (Marcos)

        //#7
        CountryReports countryReports = new CountryReports(countryR);
        System.out.println(countryReports.getAllByPopulation(cityR,"","",5));

        //#8
        CityReports cityReports = new CityReports(cityR);
        System.out.println(cityReports.getAllByPopulation(countryR,"","",5));


        // Languages reports (Andrey)

        LanguageReports languageReports = new LanguageReports(langR, countryR);
        //#9
        System.out.println(languageReports.getLanguageSpeakers("Chinese"));
        //#10
        System.out.println(languageReports.getLanguageSpeakers("English"));
        //#11
        System.out.println(languageReports.getLanguageSpeakers("Hindi"));
        //#12
        System.out.println(languageReports.getLanguageSpeakers("Spanish"));
        //#13
        System.out.println(languageReports.getLanguageSpeakers("Arabic"));




        //Disconnect from database
        db.disconnect();
    }

}