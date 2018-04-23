package com.tuyue.webModel.comment.biz;

import com.tuyue.entity.ReviewBack;
import com.tuyue.util.Result;
import com.tuyue.webModel.comment.bean.CommentBean;
import com.tuyue.webModel.comment.bean.Commentstra;
import com.tuyue.webModel.comment.bean.DReviewBackBean;

import java.util.List;
import java.util.Map;

/**
 * @Author: 王金海
 * @Description: 车位出租转租评论
 * @Date: Created by Administrator on 2017/9/21.
 * @Modified By:
 */
public interface IDReviewBackBiz {
    /**
     * @Author: 王金海
     * @Description:  增加评论
      * @param dReviewBack
     * @Date: 9:15 2017/9/21
     */
    Result add(ReviewBack dReviewBack) throws Exception;

    /**
     * @Author: 王金海
     * @Description: 通过车位ID查找对应评论
      * @param bid
     * @Date: 11:04 2017/9/21
     */
    Map<String,Object> list(Integer currentPage, Integer pageSize, Integer bid, Integer reviewType) throws Exception;


    /**
     * @Author: 王金海
     * @Description: 好评率和得分
      * @param bid
     * @Date: 17:01 2017/9/21
     */
    Commentstra getStar(Integer bid) throws Exception;

    /**
     * @Author: 王金海
     * @Description:  好评中评差评
      * @param bid
     * @Date: 17:20 2017/9/21
     */
    CommentBean getCommentcount(Integer bid) throws Exception;
}
