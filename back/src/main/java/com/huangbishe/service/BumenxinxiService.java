package com.huangbishe.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.huangbishe.entity.BumenxinxiEntity;
import com.huangbishe.entity.view.BumenxinxiView;
import com.huangbishe.entity.vo.BumenxinxiVO;
import com.huangbishe.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 部门信息
 *
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface BumenxinxiService extends IService<BumenxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BumenxinxiVO> selectListVO(Wrapper<BumenxinxiEntity> wrapper);
   	
   	BumenxinxiVO selectVO(@Param("ew") Wrapper<BumenxinxiEntity> wrapper);
   	
   	List<BumenxinxiView> selectListView(Wrapper<BumenxinxiEntity> wrapper);
   	
   	BumenxinxiView selectView(@Param("ew") Wrapper<BumenxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BumenxinxiEntity> wrapper);
   	
}

