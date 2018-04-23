package com.tuyue.webModel.order.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.commonBean.User;
import com.tuyue.entity.*;
import com.tuyue.fegin.user.UserFegin;
import com.tuyue.mapper.*;
import com.tuyue.util.*;
import com.tuyue.webModel.order.bean.OrderBean;
import com.tuyue.webModel.order.bean.OrdersCount;
import com.tuyue.webModel.order.service.OrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.goeasy.GoEasy;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/10.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderHistoryMapper orderHistoryMapper;
    @Autowired
    private CarportMapper carportMapper;
    @Autowired
    private CarportNoMapper carportNoMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserFegin userFegin;
    @Autowired
    private ReviewBackMapper reviewBackMapper;

    @Override
    public int inOrders(Orders orders) {
        Integer insert = ordersMapper.insert(orders);
        return insert;
    }

    @Override
    public int upOrders(Orders orders) {
        Integer updateById = ordersMapper.updateById(orders);
        return updateById;
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @param type    1是商家删除2买家删除
     * @return
     */
    @Override
    public int delOrder(int orderId, int type) {
        int i = ordersMapper.delOrdersByUser(orderId, type);
        return i;
    }

    /**
     * 买家订单列表
     *
     * @param aid
     * @param type 订单类型
     * @param time 时间 1三月2一年3所有
     * @return str 输入框输入的值
     */
    @Override
    public List<OrderBean> orderList(Page<OrderBean> page, Integer aid, Integer type, Integer time, String str) {

        List<OrderBean> orderBeans = ordersMapper.orderList(page, aid, type, time, str);
        if (orderBeans.size() > 0) {
            for (OrderBean orderBean : orderBeans) {
                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setOrderId(orderBean.getOrderId());
                orderHistory.setType(1);
                OrderHistory orderHistory1 = orderHistoryMapper.selectUpType(orderBean.getOrderId(), 2);
                if (null != orderHistory1) {
                    orderBean.setUpType(1);
                    orderBean.setUpTime((Timestamp) orderHistory1.getUpTime());
                }
            }
        }
        return orderBeans;
    }

    @Override
    public List<OrderBean> orderListMerchant(Page<OrderBean> page, Integer aid, Integer type, Integer time, String str) {
        List<OrderBean> orderBeans = ordersMapper.orderList(page, aid, type, time, str);
        long timeMillis = System.currentTimeMillis();
        if (orderBeans.size() > 0) {
            for (OrderBean orderBean : orderBeans) {
                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setOrderId(orderBean.getOrderId());
                orderHistory.setType(2);
                OrderHistory orderHistory1 = orderHistoryMapper.selectUpType(orderBean.getOrderId(), 1);
                if (null != orderHistory1) {
                    orderBean.setUpType(1);
                    orderBean.setUpTime((Timestamp) orderHistory1.getUpTime());
                }
                if(orderBean.getOrderStatus()==0){
                    if(timeMillis>orderBean.getOutTime().getTime()){
                        orderBean.setOrderStatus(4);
                    }
                }
            }
        }
        return orderBeans;
    }

    @Override
    public int closeOrder(int orderId, String msg) throws Exception {
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setCancelCause(msg);
        Integer updateById = ordersMapper.updateById(orders);
        return updateById;
    }

    @Override
    public int deliverGoods(int orderId, String imgUrl) throws Exception {
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setDeliverImg(imgUrl);
        Integer updateById = ordersMapper.updateById(orders);
        return updateById;
    }

    @Override
    public OrderBean upOrderDetails(int orderId, int type) throws Exception {
        Orders one1 = ordersMapper.selectById(orderId);
        OrderBean copy = null;
        if (one1 == null) {
            return null;
        } else {
            copy = ObjectCopyUtil.copy(one1, Orders.class, OrderBean.class);
            Carport one = carportMapper.selectById(copy.getBid());
            copy.setRentType(one.getRentType());
            copy.setCarportTypes(one.getCarportType());
            List<CarportNo> list = carportNoMapper.selectList(new EntityWrapper<CarportNo>().eq("bid", one.getBid()));
            if (list != null) {
                copy.setCarportNoList(list);
            }
            UserAddress one2 = userAddressMapper.selectById(one1.getAddressId());
            if (one2 != null) {
                copy.setAddress(one2.getAddress());
                copy.setDetailAddress(one2.getDetailAddress());
                copy.setRecipientsName(one2.getRecipientsName());
                copy.setRecipientsPhone(one2.getRecipientsPhone());
            }
            OrderHistory orderHistory = orderHistoryMapper.selectUpType(orderId, type);

            if (orderHistory != null) {
                copy.setUpType(1);
                copy.setUpTime((Timestamp) orderHistory.getUpTime());
            }
            if (one.getFloors() != null && one.getFloors().length() > 0) {
                String floors = one.getFloors().replaceAll("B", "-").replaceAll("F", "");
                String[] split = floors.split(",");
                List<String> list2 = Arrays.asList(split);
                List<Integer> listInt1 = new ArrayList<Integer>();
                List<Integer> listInt2 = new ArrayList<Integer>();
                for (String s : list2) {
                    if (Integer.parseInt(s) > 0) {
                        listInt1.add(Integer.parseInt(s));
                    } else {
                        listInt2.add(Integer.parseInt(s));
                    }
                }
                String FLOOS = "";
                if (listInt1.size() > 0) {
                    Collections.sort(listInt1);
                    String join = StringUtils.join(listInt1, "F,") + "F";
                    FLOOS = join;
                }
                if (listInt2.size() > 0) {
                    Collections.sort(listInt2, Collections.reverseOrder());
                    String join1 = StringUtils.join(listInt2, ",").replaceAll("-", "B");
                    if (FLOOS.length() > 0) {
                        FLOOS += ";" + join1;
                    } else {
                        FLOOS += join1;
                    }

                }
                copy.setFlooss(FLOOS);
            }
            copy.setCarportType("");
            copy.setFloos("");
            return copy;
        }


    }


    @Override
    public List<OrdersCount> orderTypeNum(int aid, int type) {
        List<OrdersCount> ordersCounts = ordersMapper.orderTypeNum(aid, type);
        return ordersCounts;
    }

    @Override
    public String selectCarNumber(String carHome) {
        Map<String, Object> map = ordersMapper.selectCarNumber(carHome);
        if (map != null) {
            return (String) map.get("str");
        }
        return "A";
    }

    @Override
    public Result urgeOrder(int orderId) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        long count = orderHistoryMapper.selectAlertNum(orderId,format);
        if (count >= 3) {
            return Result.error(2, "您今天的发货提醒达到上限，请明天再催促发货");
        }
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setType(3);
        orderHistory.setOrderId(orderId);
        int save = orderHistoryMapper.insert(orderHistory);
        String str = "";
        if (save > 0) {
            GoEasy goEasy = new GoEasy(GoEasyUtil.host, GoEasyUtil.key);
            HashMap<String, String> maps = new HashMap<String, String>();
            maps.put("type", String.valueOf(4));
            //给商家推送消息
            Orders one = ordersMapper.selectById(orderId);
            Carport one1 = carportMapper.selectById(one.getBid());
            User one2 = userFegin.selectById(one.getAid());
            str = MessageUtil.messagetype(5, one2.getUserName(), one.getOrderNumber(), "", "format");
            JPushUtil.sendMsgToApp("催促发货提醒", "", str, maps, String.valueOf(one.getAid()));
            JPushUtil.sendMsgToIos("催促发货提醒", "", str, maps, String.valueOf(one.getAid()));
            goEasy.publish("" + one2.getAid() + "", str);
            Message message = new Message();
            message.setAid(one1.getAid());
            message.setBid(one.getBid());
            message.setUserName(one2.getUserName());
            message.setOrderNo(one.getOrderNumber());
            message.setType(6);
            message.setMessageType(1);
            messageMapper.insert(message);
            return Result.success(1,"SUCCESS");
        } else {
            return Result.error(2, "ERROR");
        }
    }

    @Override
    @Transactional
    public int confirmOrder(int orderId, int aid) throws Exception {
        /**
         * 1修改订单信息
         * 2修改车位，将该车位下架
         */
        Orders orders = ordersMapper.selectById(orderId);
        orders.setOrderStatus(3);
        ordersMapper.updateById(orders);
        Carport carport = new Carport();
        carport.setBid(orders.getBid());
        carport.setIsPutaway(2);
        Integer updateById = carportMapper.updateById(carport);
        return updateById;
    }

    @Override
    public Result appraiseBack(int orderId, int aid) throws Exception {
        ReviewBack reviewBack=new ReviewBack();
        reviewBack.setAid(aid);
        reviewBack.setOrderId(orderId);
        reviewBack.setType(1);
        ReviewBack reviewBack1 = reviewBackMapper.selectOne(reviewBack);
        // DReviewBack one = dReviewBackIBaseDao.findOne("from DReviewBack where orderId='" + orderId + "' and aid=" + aid + " and type=1");
        if (reviewBack1 != null) {
            return Result.success(1,"success", reviewBack1);
        }
        return Result.error(2, "暂未查到信息");

    }

    @Override
    public Result orderDelByNumber(String orderNumber) throws Exception {
        Map map = new HashMap();
        Orders orders=new Orders();
        orders.setOrderNumber(orderNumber);
        Orders one= ordersMapper.selectOne(orders);
        if (one != null) {
            if (one.getCarHome() != null) {
                map.put("str", one.getCarHome() + one.getCarLevel() + "," + one.getCarNumber());
                map.put("type", 1);
            } else {
                map.put("str", one.getPropertyName() + "," + one.getPropertyNumber());
                map.put("type", 2);
            }
            map.put("money", one.getOrderMoney());
            map.put("time", one.getOrderTime());
            map.put("title", carportMapper.selectById(one.getBid()).getTitle());
            map.put("orderNumber", orderNumber);
            map.put("outTime", one.getOutTime());
            return Result.success(1,"success", map);
        }
        return Result.error(2, "查不到该订单");
    }

    @Override
    public Result replyEcho(Integer orderId) throws Exception {
        List<ReviewBack> reviewBacks = reviewBackMapper.selectList(new EntityWrapper<ReviewBack>().eq("order_id", orderId).ne("type", 3).orderBy("review_time",true));
        return Result.success(1,"SUCCESS", reviewBacks);
    }
}
