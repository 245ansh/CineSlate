package com.cineslate.CineSlate.apiThings.search;

public class Top1 {
    private Long id;
    private String image;
    private String name;
    public Long getID() { return id; }
    public void setID(Long value) { this.id = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    public Top1(Long id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

}
