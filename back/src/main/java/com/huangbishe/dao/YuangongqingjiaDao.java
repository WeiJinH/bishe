package com.huangbishe.dao;

import com.huangbishe.entity.YuangongqingjiaEntity;
import com.huangbishe.entity.view.YuangongqingjiaView;
import com.huangbishe.entity.vo.YuangongqingjiaVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 员工请假
 * 
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface YuangongqingjiaDao extends BaseMapper<YuangongqingjiaEntity> {
	
	List<YuangongqingjiaVO> selectListVO(@Param("ew") Wrapper<YuangongqingjiaEntity> wrapper);
	
	YuangongqingjiaVO selectVO(@Param("ew") Wrapper<YuangongqingjiaEntity> wrapper);
	
	List<YuangongqingjiaView> selectListView(@Param("ew") Wrapper<YuangongqingjiaEntity> wrapper);

	List<YuangongqingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongqingjiaEntity> wrapper);
	
	YuangongqingjiaView selectView(@Param("ew") Wrapper<YuangongqingjiaEntity> wrapper);
	
}
