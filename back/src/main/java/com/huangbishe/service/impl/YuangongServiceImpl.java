package com.huangbishe.service.impl;

import com.huangbishe.dao.YuangongDao;
import com.huangbishe.entity.YuangongEntity;
import com.huangbishe.entity.view.YuangongView;
import com.huangbishe.entity.vo.YuangongVO;
import com.huangbishe.service.YuangongService;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("yuangongService")
public class YuangongServiceImpl extends ServiceImpl<YuangongDao, YuangongEntity> implements YuangongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongEntity> page = this.selectPage(
                new Query<YuangongEntity>(params).getPage(),
                new EntityWrapper<YuangongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongEntity> wrapper) {
		  Page<YuangongView> page =new Query<YuangongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuangongVO> selectListVO(Wrapper<YuangongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuangongVO selectVO(Wrapper<YuangongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuangongView> selectListView(Wrapper<YuangongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangongView selectView(Wrapper<YuangongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
