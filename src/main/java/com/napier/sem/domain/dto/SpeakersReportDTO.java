package com.napier.sem.domain.dto;

public class SpeakersReportDTO {

    private String language;
    private int speakers;
    private float percentage;

    public SpeakersReportDTO(String language, int speakers, float percentage) {
        this.language = language;
        this.speakers = speakers;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return speakers + " people speak " + language + " (" + String.format("%.2f", percentage) + "% of world population)";
    }
}
