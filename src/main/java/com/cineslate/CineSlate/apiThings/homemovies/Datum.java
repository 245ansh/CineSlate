package com.cineslate.CineSlate.apiThings.homemovies;

public class Datum {
    private Alias[] aliases;
    private long id;
    private String image;
    private String lastUpdated;
    private String name;
    private String[] nameTranslations;
    private String[] overviewTranslations;
    private long score;
    private String slug;
    private Status status;
    private long runtime;
    private String year;

    public Alias[] getAliases() { return aliases; }
    public void setAliases(Alias[] value) { this.aliases = value; }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String value) { this.lastUpdated = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String[] getNameTranslations() { return nameTranslations; }
    public void setNameTranslations(String[] value) { this.nameTranslations = value; }

    public String[] getOverviewTranslations() { return overviewTranslations; }
    public void setOverviewTranslations(String[] value) { this.overviewTranslations = value; }

    public long getScore() { return score; }
    public void setScore(long value) { this.score = value; }

    public String getSlug() { return slug; }
    public void setSlug(String value) { this.slug = value; }

    public Status getStatus() { return status; }
    public void setStatus(Status value) { this.status = value; }

    public long getRuntime() { return runtime; }
    public void setRuntime(long value) { this.runtime = value; }

    public String getYear() { return year; }
    public void setYear(String value) { this.year = value; }

}
