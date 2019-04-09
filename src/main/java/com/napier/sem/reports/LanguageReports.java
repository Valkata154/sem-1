package com.napier.sem.reports;

import com.napier.sem.domain.Country;
import com.napier.sem.domain.dto.SpeakersReportDTO;
import com.napier.sem.repositories.ICountryRepository;
import com.napier.sem.repositories.ILanguageRepository;

public class LanguageReports {

    private ILanguageRepository countryLanguageRepository;
    private ICountryRepository countryRepository;

    public LanguageReports(ILanguageRepository countryLanguageRepository, ICountryRepository countryRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
        this.countryRepository = countryRepository;
    }

    public SpeakersReportDTO getLanguageSpeakers(String language) {
        // Get speakers globally
        int speakersGlobally = countryLanguageRepository.getByLanguage(language).mapToInt(countryLanguage -> {
            // Get population of this country
            Country country = this.countryRepository.getCode(countryLanguage.getCountryCode());
            // Find out speakers using the percentage of the population speaking it
            return (int) (country.getPopulation() * (countryLanguage.getPercentage() / 100));
        }).sum();

        // Find world population to find percentage of speakers globally
        int worldPopulation = countryRepository.getAll().stream().mapToInt(Country::getPopulation).sum();

        float percentage = (float) speakersGlobally / worldPopulation * 100;
        return new SpeakersReportDTO(language, speakersGlobally, percentage);
    }
}
