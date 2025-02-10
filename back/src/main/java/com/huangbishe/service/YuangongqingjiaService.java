package com.huangbishe.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.huangbishe.entity.YuangongqingjiaEntity;
import com.huangbishe.entity.view.YuangongqingjiaView;
import com.huangbishe.entity.vo.YuangongqingjiaVO;
import com.huangbishe.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 员工请假
 *
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface YuangongqingjiaService extends IService<YuangongqingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongqingjiaVO> selectListVO(Wrapper<YuangongqingjiaEntity> wrapper);
   	
   	YuangongqingjiaVO selectVO(@Param("ew") Wrapper<YuangongqingjiaEntity> wrapper);
   	
   	List<YuangongqingjiaView> selectListView(Wrapper<YuangongqingjiaEntity> wrapper);
   	
   	YuangongqingjiaView selectView(@Param("ew") Wrapper<YuangongqingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongqingjiaEntity> wrapper);
   	
}

