package com.zzuli.home.model;

public class Pagination {

    private Integer totalRowCount;
    private Integer pageSize;
    private Integer pageCount;
    private Integer currentPage;
    private Integer offset;
    private Integer rowCount;
    private String relativeUrl;
    private Boolean lastPage;
    private String sortString;
    private String keywords;
    
    public Integer getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(Integer totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            String size = "10";
            pageSize = Integer.parseInt(size);
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        if (totalRowCount == null || totalRowCount < 1) {
            pageCount = 0;
            return pageCount;
        }
        pageCount = (totalRowCount - 1) / getPageSize() + 1;
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPage() {
        if (currentPage == null || currentPage < 1) {
            currentPage = 1;
        }
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Get the start position for MySQL limit selection.
     *
     * @return
     */
    public Integer getOffset() {
        offset = (getCurrentPage() - 1) * getPageSize();
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getRowCount() {
        if (rowCount == null || rowCount < 1) {
            rowCount = getPageSize();
        }
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public String getRelativeUrl() {
        return relativeUrl;
    }

    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

    public Boolean getLastPage() {
        this.lastPage = ((getCurrentPage().intValue() == getPageCount().intValue()) || (getPageCount() == 0));
        return this.lastPage;
    }

    public void setLastPage(Boolean lastPage) {
        this.lastPage = lastPage;
    }

    public String getSortString() {
        return sortString;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    
}
