package com.huangbishe.service.impl;

import com.huangbishe.dao.BumenxinxiDao;
import com.huangbishe.entity.BumenxinxiEntity;
import com.huangbishe.entity.view.BumenxinxiView;
import com.huangbishe.entity.vo.BumenxinxiVO;
import com.huangbishe.service.BumenxinxiService;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("bumenxinxiService")
public class BumenxinxiServiceImpl extends ServiceImpl<BumenxinxiDao, BumenxinxiEntity> implements BumenxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BumenxinxiEntity> page = this.selectPage(
                new Query<BumenxinxiEntity>(params).getPage(),
                new EntityWrapper<BumenxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BumenxinxiEntity> wrapper) {
		  Page<BumenxinxiView> page =new Query<BumenxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BumenxinxiVO> selectListVO(Wrapper<BumenxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BumenxinxiVO selectVO(Wrapper<BumenxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BumenxinxiView> selectListView(Wrapper<BumenxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BumenxinxiView selectView(Wrapper<BumenxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
