package com.napier.sem;

import com.napier.sem.domain.Language;
import com.napier.sem.repositories.ILanguageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class LanguageRepositoryMock implements ILanguageRepository {

    private ArrayList<Language> languages = new ArrayList<>();

    LanguageRepositoryMock() {
        languages.add(new Language("BGR", "Bulgarian", true, 100));
        languages.add(new Language("USA", "English", true, 100));
        languages.add(new Language("UGA", "English", false, 50));
    }

    @Override
    public Collection<Language> getAll() {
        return languages;
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
