package com.tuyue.util;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/28.
 */
public class MessageUtil {
    /**
     *
     * @param type  1商修改2买家修改,3联系4降价5发货6催货7商家关闭
     * @param name  名字
     * @param order  订单号
     * @param title   标题
     * @return
     */
    public static String messagetype(int type,String name,String order,String title,String time){
        String str="";
        switch (type){
            case 1:
                str=name+"商家在"+time+"修改了订单号为"+order+"的订单信息，请及时查看订单详情，与商家确认";
                break;
            case 2:
                str=name+"买家在"+time+"修改了订单号为"+order+"的订单信息，请及时查看订单详情，与买家确认";
                break;
            case 3:
               break;
            case 4:
                break;
            case 5:
                str=name+"商家在"+time+"对订单号为"+order+"的订单已经进行发货，请及时查收您的商品";
                break;
            case 6:
                str=name+"买家在"+time+"对订单号为"+order+"订单进行了催促发货操作，请尽快发货，以免误单哦";
                break;
            case 7:
                str=name+"商家在"+time+"关闭了"+order+"的订单，请您及时查看~";
                break;
        }
        return str;
    }
}
