package com.cineslate.CineSlate.apiThings.search;
public class Links {
    private String prev;
    private String self;
    private String next;
    private long totalItems;
    private long pageSize;

    public String getPrev() { return prev; }
    public void setPrev(String value) { this.prev = value; }

    public String getSelf() { return self; }
    public void setSelf(String value) { this.self = value; }

    public String getNext() { return next; }
    public void setNext(String value) { this.next = value; }

    public long getTotalItems() { return totalItems; }
    public void setTotalItems(long value) { this.totalItems = value; }

    public long getPageSize() { return pageSize; }
    public void setPageSize(long value) { this.pageSize = value; }
}
