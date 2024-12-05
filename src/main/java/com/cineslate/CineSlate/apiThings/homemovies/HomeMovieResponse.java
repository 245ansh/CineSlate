package com.cineslate.CineSlate.apiThings.homemovies;


public class HomeMovieResponse {
    private Datum[] data;
    private String status;

    public Datum[] getData() { return data; }
    public void setData(Datum[] value) { this.data = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }
    
}
