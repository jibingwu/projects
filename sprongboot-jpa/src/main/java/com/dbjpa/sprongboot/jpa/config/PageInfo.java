package com.dbjpa.sprongboot.jpa.config;

public class PageInfo<T> {

    private Long totalRecords;
    private Integer currentPage;
    private Long totalPage;
    private Integer pageSize;
    private T data;

    public PageInfo(Long totalRecords, Integer currentPage, Integer pageSize, T data){
        this.totalRecords = totalRecords;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = (totalRecords - 1) / pageSize + 1;
        this.data = data;
    }
}
