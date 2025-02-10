package com.huangbishe.service.impl;

import com.huangbishe.dao.TongzhigonggaoDao;
import com.huangbishe.entity.TongzhigonggaoEntity;
import com.huangbishe.entity.view.TongzhigonggaoView;
import com.huangbishe.entity.vo.TongzhigonggaoVO;
import com.huangbishe.service.TongzhigonggaoService;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("tongzhigonggaoService")
public class TongzhigonggaoServiceImpl extends ServiceImpl<TongzhigonggaoDao, TongzhigonggaoEntity> implements TongzhigonggaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TongzhigonggaoEntity> page = this.selectPage(
                new Query<TongzhigonggaoEntity>(params).getPage(),
                new EntityWrapper<TongzhigonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TongzhigonggaoEntity> wrapper) {
		  Page<TongzhigonggaoView> page =new Query<TongzhigonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TongzhigonggaoVO> selectListVO(Wrapper<TongzhigonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TongzhigonggaoVO selectVO(Wrapper<TongzhigonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TongzhigonggaoView> selectListView(Wrapper<TongzhigonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TongzhigonggaoView selectView(Wrapper<TongzhigonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
