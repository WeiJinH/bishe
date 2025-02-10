package com.huangbishe.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.huangbishe.entity.YuangongchuchaiEntity;
import com.huangbishe.entity.YuangongqingjiaEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("yuangongchuchai")
public class YuangongchuchaiView extends YuangongchuchaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public YuangongchuchaiView(){
    }

    public YuangongchuchaiView(YuangongchuchaiEntity yuangongchuchaiEntity){
        try {
            BeanUtils.copyProperties(this, yuangongchuchaiEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
