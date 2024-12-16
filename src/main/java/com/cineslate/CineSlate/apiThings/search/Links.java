package com.cineslate.CineSlate.apiThings.search;

public class Links {
    private String prev;
    private String self;
    private String next;
    private Integer totalItems;
    private Integer pageSize;
    public String getPrev() {
        return prev;
    }
    public void setPrev(String prev) {
        this.prev = prev;
    }
    public String getSelf() {
        return self;
    }
    public void setSelf(String self) {
        this.self = self;
    }
    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }
    public Integer getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}