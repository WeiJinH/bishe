package com.huangbishe.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.huangbishe.entity.TongzhigonggaoEntity;
import com.huangbishe.entity.view.TongzhigonggaoView;
import com.huangbishe.entity.vo.TongzhigonggaoVO;
import com.huangbishe.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 通知公告
 *
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface TongzhigonggaoService extends IService<TongzhigonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TongzhigonggaoVO> selectListVO(Wrapper<TongzhigonggaoEntity> wrapper);
   	
   	TongzhigonggaoVO selectVO(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
   	
   	List<TongzhigonggaoView> selectListView(Wrapper<TongzhigonggaoEntity> wrapper);
   	
   	TongzhigonggaoView selectView(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TongzhigonggaoEntity> wrapper);
   	
}

