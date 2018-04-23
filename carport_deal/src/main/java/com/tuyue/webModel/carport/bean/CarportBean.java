package com.tuyue.webModel.carport.bean;

import com.tuyue.entity.Carport;
import com.tuyue.entity.CarportImg;
import com.tuyue.entity.CarportNo;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/12.
 */
public class CarportBean extends Carport {
    private List<CarportImg> carportImgList;
    private List<CarportNo> carportNoList;
    private CarportFloors carportFloors;
    private String businessCircles;

    public String getBusinessCircles() {
        return businessCircles;
    }

    public void setBusinessCircles(String businessCircles) {
        this.businessCircles = businessCircles;
    }

    public List<CarportImg> getCarportImgList() {
        return carportImgList;
    }


    public void setCarportImgList(List<CarportImg> carportImgList) {
        this.carportImgList = carportImgList;
    }


    public List<CarportNo> getCarportNoList() {
        return carportNoList;
    }


    public void setCarportNoList(List<CarportNo> carportNoList) {
        this.carportNoList = carportNoList;
    }

    public CarportFloors getCarportFloors() {
        return carportFloors;
    }

    public void setCarportFloors(CarportFloors carportFloors) {
        this.carportFloors = carportFloors;
    }
}
