package com.tuyue;

import com.tuyue.entity.ComHourses;
import com.tuyue.hourse.service.HouseService;
import com.tuyue.util.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServerApplicationTests {
 @Autowired
 private HouseService houseService;

	@Test
	public void contextLoads() {
		ComHourses comHouses =new ComHourses();
		comHouses.setProvince("山西");
		Result result = houseService.selectHourse(comHouses);
		System.out.println(result.getMsg());

	}
}
