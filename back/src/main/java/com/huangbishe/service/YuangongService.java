package com.huangbishe.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.huangbishe.entity.YuangongEntity;
import com.huangbishe.entity.view.YuangongView;
import com.huangbishe.entity.vo.YuangongVO;
import com.huangbishe.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 员工
 *
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface YuangongService extends IService<YuangongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongVO> selectListVO(Wrapper<YuangongEntity> wrapper);
   	
   	YuangongVO selectVO(@Param("ew") Wrapper<YuangongEntity> wrapper);
   	
   	List<YuangongView> selectListView(Wrapper<YuangongEntity> wrapper);
   	
   	YuangongView selectView(@Param("ew") Wrapper<YuangongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongEntity> wrapper);
   	
}

