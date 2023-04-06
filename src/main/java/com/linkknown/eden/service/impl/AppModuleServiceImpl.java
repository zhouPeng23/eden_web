package com.linkknown.eden.service.impl;

import com.linkknown.eden.bean.AppModule;
import com.linkknown.eden.bean.AppModuleFlow;
import com.linkknown.eden.common.aspect.exception.EdenWebException;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.mapper.AppModuleFlowMapper;
import com.linkknown.eden.mapper.AppModuleMapper;
import com.linkknown.eden.service.IAppModuleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Service
public class AppModuleServiceImpl implements IAppModuleService {

    @Resource
    private AppModuleMapper appModuleMapper;

    @Resource
    private AppModuleFlowMapper appModuleFlowMapper;

    /**
     * 查询应用模块集合
     * @param appModule 查询参数
     * @return 集合
     */
    @Override
    public List<AppModule> queryAppModuleList(AppModule appModule){
        if (StringUtils.isEmpty(appModule.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        return appModuleMapper.selectAppModuleList(appModule);
    }

    /**
     * 添加应用模块
     * @param appModule 添加参数
     */
    @Override
    public void addAppModule(AppModule appModule){
        if (StringUtils.isEmpty(appModule.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModule.getModuleName())){
            throw new EdenWebException(ResponseEnum.MODULE_NAME_CAN_NOT_BE_EMPTY);
        }
        appModuleMapper.insertAppModule(appModule);
    }

    /**
     * 删除应用模块
     * @param appModule 删除参数
     */
    @Override
    public void deleteAppModule(AppModule appModule){
        if (StringUtils.isEmpty(appModule.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModule.getModuleId())){
            throw new EdenWebException(ResponseEnum.MODULE_ID_CAN_NOT_BE_EMPTY);
        }

        //判断模块下是否有流程
        AppModuleFlow appModuleFlow = new AppModuleFlow();
        appModuleFlow.setModuleId(appModule.getModuleId());
        List<AppModuleFlow> appModuleFlowList = appModuleFlowMapper.selectAppModuleFlowList(appModuleFlow);
        if (!CollectionUtils.isEmpty(appModuleFlowList)){
            throw new EdenWebException(ResponseEnum.MODULE_HAS_FLOW_CAN_NOT_DELETE);
        }

        appModuleMapper.deleteAppModule(appModule);
    }

    /**
     * 更新应用模块
     * @param appModule 更新参数
     */
    @Override
    public void updateAppModule(AppModule appModule){
        if (StringUtils.isEmpty(appModule.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModule.getModuleId())){
            throw new EdenWebException(ResponseEnum.MODULE_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(appModule.getModuleName())){
            throw new EdenWebException(ResponseEnum.MODULE_NAME_CAN_NOT_BE_EMPTY);
        }
        appModuleMapper.updateAppModule(appModule);
    }

}
