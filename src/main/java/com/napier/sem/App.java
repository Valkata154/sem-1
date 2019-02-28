package com.napier.sem;

import com.napier.sem.domain.City;
import com.napier.sem.repositories.CityRepository;
import com.napier.sem.storage.Database;

public class App {

    private static Database db = null;

    public static void main(String[] args) {
        //Create a new Application
        App a = new App();

        db = new Database("mysql://mysql:3306/world", "root", "albert-sapo");

        CityRepository cr = new CityRepository(db);

        for (City city : cr.getAll()) {
            System.out.println(city.getName());
        }

        //Disconnect from database
        db.disconnect();
    }
}