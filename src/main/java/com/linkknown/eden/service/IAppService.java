package com.linkknown.eden.service;

import com.linkknown.eden.bean.App;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public interface IAppService {

    /**
     * 查询所有应用集合
     * @return 集合
     */
    public List<App> queryAppList(App app);

    /**
     * 添加应用
     * @param app 添加参数
     */
    public void addApp(App app);

    /**
     * 删除应用
     * @param app 删除参数
     */
    public void deleteApp(App app);

    /**
     * 更新应用
     * @param app 更新参数
     */
    public void updateApp(App app);

    /**
     * 查询已选择的app
     * @return 已选择的app
     */
    public App querySelectedApp();

    /**
     * 选择此应用
     * @param app 选择参数
     * @return 选择的app
     */
    public App selectThisApp(App app);
}
