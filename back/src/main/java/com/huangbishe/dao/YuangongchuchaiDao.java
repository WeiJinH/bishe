package com.huangbishe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huangbishe.entity.YuangongchuchaiEntity;
import com.huangbishe.entity.YuangongqingjiaEntity;
import com.huangbishe.entity.view.YuangongchuchaiView;
import com.huangbishe.entity.view.YuangongqingjiaView;
import com.huangbishe.entity.vo.YuangongchuchaiVO;
import com.huangbishe.entity.vo.YuangongqingjiaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface YuangongchuchaiDao extends BaseMapper<YuangongchuchaiEntity> {
    List<YuangongchuchaiVO> selectListVO(@Param("ew") Wrapper<YuangongchuchaiEntity> wrapper);

    YuangongchuchaiVO selectVO(@Param("ew") Wrapper<YuangongchuchaiEntity> wrapper);

    List<YuangongchuchaiView> selectListView(@Param("ew") Wrapper<YuangongchuchaiEntity> wrapper);

    List<YuangongchuchaiView> selectListView(Pagination page, @Param("ew") Wrapper<YuangongchuchaiEntity> wrapper);

    YuangongchuchaiView selectView(@Param("ew") Wrapper<YuangongchuchaiEntity> wrapper);



    List<Map<String, Object>> barCountOne(Map<String, Object> params);
}
