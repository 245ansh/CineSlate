package com.cineslate.CineSlate.apiThings.homemovies;

public class Top7 {
    private long id;
    private String image;
    private String name;
    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    public Top7(long id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

}
