package com.huangbishe;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huangbishe.dao.UserDao;

import com.huangbishe.entity.UserEntity;

import com.huangbishe.entity.YuangongqingjiaEntity;
import com.huangbishe.service.YuangongqingjiaService;
import com.huangbishe.utils.BaiduUtil;
import com.huangbishe.utils.MPUtil;
import com.huangbishe.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
class SpringbootSchemaApplicationTests {
	@Autowired
	UserDao userDao;
@Autowired
YuangongqingjiaService yuangongqingjiaService;


	@Test
	void testadd() {
		UserEntity user =new UserEntity();
		user.setUsername("aaa");
		user.setPassword("123456");
		userDao.insert(user);
	}

	@Test
	void testupdate() {
		UserEntity user =new UserEntity();
		user.setId(3L);
		user.setUsername("abc");
		user.setPassword("234567");
		userDao.updateById(user);

	}



	@Test
	void testgetAll() {

		EntityWrapper<UserEntity> ew = new EntityWrapper<>();
		// 调用接口方法
		List<UserEntity> userEntities = userDao.selectListView(ew);
		// 打印结果
		userEntities.forEach(user -> System.out.println(user.getUsername() + ": " + user.getPassword()));
	}


	@Test
    void testgetId(){

		UserEntity userEntity = userDao.selectById(1);
		System.out.println(userEntity);
	}


	@Test
	public void list(){
		EntityWrapper<YuangongqingjiaEntity> ew = new EntityWrapper<YuangongqingjiaEntity>();
		ew.allEq(MPUtil.allEQMapPre( yuangongqingjiaService, "yuangongqingjia"));
        R.ok().put("data", yuangongqingjiaService.selectListView(ew));
    }

	@Test
			public void testBaidu() {
		String ak = "Lb1PylHDkH4XgEbDDqAIdO3v5LrrYGWJ";
		String lng = "116.404";
		String lat = "39.915";
		Map<String, String> cityInfo = BaiduUtil.getCityByLonLat(ak, lng, lat);
		if (cityInfo != null) {
			System.out.println("Province: " + cityInfo.get("province"));
			System.out.println("City: " + cityInfo.get("city"));
			System.out.println("District: " + cityInfo.get("district"));
			System.out.println("Street: " + cityInfo.get("street"));
		} else {
			System.out.println("Failed to get city information.");
		}
	}


}
