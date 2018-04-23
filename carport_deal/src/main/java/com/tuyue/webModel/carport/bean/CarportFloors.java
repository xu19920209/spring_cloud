package com.tuyue.webModel.carport.bean;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/1/8.
 */
public class CarportFloors {
    private int floorsType;//1自定义楼层2自定义楼层范围
    private String floors;//楼层数据逗号隔开B1,F1
    private String floorsNum;//自定义楼层数据B1~F1

    public int getFloorsType() {
        return floorsType;
    }

    public void setFloorsType(int floorsType) {
        this.floorsType = floorsType;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getFloorsNum() {
        return floorsNum;
    }

    public void setFloorsNum(String floorsNum) {
        this.floorsNum = floorsNum;
    }

    @Override
    public String toString() {
        return "CarportFloors{" +
                "floorsType=" + floorsType +
                ", floors='" + floors + '\'' +
                ", floorsNum='" + floorsNum + '\'' +
                '}';
    }
}
