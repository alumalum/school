package com.mf.Until;

import java.util.ArrayList;
import java.util.List;

public class Pages {
    private Integer pageSize = 8;
    private Integer currentPage = 1;
    private Integer totalCount = 0;

    private Integer totalPage;
    private Integer prePage;
    private Integer nextPage;
    private List<Integer> pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        if (getTotalCount() % getPageSize() != 0) {
            return (getTotalCount() / getPageSize()) + 1;
        } else {
            return (getTotalCount() / getPageSize());
        }
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPrePage() {
        if (getCurrentPage() == 1) {
            return 1;
        } else {
            return getCurrentPage() - 1;
        }
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        if (getCurrentPage() == getTotalPage()) {
            return getTotalPage();
        } else {
            return getCurrentPage() + 1;
        }
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public List<Integer> getPageNum() {
        pageNum = new ArrayList<Integer>();
        for (int i = 0; i < getTotalPage(); i++) {
            pageNum.add(i + 1);
        }
        return pageNum;
    }

    public void setPageNum(List<Integer> pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", pageNum=" + pageNum +
                '}';
    }
}
