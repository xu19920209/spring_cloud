package com.tuyue.webModel.comment.biz.impl;


import com.tuyue.entity.Report;
import com.tuyue.mapper.ReportMapper;
import com.tuyue.util.Result;
import com.tuyue.webModel.comment.biz.ReportBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/1/10.
 */
@Service
public class ReportBizImpl  implements ReportBiz {
    @Autowired
  private ReportMapper reportMapper;
    /**
     * @Author: 徐慷慨
     * @Description:添加举报
     * @Date: 10:07 2018/1/10
     */
    @Override
    @Transactional
    public Result inReport(Report bReport){
        int save = reportMapper.insert(bReport);
        if(save>0){
            return Result.success(1,"添加成功！");
        }else{
            return Result.error(2,"添加失败！");
        }
    }
}
