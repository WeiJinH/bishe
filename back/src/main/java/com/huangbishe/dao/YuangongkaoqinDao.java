package com.huangbishe.dao;

import com.huangbishe.entity.YuangongkaoqinEntity;
import com.huangbishe.entity.view.YuangongkaoqinView;
import com.huangbishe.entity.vo.YuangongkaoqinVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 员工考勤
 * 
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
public interface YuangongkaoqinDao extends BaseMapper<YuangongkaoqinEntity> {
	
	List<YuangongkaoqinVO> selectListVO(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
	
	YuangongkaoqinVO selectVO(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
	
	List<YuangongkaoqinView> selectListView(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);

	List<YuangongkaoqinView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
	
	YuangongkaoqinView selectView(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
	
}
