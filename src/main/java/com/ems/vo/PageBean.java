package com.ems.vo;

import java.util.List;

public class PageBean<T> {
    /**
     * 当前页码
     */
    private int currentPageCode;
    /**
     * 总页码数
     */
    private int totalPageCode;


    /**
     * 每页记录的实体
     */
    private List<T> beanList;

    public void setTotalPageCode(int totalPageCode) {
        this.totalPageCode = totalPageCode;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPageCode=" + currentPageCode +
                ", totalPageCode=" + totalPageCode +
                ", beanList=" + beanList +
                '}';
    }

    public PageBean() {
    }

    public PageBean(int currentPageCode, int totalPageCode, List<T> beanList) {
        this.currentPageCode = currentPageCode;
        this.totalPageCode = totalPageCode;

        this.beanList = beanList;
    }

    public int getCurrentPageCode() {
        return currentPageCode;
    }

    public void setCurrentPageCode(int currentPageCode) {
        this.currentPageCode = currentPageCode;
    }

    public int getTotalPageCode() {
        return totalPageCode;
    }


    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
