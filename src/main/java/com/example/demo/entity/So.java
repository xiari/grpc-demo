package com.example.demo.entity;


import java.util.List;

public class So {

    private Integer id;
    private String orderNo;
    private List<SoItem> soItemList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<SoItem> getSoItemList() {
        return soItemList;
    }

    public void setSoItemList(List<SoItem> soItemList) {
        this.soItemList = soItemList;
    }
}
