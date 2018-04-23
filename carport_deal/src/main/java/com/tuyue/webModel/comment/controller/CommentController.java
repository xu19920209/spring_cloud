package com.tuyue.webModel.comment.controller;

import com.tuyue.entity.ReviewBack;
import com.tuyue.util.GetIp;
import com.tuyue.util.Result;
import com.tuyue.webModel.comment.bean.CommentBean;
import com.tuyue.webModel.comment.bean.Commentstra;
import com.tuyue.webModel.comment.biz.IDReviewBackBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 王金海
 * @Description: 评论
 * @Date: Created by Administrator on 2017/9/21.
 * @Modified By:
 */
@RestController()
@RequestMapping("Comment")
public class CommentController {

    @Autowired
    private IDReviewBackBiz reviewBackBiz;
    /**
     * @Author: 王金海
     * @Description: 增加评论
      * @param
     * @Date: 9:22 2017/9/21
     */
    @PostMapping("add")
    public Result add(@RequestBody ReviewBack dReviewBack, HttpServletRequest request) throws Exception {
        String ip = GetIp.getIpAddr(request);
        dReviewBack.setIp(ip);
        return reviewBackBiz.add(dReviewBack);
    }

    /**
     * @Author: 王金海
     * @Description: 通过出租ID查找对应评论
     * @param bid
     * @Date: 11:04 2017/9/21
     */
    @GetMapping("list")
    public Result list(@RequestParam(value = "currentPage",required = true) Integer currentPage, @RequestParam(value = "pageSize",required = true)  Integer pageSize, @RequestParam(value = "bid",required = true) Integer bid, @RequestParam(value = "reviewType",required = false)Integer reviewType) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> list = reviewBackBiz.list(currentPage, pageSize, bid, reviewType);
        Commentstra commentstra = reviewBackBiz.getStar(bid);
        CommentBean commentBean = reviewBackBiz.getCommentcount(bid);
        map.put("commentstra",commentstra);// 好评率 和 得分
        map.put("dReviewBackPage",list);
        map.put("commentBean",commentBean);// 好评  中评 差评
        return Result.success(1,"SUCCESS" ,map);
    }
}
