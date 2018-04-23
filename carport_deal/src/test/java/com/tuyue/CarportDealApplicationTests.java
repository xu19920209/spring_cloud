package com.tuyue;

import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.mapper.ReviewBackMapper;
import com.tuyue.webModel.carport.bean.ParamSearch;
import com.tuyue.webModel.carport.bean.ReviewBacCountkBean;
import com.tuyue.webModel.carport.service.CarportService;
import com.tuyue.util.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarportDealApplicationTests {
@Autowired
private CarportService carportService;
@Autowired
private ReviewBackMapper reviewBackMapper;
	@Test
	public void contextLoads() {
		List<ReviewBacCountkBean> reviewBacCountkBeans = reviewBackMapper.selectByBidGroupType(1);
		for (ReviewBacCountkBean reviewBacCountkBean : reviewBacCountkBeans) {
			System.out.println(reviewBacCountkBean.getReviewType());
		}

	}

}
