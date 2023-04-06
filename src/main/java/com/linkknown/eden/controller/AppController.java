package com.linkknown.eden.controller;

import com.linkknown.eden.bean.App;
import com.linkknown.eden.common.aspect.paramslog.EdenWebParamsLog;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.aspect.exception.EdenWebExceptionService;
import com.linkknown.eden.common.response.BaseResponse;
import com.linkknown.eden.service.IAppService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:42
 */
@EdenWebExceptionService
@RestController
@RequestMapping("/edenWebApi/app")
@Validated
public class AppController {

    @Resource
    private IAppService appService;

    @PostMapping(value = "/queryAppList")
    @EdenWebParamsLog(description = "查询应用集合")
    public BaseResponse<List<App>> queryAppList(App app){
        List<App> appList = appService.queryAppList(app);
        return BaseResponse.success(appList);
    }

    @PostMapping(value = "/addApp")
    @EdenWebParamsLog(description = "添加应用")
    public BaseResponse<Object> addApp(App app){
        appService.addApp(app);
        return BaseResponse.success(ResponseEnum.ADD_SUCCESS);
    }

    @PostMapping(value = "/deleteApp")
    @EdenWebParamsLog(description = "删除应用")
    public BaseResponse<Object> deleteApp(App app){
        appService.deleteApp(app);
        return BaseResponse.success(ResponseEnum.DELETE_SUCCESS);
    }

    @PostMapping(value = "/updateApp")
    @EdenWebParamsLog(description = "更新应用")
    public BaseResponse<Object> updateApp(App app){
        appService.updateApp(app);
        return BaseResponse.success(ResponseEnum.UPDATE_SUCCESS);
    }

    @PostMapping(value = "/querySelectedApp")
    @EdenWebParamsLog(description = "查询数据库中已选择的应用")
    public BaseResponse<Object> querySelectedApp(){
        App selectedApp = appService.querySelectedApp();
        return BaseResponse.success(ResponseEnum.EDEN_WEB_SUCCESS,selectedApp);
    }

    @PostMapping(value = "/selectThisApp")
    @EdenWebParamsLog(description = "选择此应用")
    public BaseResponse<Object> selectThisApp(App app){
        App selectedApp = appService.selectThisApp(app);
        return BaseResponse.success(ResponseEnum.SELECTED_SUCCESS,selectedApp);
    }

}
