package com.linkknown.eden.service;


import com.linkknown.eden.bean.AppModuleFlow;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public interface IAppModuleFlowService {

    /**
     * 查询应用模块流程集合
     * @param appModuleFlow 查询参数
     * @return 集合
     */
    public List<AppModuleFlow> queryAppModuleFlowList(AppModuleFlow appModuleFlow);

    /**
     * 添加应用模块流程
     * @param appModuleFlow 添加参数
     */
    public void addAppModuleFlow(AppModuleFlow appModuleFlow);

    /**
     * 删除模块流程
     * @param appModuleFlow 删除参数
     */
    public void deleteAppModuleFlow(AppModuleFlow appModuleFlow);

    /**
     * 更新模块流程
     * @param appModuleFlow 更新参数
     */
    public void updateAppModuleFlow(AppModuleFlow appModuleFlow);
}
