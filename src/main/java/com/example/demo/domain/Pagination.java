package com.example.demo.domain;

public class Pagination {
    private int page = 1;
    private int pageSize = 10;
    private int totalItemCount;

    private int startPage;
    private int lastPage;
    private int endPage;
    private int navSize = 10;
    private boolean hasPrev;
    private boolean hasNext;

    private int offset;

    public Pagination(int page, int totalItemCount, int pageSize) {
        this.pageSize = pageSize;
        this.totalItemCount = totalItemCount;
        this.page = page;
        setup();
    }

    public Pagination(int page, int totalItemCount) {
        this.totalItemCount = totalItemCount;
        this.page = page;
        setup();
    }

    private void setup() {
        endPage = (int) Math.ceil((double) totalItemCount / pageSize);
        if(page > endPage) page = endPage;
        else if(page <= 0) page = 1;
        startPage = ((int) Math.ceil((double) page/navSize) - 1) * navSize + 1;
        lastPage = Math.min(startPage + navSize - 1, endPage);
        offset = pageSize * (page - 1);
        hasPrev = startPage > 1;
        hasNext = lastPage < endPage;
    }

    
    public int getPage() {
        return this.page;
    }
    
    public int getPageSize() {
        return this.pageSize;
    }
    
    public int getTotalItemCount() {
        return this.totalItemCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getOffset() {
        return offset;
    }

    public boolean getHasPrev() {
        return hasPrev;
    }

    public boolean getHasNext() {
        return hasNext;
    }
}
