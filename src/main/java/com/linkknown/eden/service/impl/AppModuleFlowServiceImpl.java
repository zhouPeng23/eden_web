package com.linkknown.eden.service.impl;

import com.linkknown.eden.bean.AppModuleFlow;
import com.linkknown.eden.common.aspect.exception.EdenWebException;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.mapper.AppModuleFlowMapper;
import com.linkknown.eden.service.IAppModuleFlowService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Service
public class AppModuleFlowServiceImpl implements IAppModuleFlowService {

    @Resource
    private AppModuleFlowMapper appModuleFlowMapper;

    /**
     * 查询应用模块流程集合
     * @param appModuleFlow 查询参数
     * @return 集合
     */
    @Override
    public List<AppModuleFlow> queryAppModuleFlowList(AppModuleFlow appModuleFlow){
        if (StringUtils.isEmpty(appModuleFlow.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        return appModuleFlowMapper.selectAppModuleFlowList(appModuleFlow);
    }

    /**
     * 添加应用模块流程
     * @param appModuleFlow 添加参数
     */
    @Override
    public void addAppModuleFlow(AppModuleFlow appModuleFlow){
        if (StringUtils.isEmpty(appModuleFlow.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModuleFlow.getModuleId())){
            throw new EdenWebException(ResponseEnum.MODULE_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModuleFlow.getFlowName())){
            throw new EdenWebException(ResponseEnum.FLOW_NAME_CAN_NOT_BE_EMPTY);
        }
        appModuleFlowMapper.insertAppModuleFlow(appModuleFlow);
    }

    /**
     * 删除模块流程
     * @param appModuleFlow 删除参数
     */
    @Override
    public void deleteAppModuleFlow(AppModuleFlow appModuleFlow){
        if (StringUtils.isEmpty(appModuleFlow.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModuleFlow.getModuleId())){
            throw new EdenWebException(ResponseEnum.MODULE_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModuleFlow.getFlowId())){
            throw new EdenWebException(ResponseEnum.FLOW_ID_CAN_NOT_BE_EMPTY);
        }
        appModuleFlowMapper.deleteAppModuleFlow(appModuleFlow);
    }

    /**
     * 更新模块流程
     * @param appModuleFlow 更新参数
     */
    @Override
    public void updateAppModuleFlow(AppModuleFlow appModuleFlow){
        if (StringUtils.isEmpty(appModuleFlow.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModuleFlow.getModuleId())){
            throw new EdenWebException(ResponseEnum.MODULE_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModuleFlow.getFlowId())){
            throw new EdenWebException(ResponseEnum.FLOW_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModuleFlow.getFlowName())){
            throw new EdenWebException(ResponseEnum.FLOW_NAME_CAN_NOT_BE_EMPTY);
        }
        appModuleFlowMapper.updateAppModuleFlow(appModuleFlow);
    }


}
