package com.napier.sem;

import com.napier.sem.reports.LanguageReports;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageReportTest {

    private static LanguageReports reports;

    @BeforeAll
    static void prepare() {
        reports = new LanguageReports(new LanguageRepositoryMock(), new CountryRepositoryMock());
    }

    @Test
    void percentageCalculationTest() {
        float bulgarianSpeakersPercentage = reports.getLanguageSpeakers("Bulgarian").getPercentage();
        assertEquals(0.019990005f, bulgarianSpeakersPercentage);
    }

    @Test
    void countCalculationTest() {
        float bulgarianSpeakers = reports.getLanguageSpeakers("Bulgarian").getSpeakers();
        assertEquals(1000, bulgarianSpeakers);
    }

    @Test
    void summingTest() {
        float englishSpeakers = reports.getLanguageSpeakers("English").getSpeakers();
        assertEquals(5000500, englishSpeakers);
    }

}
