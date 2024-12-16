package com.cineslate.CineSlate.apiThings.search;
import java.util.ArrayList;
import java.util.List;

public class searchResponse {
    private List<Datum> data = new ArrayList<Datum>();
    private String status;
    private Links links;
    public List<Datum> getData() {
        return data;
    }
    public void setData(List<Datum> data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Links getLinks() {
        return links;
    }
    public void setLinks(Links links) {
        this.links = links;
    }
}
