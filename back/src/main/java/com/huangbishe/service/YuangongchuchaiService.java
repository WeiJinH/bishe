package com.huangbishe.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.huangbishe.entity.YuangongchuchaiEntity;
import com.huangbishe.entity.view.YuangongchuchaiView;
import com.huangbishe.entity.view.YuangongqingjiaView;
import com.huangbishe.entity.vo.YuangongchuchaiVO;
import com.huangbishe.entity.vo.YuangongqingjiaVO;
import com.huangbishe.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface YuangongchuchaiService extends IService<YuangongchuchaiEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<YuangongchuchaiVO> selectListVO(Wrapper<YuangongchuchaiEntity> wrapper);

    YuangongchuchaiVO selectVO(@Param("ew") Wrapper<YuangongchuchaiEntity> wrapper);

    List<YuangongchuchaiView> selectListView(Wrapper<YuangongchuchaiEntity> wrapper);

    YuangongchuchaiView selectView(@Param("ew") Wrapper<YuangongchuchaiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongchuchaiEntity> wrapper);

    List<Map<String, Object>> barCountOne(Map<String, Object> params);

}
