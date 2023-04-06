package com.linkknown.eden.service;


import com.linkknown.eden.bean.AppModule;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public interface IAppModuleService {

    /**
     * 查询应用模块集合
     * @param appModule 查询参数
     * @return 集合
     */
    public List<AppModule> queryAppModuleList(AppModule appModule);

    /**
     * 添加应用模块
     * @param appModule 添加参数
     */
    public void addAppModule(AppModule appModule);

    /**
     * 删除应用模块
     * @param appModule 删除参数
     */
    public void deleteAppModule(AppModule appModule);

    /**
     * 更新应用模块
     * @param appModule 更新参数
     */
    public void updateAppModule(AppModule appModule);
}
