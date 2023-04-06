package com.linkknown.eden.service.impl;

import com.linkknown.eden.bean.DefineVariable;
import com.linkknown.eden.common.aspect.exception.EdenWebException;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.mapper.DefineVariableMapper;
import com.linkknown.eden.service.IDefineVariableService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Service
public class DefineVariableServiceImpl implements IDefineVariableService {

    @Resource
    private DefineVariableMapper defineVariableMapper;


    /**
     * 查询变量集合
     * @param defineVariable 查询参数
     * @return 变量集合
     */
    @Override
    public List<DefineVariable> queryVariableList(DefineVariable defineVariable){
        if (StringUtils.isEmpty(defineVariable.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        return defineVariableMapper.selectDefineVariableList(defineVariable);
    }

    /**
     * 添加变量
     * @param defineVariable 添加参数
     */
    @Override
    public void addVariable(DefineVariable defineVariable){
        if (StringUtils.isEmpty(defineVariable.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(defineVariable.getVarName())){
            throw new EdenWebException(ResponseEnum.VAR_NAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(defineVariable.getVarValue())){
            throw new EdenWebException(ResponseEnum.VAR_VALUE_CAN_NOT_BE_EMPTY);
        }
        defineVariableMapper.insertDefineVariable(defineVariable);
    }

    /**
     * 删除变量
     * @param defineVariable 删除参数
     */
    @Override
    public void deleteVariable(DefineVariable defineVariable){
        if (StringUtils.isEmpty(defineVariable.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(defineVariable.getId())){
            throw new EdenWebException(ResponseEnum.VAR_ID_CAN_NOT_BE_EMPTY);
        }
        defineVariableMapper.deleteDefineVariable(defineVariable);
    }

    /**
     * 更新变量
     * @param defineVariable 更新参数
     */
    @Override
    public void updateVariable(DefineVariable defineVariable){
        if (StringUtils.isEmpty(defineVariable.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(defineVariable.getId())){
            throw new EdenWebException(ResponseEnum.VAR_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(defineVariable.getVarName())){
            throw new EdenWebException(ResponseEnum.VAR_NAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(defineVariable.getVarValue())){
            throw new EdenWebException(ResponseEnum.VAR_VALUE_CAN_NOT_BE_EMPTY);
        }
        defineVariableMapper.updateDefineVariable(defineVariable);
    }

}
