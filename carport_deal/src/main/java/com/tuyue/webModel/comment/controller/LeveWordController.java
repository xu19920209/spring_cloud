package com.tuyue.webModel.comment.controller;

import com.tuyue.entity.LeaveWord;
import com.tuyue.util.Result;
import com.tuyue.webModel.comment.biz.LeaveWordBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/1/9.
 */
@Controller
@RequestMapping("web/word")
@ResponseBody
public class LeveWordController {
    @Autowired
    private LeaveWordBiz leaveWordBiz;
    /**
     * @Author: 徐慷慨
     * @Description:添加留言
     * @Date: 15:48 2018/1/9
     */
    @RequestMapping("inWord")
    public Result inWord(@RequestBody LeaveWord bLeaveWord) throws Exception{
        if(bLeaveWord.getId()!=null&&bLeaveWord.getId()>0){
            return leaveWordBiz.delWord(bLeaveWord.getId());
        }
        return leaveWordBiz.inWord(bLeaveWord);
    }
    /**
     * @Author: 徐慷慨
     * @Description:删除留言
     * @Date: 9:58 2018/1/10
     */
    @RequestMapping("delWord")
    public Result delWord( @RequestParam(required = true) int id){
        return leaveWordBiz.delWord(id);
    }
    /**
     * @Author: 徐慷慨
     * @Description:留言列表
     * @Date: 17:05 2018/1/9
     */
    @RequestMapping("wordList")
    public Result wordList(Integer bid, @RequestParam(defaultValue="1") int currentPage , @RequestParam(defaultValue="10")int pageSize) throws Exception{
        if(currentPage==0){
            currentPage=1;
        }
        if(pageSize==0){
            pageSize=10;
        }
        return leaveWordBiz.wordList(bid,currentPage , pageSize);
    }
}
