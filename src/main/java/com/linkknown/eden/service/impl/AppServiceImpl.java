package com.linkknown.eden.service.impl;

import com.linkknown.eden.bean.App;
import com.linkknown.eden.bean.AppModule;
import com.linkknown.eden.bean.DataSource;
import com.linkknown.eden.bean.DefineVariable;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.aspect.exception.EdenWebException;
import com.linkknown.eden.common.enums.SelectedAppEnum;
import com.linkknown.eden.mapper.AppMapper;
import com.linkknown.eden.mapper.AppModuleMapper;
import com.linkknown.eden.mapper.DataSourceMapper;
import com.linkknown.eden.mapper.DefineVariableMapper;
import com.linkknown.eden.service.IAppService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Service
public class AppServiceImpl implements IAppService {

    @Resource
    private AppMapper appMapper;

    @Resource
    private AppModuleMapper appModuleMapper;

    @Resource
    private DefineVariableMapper defineVariableMapper;

    @Resource
    private DataSourceMapper dataSourceMapper;

    /**
     * 查询所有应用集合
     * @param app 添加参数
     * @return 集合
     */
    @Override
    public List<App> queryAppList(App app){
        return appMapper.selectAppList(app);
    }

    /**
     * 添加应用
     * @param app 添加参数
     */
    @Override
    public void addApp(App app){
        if (StringUtils.isEmpty(app.getAppName())){
            throw new EdenWebException(ResponseEnum.APP_NAME_CAN_NOT_BE_EMPTY);
        }
        appMapper.insertApp(app);
    }

    /**
     * 删除应用
     * @param app 删除参数
     */
    @Override
    public void deleteApp(App app){
        if (StringUtils.isEmpty(app.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }

        //判断应用是否正在被选择
        App cunrrentApp = appMapper.selectAppById(app.getAppId());
        if (cunrrentApp.getSelectedApp().equals(1)){
            throw new EdenWebException(ResponseEnum.APP_IS_SELECTED_CAN_NOT_DELETE);
        }

        //判断应用下是否有模块
        AppModule appModule = new AppModule();
        appModule.setAppId(app.getAppId());
        List<AppModule> appModuleList = appModuleMapper.selectAppModuleList(appModule);
        if (!CollectionUtils.isEmpty(appModuleList)){
            throw new EdenWebException(ResponseEnum.APP_HAS_MODULES_CAN_NOT_DELETE);
        }

        //判断应用下是否有定义的变量
        DefineVariable defineVariable = new DefineVariable();
        defineVariable.setAppId(app.getAppId());
        List<DefineVariable> defineVariableList = defineVariableMapper.selectDefineVariableList(defineVariable);
        if (!CollectionUtils.isEmpty(defineVariableList)){
            throw new EdenWebException(ResponseEnum.APP_HAS_DEFINEVARIABLE_CAN_NOT_DELETE);
        }

        //判断应用下是否有数据源
        DataSource dataSource = new DataSource();
        dataSource.setAppId(app.getAppId());
        List<DataSource> dataSourceList = dataSourceMapper.selectDataSourceList(dataSource);
        if (!CollectionUtils.isEmpty(dataSourceList)){
            throw new EdenWebException(ResponseEnum.APP_HAS_DATASOURCE_CAN_NOT_DELETE);
        }

        appMapper.deleteAppById(app.getAppId());
    }

    /**
     * 更新应用
     * @param app 更新参数
     */
    @Override
    public void updateApp(App app){
        if (StringUtils.isEmpty(app.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(app.getAppName())){
            throw new EdenWebException(ResponseEnum.APP_NAME_CAN_NOT_BE_EMPTY);
        }
        appMapper.updateApp(app);
    }

    /**
     * 查询已选择的app
     * @return 已选择的app
     */
    @Override
    public App querySelectedApp(){
        App selectedApp = null;
        List<App> appList = appMapper.selectAppList(null).stream()
                .filter(app -> app.getSelectedApp().equals(SelectedAppEnum.YES.getCode()))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(appList)){
            if (appList.size()==1){
                selectedApp = appList.get(0);
            }else{
                throw new EdenWebException(ResponseEnum.SELECTED_APP_NUMBER_IN_DB_ERROR);
            }
        }
        //返回已选择的app，如果没有选择的返回null
        return selectedApp;
    }

    /**
     * 选择此应用
     * @param app 选择参数
     * @return 选择的app
     */
    @Override
    public App selectThisApp(App app){
        if (StringUtils.isEmpty(app.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        //查询现有的已选择的应用 设置为未选择
        App selectedApp = this.querySelectedApp();
        if (selectedApp!=null){
            //设置为未选择状态
            App toNotChooseApp = new App();
            toNotChooseApp.setAppId(selectedApp.getAppId());
            toNotChooseApp.setSelectedApp(SelectedAppEnum.NO.getCode());
            appMapper.updateApp(toNotChooseApp);
        }

        //将选中的app设置为已选择
        App toChooseApp = new App();
        toChooseApp.setAppId(app.getAppId());
        toChooseApp.setSelectedApp(SelectedAppEnum.YES.getCode());
        appMapper.updateApp(toChooseApp);

        //返回库里已选择的app
        return this.querySelectedApp();
    }

}
