package com.tuyue.webModel.comment.biz;


import com.tuyue.entity.LeaveWord;
import com.tuyue.util.Result;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/1/9.
 */
public interface LeaveWordBiz {
    /**
     * @Author: 徐慷慨
     * @Description:添加留言
     * @Date: 15:48 2018/1/9
     */
    public Result inWord(LeaveWord bLeaveWord) throws Exception;
    /**
     * @Author: 徐慷慨
     * @Description:留言列表
     * @Date: 17:05 2018/1/9
     */
    public Result wordList(Integer bid, Integer currentPage, Integer pageSize) throws Exception;
    /**
     * @Author: 徐慷慨
     * @Description:删除留言
     * @Date: 9:58 2018/1/10
     */
    public Result delWord(Integer id);
}
