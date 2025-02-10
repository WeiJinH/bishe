package com.huangbishe.dao;

import com.huangbishe.entity.BumenxinxiEntity;
import com.huangbishe.entity.view.BumenxinxiView;
import com.huangbishe.entity.vo.BumenxinxiVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 部门信息
 * 
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */

public interface BumenxinxiDao extends BaseMapper<BumenxinxiEntity> {
	
	List<BumenxinxiVO> selectListVO(@Param("ew") Wrapper<BumenxinxiEntity> wrapper);
	
	BumenxinxiVO selectVO(@Param("ew") Wrapper<BumenxinxiEntity> wrapper);
	
	List<BumenxinxiView> selectListView(@Param("ew") Wrapper<BumenxinxiEntity> wrapper);

	List<BumenxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BumenxinxiEntity> wrapper);
	
	BumenxinxiView selectView(@Param("ew") Wrapper<BumenxinxiEntity> wrapper);
	
}
