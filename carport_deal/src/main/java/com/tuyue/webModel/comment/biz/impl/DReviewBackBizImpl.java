package com.tuyue.webModel.comment.biz.impl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.commonBean.User;
import com.tuyue.entity.Carport;
import com.tuyue.entity.ReviewBack;
import com.tuyue.fegin.user.UserFegin;
import com.tuyue.mapper.CarportMapper;
import com.tuyue.mapper.ReviewBackMapper;
import com.tuyue.util.ObjectCopyUtil;
import com.tuyue.util.RandomString;
import com.tuyue.util.Result;
import com.tuyue.webModel.carport.bean.ReviewBacCountkBean;
import com.tuyue.webModel.comment.bean.CommentBean;
import com.tuyue.webModel.comment.bean.Commentstra;
import com.tuyue.webModel.comment.bean.DReviewBackBean;
import com.tuyue.webModel.comment.biz.IDReviewBackBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2017/9/21.
 * @Modified By:
 */
@Service
@Transactional
public class DReviewBackBizImpl implements IDReviewBackBiz {

    @Autowired
    private ReviewBackMapper reviewBackMapper;
    @Autowired
    private UserFegin userFegin;
    @Autowired
    private CarportMapper carportMapper;

    @Override
    public Result add(ReviewBack dReviewBack) throws Exception {
        //评论时间
        dReviewBack.setReviewTime(new Timestamp((new Date()).getTime()) );
        //查询今天是否评论过了
        ReviewBack reviewBack = reviewBackMapper.selectByBidAndIp(dReviewBack.getBid(), dReviewBack.getIp());
        if(reviewBack!=null){
            return Result.error(2,"今天已经评论过了");
        }

        if(dReviewBack.getAid()!=null&&dReviewBack.getAid()>0){
            User aUser = userFegin.selectById(dReviewBack.getAid());
            if(aUser!=null){
                dReviewBack.setIsApprove(aUser.getIsApprove());
                //用户名
                dReviewBack.setUserName(aUser.getUserName());
                //头像
                dReviewBack.setUserImg(aUser.getIoc());
            }
        }else {
            //用户名
            dReviewBack.setUserName("ym_"+ RandomString.getRandomNum(10));
        }
        Carport one1 = carportMapper.selectById(dReviewBack.getBid());
        int save = reviewBackMapper.insert(dReviewBack);
        if(save>0){
           return Result.success(1,"添加评论成功");
        }
        return Result.error(2,"添加评论失败！");
    }

    @Override
    public Map<String,Object> list(Integer currentPage, Integer pageSize, Integer bid, Integer reviewType) throws Exception {
        Page<ReviewBack> page=new Page(currentPage,pageSize);
        List<ReviewBack> reviewBacks = reviewBackMapper.selectListbyBid(page, bid, reviewType);
        List<DReviewBackBean> beanList=new ArrayList<DReviewBackBean>();
        if(reviewBacks!=null){
            for (ReviewBack dReviewBack : reviewBacks) {
                DReviewBackBean copy = ObjectCopyUtil.copy(dReviewBack,ReviewBack.class,  DReviewBackBean.class);
                Integer trueGrade = dReviewBack.getTrueGrade();
                Integer serveGrade = dReviewBack.getServeGrade();
                if(trueGrade==null){
                    trueGrade=0;
                }
                if(serveGrade==null){
                    trueGrade=0;
                }
                float num=0;
                try{
                     num= (float)(trueGrade+serveGrade)/2;
                }catch (Exception e){
                    num=num;
                }
                DecimalFormat df = new DecimalFormat("0.0");//格式化小数
                String s = df.format(num);
                copy.setTrueGrade(s);
                beanList.add(copy);
            }

        }
        Map map=new HashMap();
        map.put("list",beanList);
        map.put("allPage",page.getPages());
        map.put("currentPage",page.getCurrent());
        map.put("pageSize",page.getSize());
        map.put("total",page.getTotal());
        return map;
    }
    /**
     * @Author: 王金海
     * @Description: 好评率和得分
     * @param bid
     * @Date: 17:01 2017/9/21
     */
    @Override
    public Commentstra getStar(Integer bid) throws Exception {
        Commentstra commentstra = new Commentstra();
        int sumcount = 0;
        int okcount = 0;
        List<ReviewBacCountkBean> reviewBacCountkBeans = reviewBackMapper.selectByBidGroupType(bid);
        for (ReviewBacCountkBean reviewBacCountkBean : reviewBacCountkBeans) {
            sumcount+=reviewBacCountkBean.getNum();
            if(reviewBacCountkBean.getReviewType()==3){
                okcount =reviewBacCountkBean.getNum();
            }
        }
        Double zong=0.0;
        Double sever=0.0;
        List<ReviewBack> list=reviewBackMapper.selectByBidGroupTypelist(bid);
        if(list.size()>0){
            for (ReviewBack dReviewBack : list) {
                if(dReviewBack.getTrueGrade()!=null&&dReviewBack.getTrueGrade()>0){
                    zong+=dReviewBack.getTrueGrade();
                }
                if(dReviewBack.getServeGrade()!=null&&dReviewBack.getServeGrade()>0){
                    sever+=dReviewBack.getServeGrade();
                }

            }
        }
        DecimalFormat format = new DecimalFormat("0.00");
        //好评率
        Double realStra=0.0;
        Double severStra=0.0;
        Double goodComment=0.0;
        if (list.size()>0) {
            realStra=zong/(list.size()*5);
            severStra=sever/(list.size()*5);
        }
        if (sumcount>0) {
            String s = format.format((float) okcount / sumcount);
            goodComment=Double.parseDouble(s)*100;
        }
        commentstra.setGoodComment(goodComment);
        commentstra.setRealStra(realStra*5);
        commentstra.setServeStra(severStra*5);
        return commentstra;
    }


    /**
     * @Author: 王金海
     * @Description:  好评中评差评
     * @param bid
     * @Date: 17:20 2017/9/21
     */
    @Override
    public CommentBean getCommentcount(Integer bid) throws Exception {
       int okcount = 0;
        int middleCount = 0;
       int badCount = 0;
        List<ReviewBacCountkBean> reviewBacCountkBeans = reviewBackMapper.selectByBidGroupType(bid);
        for (ReviewBacCountkBean reviewBacCountkBean : reviewBacCountkBeans) {
            if(reviewBacCountkBean.getReviewType()==1){
                okcount=reviewBacCountkBean.getNum();
            }
            if(reviewBacCountkBean.getReviewType()==2){
                middleCount=reviewBacCountkBean.getNum();
            }
            if(reviewBacCountkBean.getReviewType()==3){
                badCount=reviewBacCountkBean.getNum();
            }
        }
        CommentBean commentBean = new CommentBean();
        commentBean.setBadCount(badCount);
        commentBean.setGoodCount(okcount);
        commentBean.setMiddleCount(middleCount);
        return commentBean;
    }
}
