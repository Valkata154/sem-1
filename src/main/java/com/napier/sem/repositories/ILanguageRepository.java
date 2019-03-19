package com.napier.sem.repositories;

import com.napier.sem.domain.Language;

import java.util.Collection;
import java.util.stream.Stream;

public interface ILanguageRepository {
    /**
     * @return All languages in the database
     */
    Collection<Language> getAll();

    /**
     * @param countryCode The country code
     * @return The language of that country
     */
    Stream<Language> getByCountryCode(String countryCode);

    /**
     * Returns all the entities for languages spoken in countries
     *
     * @param language The language
     * @return The country and language combo
     */
    Stream<Language> getByLanguage(String language);
}
