package com.huangbishe.service.impl;

import com.huangbishe.dao.KaoqinjidianDao;
import com.huangbishe.entity.KaoqinjidianEntity;
import com.huangbishe.entity.view.KaoqinjidianView;
import com.huangbishe.entity.vo.KaoqinjidianVO;
import com.huangbishe.service.KaoqinjidianService;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("kaoqinjidianService")
public class KaoqinjidianServiceImpl extends ServiceImpl<KaoqinjidianDao, KaoqinjidianEntity> implements KaoqinjidianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoqinjidianEntity> page = this.selectPage(
                new Query<KaoqinjidianEntity>(params).getPage(),
                new EntityWrapper<KaoqinjidianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoqinjidianEntity> wrapper) {
		  Page<KaoqinjidianView> page =new Query<KaoqinjidianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoqinjidianVO> selectListVO(Wrapper<KaoqinjidianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoqinjidianVO selectVO(Wrapper<KaoqinjidianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoqinjidianView> selectListView(Wrapper<KaoqinjidianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoqinjidianView selectView(Wrapper<KaoqinjidianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
