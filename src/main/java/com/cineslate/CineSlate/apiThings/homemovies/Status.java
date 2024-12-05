package com.cineslate.CineSlate.apiThings.homemovies;

public class Status {
    private long id;
    private boolean keepUpdated;
    private String name;
    private String recordType;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public boolean getKeepUpdated() { return keepUpdated; }
    public void setKeepUpdated(boolean value) { this.keepUpdated = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getRecordType() { return recordType; }
    public void setRecordType(String value) { this.recordType = value; }
}
