package com.tuyue.webModel.carport.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.commonBean.User;
import com.tuyue.util.ObjectCopyUtil;
import com.tuyue.webModel.carport.bean.*;
import com.tuyue.webModel.carport.service.CarportService;
import com.tuyue.commonBean.ComHourses;
import com.tuyue.commonBean.TradingArea;
import com.tuyue.entity.*;
import com.tuyue.fegin.hourse.HourseFegin;
import com.tuyue.fegin.trading.TradingFegin;
import com.tuyue.fegin.user.UserFegin;
import com.tuyue.mapper.*;
import com.tuyue.util.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/9.
 */
@Service
public class CarportServiceImpl implements CarportService {
    private static final Logger logger = LoggerFactory.getLogger(CarportServiceImpl.class);
    @Autowired
    private CarportMapper carportMapper;
    @Autowired
    private UserFegin userFegin;
    @Autowired
    private TradingFegin tradingFegin;
    @Autowired
    private CarportImgMapper carportImgMapper;
    @Autowired
    private CarportNoMapper carportNoMapper;
    @Autowired
    private HourseFegin hourseFegin;
    @Autowired
    private AttentionMapper attentionMapper;
    @Autowired
    private CarportPointMapper carportPointMapper;

    @Override
    public Result addCarport(CarportBean careBean) {
        User user = userFegin.selectById(1);
        System.out.println(user.toString());
        if (user == null) {
            return Result.error(2, "您的账号不存在");
        }
        if (user.getFlag().equals("1") && careBean.getRentType() == 3) {
            return Result.error(2, "您之前注册的是个人用户，不能发布出售车位");
        }
        if (user.getFlag().equals("1") && careBean.getReleaseType() == 2) {
            return Result.error(2, "您之前注册的是个人用户，不能发批量");
        }
        if (user.getFlag().equals("2") && careBean.getRentType() == 2) { //1出租2转让3出售5求购6求租
            return Result.error(2, "您之前注册的是企业用户，不能发布转让车位");
        }
        if (user.getFlag().equals("2") && careBean.getRentType() == 5) { //1出租2转让3出售5求购6求租
            return Result.error(2, "您之前注册的是企业用户，不能发布求购车位");
        }
        if (user.getFlag().equals("2") && careBean.getRentType() == 6) { //1出租2转让3出售5求购6求租
            return Result.error(2, "您之前注册的是企业用户，不能发布求租车位");
        }
        if (careBean.getIsSale() == null) {
            careBean.setIsSale(2);
        }

        if (careBean.getRentType() != 5 && careBean.getRentType() != 6) {
            if (careBean.getCarportFloors().getFloorsType() > 0) { //选了自定义内容
                careBean.setFloorsType(careBean.getCarportFloors().getFloorsType());
                if (careBean.getRentType() == 2) {
                    //转让类型(单个)
                    careBean.setFloors(careBean.getCarportFloors().getFloorsNum());
                } else if (careBean.getReleaseType() == 1) { //单个
                    careBean.setFloors(careBean.getCarportFloors().getFloorsNum());
                } else {
                    //批量发布
                    String aa = "";
                    if (careBean.getCarportFloors().getFloors() != null) { //用户勾选的楼层
                        aa = careBean.getCarportFloors().getFloors();
                        careBean.setFloorsOriginal(careBean.getCarportFloors().getFloors());//用户勾选的楼层
                    }
                    if (careBean.getCarportFloors().getFloorsNum() != null) { //用户输入的楼层
                        if (aa.length() > 0) {
                            aa = aa + ",";
                        }
                        if (careBean.getCarportFloors().getFloorsType() == 2) { //自定义范围楼层
                            careBean.setFloorsNumOriginal(careBean.getCarportFloors().getFloorsNum());//用户输入的楼层范围
                            String[] split = careBean.getCarportFloors().getFloorsNum().split("~");
                            String s = split[0];
                            String s1 = split[1];
                            if (s.equals(s1)) {
                                return Result.error(2, "您输入的楼层信息不符合规范");
                            }
                            if (s.endsWith("F") && s1.endsWith("F")) { //范围都是地上的
                                int i = Integer.parseInt(s.substring(0, s.length() - 1));
                                int j = Integer.parseInt(s1.substring(0, s1.length() - 1));
                                if (i < j) {
                                    for (int k = i; k <= j; k++) {
                                        String a = k + "F";
                                        aa += a + ",";
                                    }
                                } else {
                                    for (int k = j; k <= i; k++) {
                                        String a = k + "F";
                                        aa += a + ",";
                                    }
                                }

                            } else if (s.startsWith("B") && s1.startsWith("B")) { //范围都是地下的
                                int i = Integer.parseInt(s.substring(1, s.length()));
                                int j = Integer.parseInt(s1.substring(1, s1.length()));
                                if (i < j) {
                                    for (int k = i; k <= j; k++) {
                                        aa += "B" + k + ",";
                                    }
                                } else {
                                    for (int k = j; k <= i; k++) {
                                        aa += "B" + k + ",";
                                    }
                                }
                            } else { // 范围是一个地上一个地下
                                int i = 0;
                                int j = 0;
                                if (s.startsWith("B")) {
                                    j = Integer.parseInt(s.substring(1, s.length()));
                                } else {
                                    i = Integer.parseInt(s.substring(0, s.length() - 1));
                                }
                                if (s1.startsWith("B")) {
                                    j = Integer.parseInt(s1.substring(1, s1.length()));
                                } else {
                                    i = Integer.parseInt(s1.substring(0, s1.length() - 1));
                                }
                                for (int k = 1; k <= i; k++) {
                                    String a = k + "F";
                                    aa += a + ",";
                                }
                                for (int k = 1; k <= j; k++) {
                                    aa += "B" + k + ",";
                                }

                            }
                        } else {
                            //自定义楼层
                            aa = careBean.getCarportFloors().getFloorsNum();
                        }
                    }

                    String[] split = aa.split(",");
                    List<String> list = Arrays.asList(split);
                    Set set = new HashSet(list);
                    String join = StringUtils.join(set, ",");
                    careBean.setFloors(join);
                }
            } else {
                //没有选自定义楼层
                careBean.setFloors(careBean.getCarportFloors().getFloors());
            }
        }
        /**
         * 添加操作
         * 1添加商圈
         * 2添加车位
         * 3添加图片
         * 4添加车位编号
         */
        //1添加商圈
        Result result = tradingFegin.selectByName(careBean.getBusinessCircles());
        System.out.println(result.getMsg());
        if(result.getCode()==1){
            JSON.toJSONString(result.getData());
            TradingArea  tradingArea=  JSON.parseObject(JSON.toJSONString(result.getData()),TradingArea.class);
           careBean.setComBusinesId(tradingArea.getComBusinesId());
        }
        if(result.getCode()==3){
            return result;
        }
        if (result.getCode() == 2) { //说明没有此商圈要进行添加商圈
            TradingArea tradingArea = new TradingArea();
            tradingArea.setBusinessCircles(careBean.getBusinessCircles());
            tradingArea.setSource(1);
            Result result1 = tradingFegin.addTrading(tradingArea);
            if (result1.getCode() == 3) {
                return result1;
            }
            if(result1.getCode()==1){
                careBean.setComBusinesId((Integer) result1.getData());
            }

        }
        //2添加车位
        careBean.setIsPutaway(1);
        if (careBean.getRentType() == 2 || careBean.getRentType() == 3||careBean.getRentType() == 6||careBean.getRentType() == 7) {  //出售转让时万元
            careBean.setCarportMoney(careBean.getCarportMoney() * 10000);
            careBean.setCarportPrice(careBean.getCarportPrice() != null ? careBean.getCarportPrice() * 10000 : 0);
            careBean.setLowerMoney(careBean.getCarportMoney());
            careBean.setLowerPrice(careBean.getCarportPrice() != null ? careBean.getCarportPrice(): 0);
        }else{
            careBean.setLowerMoney(careBean.getCarportMoney());
            careBean.setLowerPrice(0.0);
        }
        Integer insert = carportMapper.insert(careBean);
        if (insert < 0) {
            return Result.error(2, "添加失败！");
        }
        //3添加图片
        if (careBean.getCarportImgList() != null && careBean.getCarportImgList().size() > 0) {
            for (CarportImg carportImg : careBean.getCarportImgList()) {
                carportImg.setBid(insert);
                carportImgMapper.insert(carportImg);
            }
        }
        //4添加车位编号
        if (careBean.getCarportNoList() != null && careBean.getCarportNoList().size() > 0) {
            for (CarportNo carportNo : careBean.getCarportNoList()) {
                carportNo.setBid(insert);
                carportNoMapper.insert(carportNo);
            }
        }
        return Result.success(1, "SUCCESS");

    }

