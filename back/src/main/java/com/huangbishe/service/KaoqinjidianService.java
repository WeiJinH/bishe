package com.huangbishe.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.huangbishe.entity.view.KaoqinjidianView;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.entity.KaoqinjidianEntity;
import java.util.List;
import java.util.Map;
import com.huangbishe.entity.vo.KaoqinjidianVO;
import org.apache.ibatis.annotations.Param;


/**
 * 考勤基点
 *
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface KaoqinjidianService extends IService<KaoqinjidianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoqinjidianVO> selectListVO(Wrapper<KaoqinjidianEntity> wrapper);
   	
   	KaoqinjidianVO selectVO(@Param("ew") Wrapper<KaoqinjidianEntity> wrapper);
   	
   	List<KaoqinjidianView> selectListView(Wrapper<KaoqinjidianEntity> wrapper);
   	
   	KaoqinjidianView selectView(@Param("ew") Wrapper<KaoqinjidianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaoqinjidianEntity> wrapper);
   	
}

