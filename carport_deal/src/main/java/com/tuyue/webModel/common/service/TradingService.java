package com.tuyue.webModel.common.service;

import com.tuyue.util.Result;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/21.
 */
public interface TradingService {
    /**
     * 根据名字模糊查询商圈名
     * @param name
     * @return
     */
    public Result TradingList(String name);
}
