package com.napier.sem.domain;

public class Language {

    private String countryCode;
    private String language;
    private boolean isOfficcial;
    private float percentage;

    public Language(String countryCode, String language, boolean isOfficial, float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficcial = isOfficial;
        this.percentage = percentage;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isOfficcial() {
        return isOfficcial;
    }

    public float getPercentage() {
        return percentage;
    }
}
