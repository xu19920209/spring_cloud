package com.tuyue.webModel.comment.biz.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.commonBean.User;
import com.tuyue.commonBean.UserImg;
import com.tuyue.entity.Carport;
import com.tuyue.entity.LeaveWord;
import com.tuyue.fegin.user.UserFegin;
import com.tuyue.mapper.CarportMapper;
import com.tuyue.mapper.LeaveWordMapper;
import com.tuyue.util.RandomString;
import com.tuyue.util.Result;
import com.tuyue.util.Setting;
import com.tuyue.webModel.comment.bean.LeaveWordBean;
import com.tuyue.webModel.comment.biz.LeaveWordBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/1/9.
 */
@Service
@Transactional
public class LeaveWordBizImpl implements LeaveWordBiz {
    @Autowired
    private LeaveWordMapper leaveWordMapper;
    @Autowired
    private UserFegin userFegin;
    @Autowired
    private CarportMapper carportMapper;

    /**
     * @Author: 徐慷慨
     * @Description:添加留言
     * @Date: 15:48 2018/1/9
     */
    @Override
    public Result inWord(LeaveWord leaveWord) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        leaveWord.setWordTime(format);
        if (leaveWord.getAid() != null&&leaveWord.getAid()>0) {
            User user = userFegin.selectById(leaveWord.getAid());
            if(user!=null) {
                leaveWord.setName(user.getName());
                List<UserImg> userImgList = user.getUserImgList();
                if(userImgList!=null){
                    for (UserImg userImg : userImgList) {
                        if(userImg.getImgType()==1){
                            leaveWord.setUserHead(userImg.getImgUrl());
                            break;
                        }
                    }
                }
                leaveWord.setUserType(user.getFlag());
                leaveWord.setProveType(user.getIsApprove());
            }
        } else {
            leaveWord.setName("ym_"+ RandomString.getRandomNum(10));
            leaveWord.setUserHead(Setting.PERSONAGEPIC);
            leaveWord.setUserType(4);
            leaveWord.setProveType(2);
        }
        if (leaveWord.getType() == 2) { // 回复留言
            if(leaveWord.getParentId()==null){
                return Result.error(2,"回复留言parentId不能为空！");
            }
            LeaveWord one = leaveWordMapper.selectById(leaveWord.getParentId());
            leaveWord.setBid(one.getBid());
            if(one.getType()==1){ // 直接回复发表留言的
                leaveWord.setId(one.getWordId());
            }else{ //回复别人评论的
                leaveWord.setId(one.getId());
            }
            if (leaveWord.getAid() != null) {
                Carport one1 = carportMapper.selectById(one.getBid());
                if(one1!=null&& Objects.equals(one1.getAid(), leaveWord.getAid())){
                    leaveWord.setUserType(3);
                }
            }
        }
        int save = leaveWordMapper.insert(leaveWord);
        if(save>0){
            return Result.success(1,"添加留言成功");
        }else{
            return Result.error(2,"添加留言失败！");
        }

    }

    /**
     * @Author: 徐慷慨
     * @Description:留言列表
     * @Date: 17:05 2018/1/9
     */
    @Override
    public Result wordList(Integer bid, Integer currentPage , Integer pageSize) throws Exception {
        Page page=new Page();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        List<LeaveWord> leaveWords = leaveWordMapper.selectByBid(page, bid);
        List<LeaveWordBean> beans=new ArrayList<LeaveWordBean>();
        if(leaveWords!=null){
            for (LeaveWord bLeaveWord : leaveWords) {
                LeaveWordBean leaveWordBean =new LeaveWordBean();
                leaveWordBean.setFromName(bLeaveWord.getName());//谁发表的留言
                leaveWordBean.setContent(bLeaveWord.getContent());//留言内容
                leaveWordBean.setId(bLeaveWord.getWordId());//留言id
                leaveWordBean.setUserHead(bLeaveWord.getUserHead());
                leaveWordBean.setProveType(bLeaveWord.getProveType());
                leaveWordBean.setTime(bLeaveWord.getWordTime());
                leaveWordBean.setAid(bLeaveWord.getAid());
                //查询回复的留言
                List<LeaveWord> list = leaveWordMapper.selectByID(bLeaveWord.getWordId());
                leaveWordBean.setNum(list.size());
                List<LeaveWordBean> leaveWordBeans=new ArrayList<LeaveWordBean>();
                if(list.size()>0){
                    for (LeaveWord leaveWord : list) {
                        LeaveWord one = leaveWordMapper.selectById(leaveWord.getParentId());
                        LeaveWordBean leaveWordBean1 =new LeaveWordBean();
                        leaveWordBean1.setToName(one.getName());
                        leaveWordBean1.setUserType(leaveWord.getUserType());
                        leaveWordBean1.setAid(leaveWord.getAid());
                        leaveWordBean1.setFromName(leaveWord.getName());//谁发表的留言
                        leaveWordBean1.setContent(leaveWord.getContent());//留言内容
                        leaveWordBean1.setId(leaveWord.getWordId());//留言id
                        leaveWordBean1.setUserHead(leaveWord.getUserHead());
                        leaveWordBean1.setProveType(leaveWord.getProveType());
                        leaveWordBean1.setTime(leaveWord.getWordTime());
                        leaveWordBeans.add(leaveWordBean1);
                    }
                    leaveWordBean.setChildList(leaveWordBeans);
                }
                beans.add(leaveWordBean);
            }
        }
        Map map =new HashMap();
        map.put("currentPage",page.getCurrent());
        map.put("pageSize",page.getSize());
        map.put("total",page.getTotal());
        map.put("allPage",page.getPages());
        map.put("list",beans);
        return Result.success(1,"留言列表",map);
    }

    /**
     * @Author: 徐慷慨
     * @Description:删除留言
     * @Date: 9:58 2018/1/10
     */
    @Override
    public Result delWord(Integer id){
        int i = leaveWordMapper.deleteById(id);
        if(i>0){
            return Result.success(1,"删除成功！");
        }else{
            return Result.error(2,"删除失败！");
        }
    }
}
