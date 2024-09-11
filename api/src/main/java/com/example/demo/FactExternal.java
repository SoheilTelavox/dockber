package com.example.demo;

import java.util.List;


public class FactExternal {
    private Integer currentPage;
    private List<FactObject> data;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<FactObject> getData() {
        return data;
    }

    public void setData(List<FactObject> data) {
        this.data = data;
    }
}