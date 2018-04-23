package com.tuyue.webModel.order.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.tuyue.aLi.AliParam;
import com.tuyue.entity.Carport;
import com.tuyue.entity.Orders;
import com.tuyue.mapper.CarportMapper;
import com.tuyue.mapper.OrdersMapper;
import com.tuyue.webModel.order.bean.BizContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/2/6.
 */
@Controller
@RequestMapping("web/order")
public class CarportPayController {
    @Autowired
    private CarportMapper carportMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @RequestMapping("unifiedorder")
    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String orderNumber) throws Exception {
//        Orders one =ordersMapper.selectByOrderNumber(orderNumber);
//        long time = System.currentTimeMillis();
//        long time1 = one.getOutTime().getTime();
//        if(time>time1){
//            httpResponse.getWriter().write("该订单已关闭，请重新下单");
//        }
//
//        Carport one1 = carportMapper.selectById(one.getBid());
//        double money=0;
//        if(one1.getIsLowerMoney()==1){
//            if(one1.getLowerPrice()!=null){
//                money=one1.getLowerPrice();
//            }else{
//                money=one1.getLowerMoney();
//            }
//        }else{
//            if(one1.getCarportPrice()!=null){
//                money=one1.getCarportPrice();
//            }else{
//                money=one1.getCarportMoney();
//            }
//        }
//        if(one1.getRentType()==2||one1.getRentType()==3){ //万元的
//            money=money*10000;
//        }
//        money=money*one.getBuyNum();
//        if(one1.getIsSale()==1){
//        money=money-one1.getSalePrice();
//        }
//        //修改订单信息
//        ordersMapper.upOrderByNumber(orderNumber);
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AliParam.appid, AliParam.ali_privateKey, "JSON", "utf-8", AliParam.alipaypublickey, "RSA2"); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("https://www.baidu.com");
        alipayRequest.setNotifyUrl("http://19124za186.imwork.net:46540/carport/web/order/bbb");//在公共参数中设置回跳和通知地址
        BizContent bizContent=new BizContent();
        bizContent.setBody("车位买卖");
        long l = System.currentTimeMillis();
//        bizContent.setOut_trade_no(orderNumber);
//        bizContent.setTotal_amount(String.valueOf(money));
        bizContent.setOut_trade_no("456");
        bizContent.setTotal_amount("0.01");
        bizContent.setSubject("车位买卖");
        alipayRequest.setBizContent(JSON.toJSONString(bizContent));//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
       } catch (AlipayApiException e) {
           e.printStackTrace();
       }
        httpResponse.setContentType("text/html;charset=utf-8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping("bbb")
    public void notifyUrl(HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("支付进来了");
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        ServletInputStream inputStream = request.getInputStream();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
      //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
       // boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE) //调用SDK验证签名
        boolean signVerfied = AlipaySignature.rsaCheckV1(params, AliParam.alipaypublickey, "UTF-8", "RSA2");
        String back="success";
        if(signVerfied){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            // 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
//            String out_trade_no = params.get("out_trade_no");
//            Orders one = ordersIBaseDao.findOne("from  Orders where orderNumber='" + out_trade_no + "'");
//            if(one==null){
//                back="failure";
//            }
//          2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
//            String total_amount = params.get("total_amount");
//            if(Double.parseDouble(total_amount)!=one.getReallyMoney()){
//                back="failure";
//            }
//            3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
//            4、验证app_id是否为该商户本身。
            System.out.println("支付成功");
            response.getWriter().write(back);
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            System.out.println("支付失败");
            response.getWriter().write(back);
        }
    }
}
