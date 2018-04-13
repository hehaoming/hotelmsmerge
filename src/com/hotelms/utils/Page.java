package com.hotelms.utils;

import java.util.List;

public class Page<T> {

    public static final int ROOMSET_PER_PAGE_NUM = 5;

    private int totalRecordsNum;    //总记录数

    private int currentPage;     //当前处于第几页，在请求参数中要告诉后台要去显示的页码

    private int totalPage; //总的页数

    private  int prevPageNum;  //前一页

    private  int nextPageNum;  //后一页

    private List<T> result;    //查找的当前页码显示的记录数目要放在这个里面


    //设置了有参构造 也要设置无参构造
    public Page() {
    }

    //每页显示多少条记录 也通过参数传入，灵活，不同的page对象该值不同
    public Page(int totalRecordsNum, int currentPage, int NumPerPage) {

        //总记录数
        this.totalRecordsNum = totalRecordsNum;

        //当前处于第几页. 请求参数里应该告诉后台要去显示的页码
        this.currentPage = currentPage;

        //总的页码数
        int i = totalRecordsNum/NumPerPage;
        int totalPage = totalRecordsNum % NumPerPage == 0 ? i : i+1;
        setTotalPage(totalPage);

        //前一页
        int prevPageNum = currentPage - 1 == 0 ? currentPage : currentPage - 1;
        setPrevPageNum(prevPageNum);

        //后一页
        int nextPageNum = currentPage + 1 > totalPage ? currentPage : currentPage + 1;
        setNextPageNum(nextPageNum);


    }


    public int getTotalRecordsNum() {
        return totalRecordsNum;
    }

    public void setTotalRecordsNum(int totalRecordsNum) {
        this.totalRecordsNum = totalRecordsNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrevPageNum() {
        return prevPageNum;
    }

    public void setPrevPageNum(int prevPageNum) {
        this.prevPageNum = prevPageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalRecordsNum=" + totalRecordsNum +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", prevPageNum=" + prevPageNum +
                ", nextPageNum=" + nextPageNum +
                ", result=" + result +
                '}';
    }
}
