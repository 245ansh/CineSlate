package com.cineslate.CineSlate.apiThings.search;

public class searchResponse {
    private Datum[] data;
    private String status;
    private Links links;

    public Datum[] getData() { return data; }
    public void setData(Datum[] value) { this.data = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public Links getLinks() { return links; }
    public void setLinks(Links value) { this.links = value; }
}