    @Override
    public Result upCarport(CarportBean careBean) {
        User user = userFegin.selectById(careBean.getAid());
        if (careBean.getRentType() != 5 && careBean.getRentType() != 6) {
            if (careBean.getCarportFloors().getFloorsType() > 0) { //选了自定义内容
                careBean.setFloorsType(careBean.getCarportFloors().getFloorsType());
                if (careBean.getRentType() == 2) {
                    //转让类型(单个)
                    careBean.setFloors(careBean.getCarportFloors().getFloorsNum());
                } else if (careBean.getReleaseType() == 1) { //单个
                    careBean.setFloors(careBean.getCarportFloors().getFloorsNum());
                } else {
                    //批量发布
                    String aa = "";
                    if (careBean.getCarportFloors().getFloors() != null) { //用户勾选的楼层
                        aa = careBean.getCarportFloors().getFloors();
                        careBean.setFloorsOriginal(careBean.getCarportFloors().getFloors());//用户勾选的楼层
                    }
                    if (careBean.getCarportFloors().getFloorsNum() != null) { //用户输入的楼层
                        if (aa.length() > 0) {
                            aa = aa + ",";
                        }
                        if (careBean.getCarportFloors().getFloorsType() == 2) { //自定义范围楼层
                            careBean.setFloorsNumOriginal(careBean.getCarportFloors().getFloorsNum());//用户输入的楼层范围
                            String[] split = careBean.getCarportFloors().getFloorsNum().split("~");
                            String s = split[0];
                            String s1 = split[1];
                            if (s.equals(s1)) {
                                return Result.error(2, "您输入的楼层信息不符合规范");
                            }
                            if (s.endsWith("F") && s1.endsWith("F")) { //范围都是地上的
                                int i = Integer.parseInt(s.substring(0, s.length() - 1));
                                int j = Integer.parseInt(s1.substring(0, s1.length() - 1));
                                if (i < j) {
                                    for (int k = i; k <= j; k++) {
                                        String a = k + "F";
                                        aa += a + ",";
                                    }
                                } else {
                                    for (int k = j; k <= i; k++) {
                                        String a = k + "F";
                                        aa += a + ",";
                                    }
                                }

                            } else if (s.startsWith("B") && s1.startsWith("B")) { //范围都是地下的
                                int i = Integer.parseInt(s.substring(1, s.length()));
                                int j = Integer.parseInt(s1.substring(1, s1.length()));
                                if (i < j) {
                                    for (int k = i; k <= j; k++) {
                                        aa += "B" + k + ",";
                                    }
                                } else {
                                    for (int k = j; k <= i; k++) {
                                        aa += "B" + k + ",";
                                    }
                                }
                            } else { // 范围是一个地上一个地下
                                int i = 0;
                                int j = 0;
                                if (s.startsWith("B")) {
                                    j = Integer.parseInt(s.substring(1, s.length()));
                                } else {
                                    i = Integer.parseInt(s.substring(0, s.length() - 1));
                                }
                                if (s1.startsWith("B")) {
                                    j = Integer.parseInt(s1.substring(1, s1.length()));
                                } else {
                                    i = Integer.parseInt(s1.substring(0, s1.length() - 1));
                                }
                                for (int k = 1; k <= i; k++) {
                                    String a = k + "F";
                                    aa += a + ",";
                                }
                                for (int k = 1; k <= j; k++) {
                                    aa += "B" + k + ",";
                                }

                            }
                        } else {
                            //自定义楼层
                            aa = careBean.getCarportFloors().getFloorsNum();
                        }
                    }

                    String[] split = aa.split(",");
                    List<String> list = Arrays.asList(split);
                    Set set = new HashSet(list);
                    String join = StringUtils.join(set, ",");
                    careBean.setFloors(join);
                }
            } else {
                //没有选自定义楼层
                careBean.setFloors(careBean.getCarportFloors().getFloors());
            }
        }
        /**
         * 添加操作
         * 1添加商圈
         * 2:修改车位
         * 3添加图片
         * 4添加车位编号
         */
        //1添加商圈
        Result result = tradingFegin.selectByName(careBean.getBusinessCircles());
        if (result.getCode() == 2) { //说明没有此商圈要进行添加商圈
            TradingArea tradingArea = new TradingArea();
            tradingArea.setBusinessCircles(careBean.getBusinessCircles());
            tradingArea.setSource(1);
            Result result1 = tradingFegin.addTrading(tradingArea);
            if (result.getCode() == 2) {
                return Result.error(2, "添加商圈失败！");
            }
        }
        //2添加车位
        careBean.setIsPutaway(1);
        if (careBean.getRentType() == 2 || careBean.getRentType() == 3) {  //出售转让时万元
            careBean.setCarportMoney(careBean.getCarportMoney() * 10000);
            careBean.setCarportPrice(careBean.getCarportPrice() != null ? careBean.getCarportPrice() * 10000 : 0);
        }
        Integer insert = carportMapper.updateById(careBean);
        if (insert < 0) {
            return Result.error(2, "添加失败！");
        }
        //3添加图片
        if (careBean.getCarportImgList() != null && careBean.getCarportImgList().size() > 0) {
            carportImgMapper.delete(new EntityWrapper<CarportImg>().eq("bid", careBean.getBid()));
            for (CarportImg carportImg : careBean.getCarportImgList()) {
                carportImg.setBid(careBean.getBid());
                carportImgMapper.insert(carportImg);
            }
        }
        //4添加车位编号
        if (careBean.getCarportNoList() != null && careBean.getCarportNoList().size() > 0) {
            carportNoMapper.delete(new EntityWrapper<CarportNo>().eq("bid", careBean.getBid()));
            for (CarportNo carportNo : careBean.getCarportNoList()) {
                carportNo.setBid(insert);
                carportNoMapper.insert(carportNo);
            }
        }
        return Result.success(1, "SUCCESS");
    }

