package com.napier.sem.repositories;

import com.napier.sem.domain.Language;
import com.napier.sem.storage.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class LanguageRepository implements ILanguageRepository {

    private ArrayList<Language> languages = new ArrayList<>();

    public LanguageRepository(Database db) {
        ResultSet result = db.query("SELECT * FROM countrylanguage");
        try {
            while (result.next()) {
                // Fetch and parse data
                String countryCode = result.getString("CountryCode");
                String language = result.getString("Language");
                boolean isOfficial = result.getString("IsOfficial").equals("T");
                float percentage = result.getFloat("Percentage");
                // Create city
                Language languageObj = new Language(countryCode, language, isOfficial, percentage);

                languages.add(languageObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Language> getAll() {
        return this.languages;
    }

    @Override
    public Stream<Language> getByCountryCode(String countryCode) {
        return languages.stream().filter(language -> language.getCountryCode().equals(countryCode));
    }

    @Override
    public Stream<Language> getByLanguage(String language) {
        return languages.stream().filter(languageObj -> languageObj.getLanguage().equals(language));
    }
}
