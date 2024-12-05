package com.cineslate.CineSlate.apiThings.movie;

import java.util.List;

public class Data {
    private List<Alias> aliases;
    private int id;
    private String image;
    private String lastUpdated;
    private String name;
    private List<String> nameTranslations;
    private List<String> overviewTranslations;
    private int score;
    private String slug;
    private Status status;
    private int runtime;
    private String year;
    public List<Alias> getAliases() {
        return aliases;
    }
    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getNameTranslations() {
        return nameTranslations;
    }
    public void setNameTranslations(List<String> nameTranslations) {
        this.nameTranslations = nameTranslations;
    }
    public List<String> getOverviewTranslations() {
        return overviewTranslations;
    }
    public void setOverviewTranslations(List<String> overviewTranslations) {
        this.overviewTranslations = overviewTranslations;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int getRuntime() {
        return runtime;
    }
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
}
