package com.huangbishe.dao;

import com.huangbishe.entity.YuangongEntity;
import com.huangbishe.entity.view.YuangongView;
import com.huangbishe.entity.vo.YuangongVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 员工
 * 
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface YuangongDao extends BaseMapper<YuangongEntity> {
	
	List<YuangongVO> selectListVO(@Param("ew") Wrapper<YuangongEntity> wrapper);
	
	YuangongVO selectVO(@Param("ew") Wrapper<YuangongEntity> wrapper);
	
	List<YuangongView> selectListView(@Param("ew") Wrapper<YuangongEntity> wrapper);

	List<YuangongView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongEntity> wrapper);
	
	YuangongView selectView(@Param("ew") Wrapper<YuangongEntity> wrapper);
	
}
