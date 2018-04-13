package com.hotelms.bean;

import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 分页与列表bean*/
@Service
public class ListBean {
    //要显示的对象列表
    private List result;
    //总页数
    private int totalPage;
    //当前页（第一次访问设置为第一页）
    private int currentPage;


    /*
     * 通过总项数和每一页的项数计算总页数
     * @param totalItem 某个列表总项数 、pageItemNum 每一页现实的项数*/
    public void setTotalPageByItemNum(int totalItem, int pageItemNum) {
        int pagenum = totalItem / pageItemNum;
        this.totalPage = totalItem % pageItemNum == 0 ? pagenum : pagenum + 1;
    }


    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "result=" + result +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                '}';
    }
}