    /**
     * 查询车位
     */
    @Override
    public Result selectCarport(Page<Carport> page,ParamSearch paramSearch) throws IllegalAccessException, InstantiationException {
        boolean searchState=true;
        String ids="";
        //根据条件查询楼盘
        if (paramSearch.getCity() != null || paramSearch.getRegion() != null || paramSearch.getProvince() != null) {
            ComHourses comHourses = new ComHourses();
            comHourses.setProvince(paramSearch.getProvince() != null ? paramSearch.getProvince() : null);
            comHourses.setCity(paramSearch.getCity() != null ? paramSearch.getCity() : null);
            comHourses.setRegion(paramSearch.getRegion() != null ? paramSearch.getRegion() : null);
            Result result = hourseFegin.selectHourse(comHourses);
            System.out.println("查询出来的结果"+result.getMsg());
            if (result.getCode() == 1) {
                String string = JSON.toJSONString(result.getData());
                List<ComHourses> list = JSON.parseArray(string, ComHourses.class);
                if (list != null && list.size() > 0) {
                    for (ComHourses hourses : list) {
                        ids += hourses.getHourseId() + ",";
                    }
                    if (ids.endsWith(",")) {
                        ids=ids.substring(0,ids.length()-1);
                    }
                }
            }
        }
        paramSearch.setHourseId(ids);
        List<Carport> carportList = null;
        carportList=carportMapper.selectCarport(page, paramSearch);
        if(carportList==null||carportList.size()<=0){
            searchState=false;
            carportList=carportMapper.carportAllList(page);
        }
        List<CarportListBean> listBeans=new ArrayList<CarportListBean>();
        for (Carport carport : carportList) {
            //CarportListBean carportListBean = ObjectCopyUtil.copy(carport, Carport.class, CarportListBean.class);
            CarportListBean carportListBean=new CarportListBean();
            carportListBean.setAid(carport.getAid());
            carportListBean.setBid(carport.getBid());
            carportListBean.setCarportType(carport.getCarportType());
            carportListBean.setTitle(carport.getTitle());
            carportListBean.setMaxSize(carport.getMaxSize());
            carportListBean.setRentType(carport.getRentType());
            carportListBean.setIsSale(carport.getIsSale()!=null?carport.getIsSale():2);
            carportListBean.setSalePrice(carport.getSalePrice());
            carportListBean.setIssueTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( carport.getIssueTime().getTime()));
            if(carport.getFlag()==1){
                carportListBean.setCompanyType("个人");
            }else{
                carportListBean.setCompanyType("企业");
            }

            //查找楼盘信息
            Result result = hourseFegin.selectById(carport.getHourseId());
            if(result.getCode()==1){
                ComHourses comHourses= (ComHourses) result.getData();
                carportListBean.setProvince(comHourses.getProvince());
                carportListBean.setCity(comHourses.getCity());
                carportListBean.setRegion(comHourses.getRegion());
                carportListBean.setHourseName(comHourses.getHourseName());
                carportListBean.setHousesAdress(comHourses.getHousesAdress());
            }

            //查找首页图片
            List<CarportImg> carportImgList = carportImgMapper.selectList(new EntityWrapper<CarportImg>().eq("bid", carport.getBid()));
            String mainImg="";
            if(carportImgList.size()>0){
                for (CarportImg carportImg : carportImgList) {
                    if(carportImg.getImgType()==1){
                        mainImg=carportImg.getImgUrl();
                        break;
                    }
                }
            }
            carportListBean.setMainImg(mainImg);
            carportListBean.setImgNum(carportImgList.size());
            //查找关注数
            Integer integer = attentionMapper.selectCount(new EntityWrapper<Attention>().eq("bid", carport.getBid()).eq("is_del", 2));
            carportListBean.setAttentionNum(integer);

            //todo 被标记为虚假信息数暂时给0
            carportListBean.setFakeNum(0);
            //查找浏览数
            Integer i = carportPointMapper.selectPointNumSumByBid(carport.getBid());
            carportListBean.setBrowseNum(i!=null?i:0);
            String money="";
            /**
             * 1：首先判断是元的还是万元的单位是元的显示的都是x元/x月的格式
             * 2：判断是单个还是批量的
             */
            if(carport.getRentType()==1||carport.getRentType()==6){ //元的
                if(carport.getRentType()==5||carport.getRentType()==6){ //求购求租的
                    money=carport.getLowerMoney()+"元";
                }else{
                    money=carport.getLowerMoney()+"元/"+carport.getMoneyTime()+"月";
                }
            }else{// 万元的
                if(carport.getReleaseType()==1){
                  money=carport.getLowerMoney()/10000+"万元";
                }else{
                    money=carport.getLowerMoney()+"万元~"+carport.getLowerPrice()+"万元";
                }
            }
            carportListBean.setMoney(money);
            listBeans.add(carportListBean);
        }
        Map map = new HashMap();
        map.put("currentPage", page.getCurrent());
        map.put("pageSize", page.getSize());
        map.put("allPage", page.getPages());
        map.put("total", page.getTotal());
        map.put("list", listBeans);
        map.put("searchState",searchState);
        return Result.success(1,"",map);
    }

    /**
     * 车位详情
     */
    @Override
    @Transactional
    public Result carPortDetils(Integer bid, Integer aid, String IP) throws IllegalAccessException, InstantiationException {
        /**
         *  1查询是否有该车位
         *  2添加车位点击次数
         */
        Carport carport = carportMapper.selectById(bid);
        if(carport!=null){
            /**
             * 添加车位点击次数
             */
            CarportPoint carportPoint1 = carportPointMapper.selectByAidAndIp(aid, IP);
            if(carportPoint1!=null){
                carportPoint1.setPointNum(carportPoint1.getPointNum()+1);
                carportPointMapper.updateById(carportPoint1);
            }else{
                CarportPoint carportPoint=new CarportPoint();
                carportPoint.setBid(bid);
                carportPoint.setIp(IP);
                carportPoint.setAid(aid!=null?aid:null);
                carportPointMapper.insert(carportPoint);
            }
          //车位详情
            //查询车位详情
            CarPortDetilsBean portDetiles = ObjectCopyUtil.copy(carport, Carport.class, CarPortDetilsBean.class);
            List<CarportImg> imgList = carportImgMapper.selectTypeByBid(bid);
            portDetiles.setImglist(imgList);
            //楼层信息
            if (carport.getFloors() != null && carport.getFloors().length() > 0) {
                String floors = carport.getFloors().replaceAll("B", "-").replaceAll("F", "");
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
                    if (FLOOS.length()>0){
                        FLOOS += ";" + join1;
                    }else{
                        FLOOS +=join1;
                    }

                }

                portDetiles.setFloors(FLOOS);
            }
           //查询用户信息
            User user = userFegin.selectById(carport.getAid());
            if(carport.getFlag()==2){ //企业用户查询企业信息
                portDetiles.setCompanyName(user.getName()!=null?user.getName():"企业");
            }else{
                portDetiles.setCompanyName("个人");
            }
            //判断是否关注过
            portDetiles.setIsAttention(1);
            if (aid!=null) {
                Attention attention=new Attention();
                attention.setBid(bid);
                attention.setAid(aid);
                Attention one1 =attentionMapper.selectOne(attention);
                if (one1 == null) {
                    portDetiles.setIsAttention(2);
                }
            }
            portDetiles.setProveType(user != null ? user.getIsApprove() : null);//是否认证1是2否
            portDetiles.setAid(user != null ? user.getAid() : null);
            return Result.success(1,"车位详情", portDetiles);
        }else{
            return Result.error(2,"查询不到该车位");
        }
    }

    /**
     * 车位详情中查询企业信息
     * @param aid
     * @return
     * @throws Exception
     */
    @Override
    public Result companyDetails(Integer aid) throws Exception{
        User one = userFegin.selectById(aid);
        CompanyBean companyBean = new CompanyBean();
        if (one != null) {
            companyBean.setCompanyName(one.getName());
            companyBean.setArea(one.getProvince() + one.getCity() + one.getRegion());
            companyBean.setAddress(one.getAddress());
            companyBean.setCompanyType(one.getCompanyType());
            companyBean.setCompanySizes(one.getCompanyScale());
           // companyBean.setCompanyDesc(one.getCompanyDesc());
            companyBean.setEmily(one.getEmail());
            companyBean.setPhone(one.getPhone());
        }
        return Result.success(1,"企业信息", companyBean);
    }
}
