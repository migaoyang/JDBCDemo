package stu.domain;

import java.util.List;

public class PageBean<T> {

    private int currentPage; //当前页
    private List<T> list;  //当前页面集合
    private int totalPage; //总页数
    private int pageSize ; // 每页的记录数
    private int totalSize; //总记录

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", list=" + list +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }




}
