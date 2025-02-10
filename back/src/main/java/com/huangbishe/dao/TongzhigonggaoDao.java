package com.huangbishe.dao;

import com.huangbishe.entity.TongzhigonggaoEntity;
import com.huangbishe.entity.view.TongzhigonggaoView;
import com.huangbishe.entity.vo.TongzhigonggaoVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 通知公告
 * 
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface TongzhigonggaoDao extends BaseMapper<TongzhigonggaoEntity> {
	
	List<TongzhigonggaoVO> selectListVO(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	TongzhigonggaoVO selectVO(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	List<TongzhigonggaoView> selectListView(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);

	List<TongzhigonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	TongzhigonggaoView selectView(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
}
