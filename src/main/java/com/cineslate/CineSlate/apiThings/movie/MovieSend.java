package com.cineslate.CineSlate.apiThings.movie;

public class MovieSend {
    private int id;
    private String image;
    private String name;
    private int score;
    private int runtime;
    public MovieSend(int id, String image, String name, int score, int runtime, String year) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.score = score;
        this.runtime = runtime;
        this.year = year;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
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
    private String year;
}
