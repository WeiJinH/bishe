package com.huangbishe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huangbishe.dao.CommonDao;
import com.huangbishe.dao.YuangongchuchaiDao;

import com.huangbishe.entity.YuangongchuchaiEntity;

import com.huangbishe.entity.view.YuangongchuchaiView;
import com.huangbishe.entity.view.YuangongqingjiaView;
import com.huangbishe.entity.vo.YuangongchuchaiVO;
import com.huangbishe.entity.vo.YuangongqingjiaVO;
import com.huangbishe.service.YuangongchuchaiService;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("yuangongchuchaiService")
public class YuangongchuchaiServiceImpl extends ServiceImpl<YuangongchuchaiDao, YuangongchuchaiEntity>  implements YuangongchuchaiService {

    @Autowired
    private YuangongchuchaiDao yuangongchuchaiDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongchuchaiEntity> page = this.selectPage(
                new Query<YuangongchuchaiEntity>(params).getPage(),
                new EntityWrapper<YuangongchuchaiEntity>()
        );
        return new PageUtils(page);
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongchuchaiEntity> wrapper) {
        Page<YuangongchuchaiView> page =new Query<YuangongchuchaiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<Map<String, Object>> barCountOne(Map<String, Object> params){
        return yuangongchuchaiDao.barCountOne(params);
    }



    @Override
    public List<YuangongchuchaiVO> selectListVO(Wrapper<YuangongchuchaiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public YuangongchuchaiVO selectVO(Wrapper<YuangongchuchaiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<YuangongchuchaiView> selectListView(Wrapper<YuangongchuchaiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public YuangongchuchaiView selectView(Wrapper<YuangongchuchaiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
