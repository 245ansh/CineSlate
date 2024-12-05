package com.cineslate.CineSlate.apiThings.movie;

public  class Status {
    private int id;
    private boolean keepUpdated;
    private String name;
    private String recordType;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isKeepUpdated() {
        return keepUpdated;
    }
    public void setKeepUpdated(boolean keepUpdated) {
        this.keepUpdated = keepUpdated;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRecordType() {
        return recordType;
    }
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }
    
}