package com.linkknown.eden.controller;

import com.linkknown.eden.bean.AppModule;
import com.linkknown.eden.common.aspect.exception.EdenWebExceptionService;
import com.linkknown.eden.common.aspect.paramslog.EdenWebParamsLog;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.response.BaseResponse;
import com.linkknown.eden.service.IAppModuleService;
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
@RequestMapping("/edenWebApi/appModule")
@Validated
public class AppModuleController {

    @Resource
    private IAppModuleService appModuleService;

    @PostMapping(value = "/queryAppModuleList")
    @EdenWebParamsLog(description = "查询变量集合")
    public BaseResponse<List<AppModule>> queryAppModuleList(AppModule appModule){
        List<AppModule> appModuleList = appModuleService.queryAppModuleList(appModule);
        return BaseResponse.success(appModuleList);
    }

    @PostMapping(value = "/addAppModule")
    @EdenWebParamsLog(description = "添加模块")
    public BaseResponse<Object> addAppModule(AppModule appModule){
        appModuleService.addAppModule(appModule);
        return BaseResponse.success(ResponseEnum.ADD_SUCCESS);
    }

    @PostMapping(value = "/deleteAppModule")
    @EdenWebParamsLog(description = "删除模块")
    public BaseResponse<Object> deleteAppModule(AppModule appModule){
        appModuleService.deleteAppModule(appModule);
        return BaseResponse.success(ResponseEnum.DELETE_SUCCESS);
    }

    @PostMapping(value = "/updateAppModule")
    @EdenWebParamsLog(description = "更新模块")
    public BaseResponse<Object> updateAppModule(AppModule appModule){
        appModuleService.updateAppModule(appModule);
        return BaseResponse.success(ResponseEnum.UPDATE_SUCCESS);
    }

}
