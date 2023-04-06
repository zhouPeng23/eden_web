package com.linkknown.eden.controller;

import com.linkknown.eden.bean.AppModuleFlow;
import com.linkknown.eden.common.aspect.exception.EdenWebExceptionService;
import com.linkknown.eden.common.aspect.paramslog.EdenWebParamsLog;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.response.BaseResponse;
import com.linkknown.eden.service.IAppModuleFlowService;
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
@RequestMapping("/edenWebApi/appModuleFlow")
@Validated
public class AppModuleFlowController {

    @Resource
    private IAppModuleFlowService appModuleFlowService;

    @PostMapping(value = "/queryAppModuleFlowList")
    @EdenWebParamsLog(description = "查询应用模块流程集合")
    public BaseResponse<List<AppModuleFlow>> queryAppModuleFlowList(AppModuleFlow appModuleFlow){
        List<AppModuleFlow> appModuleFlowList = appModuleFlowService.queryAppModuleFlowList(appModuleFlow);
        return BaseResponse.success(appModuleFlowList);
    }

    @PostMapping(value = "/addAppModuleFlow")
    @EdenWebParamsLog(description = "添加应用模块流程")
    public BaseResponse<Object> addAppModuleFlow(AppModuleFlow appModuleFlow){
        appModuleFlowService.addAppModuleFlow(appModuleFlow);
        return BaseResponse.success(ResponseEnum.ADD_SUCCESS);
    }

    @PostMapping(value = "/deleteAppModuleFlow")
    @EdenWebParamsLog(description = "删除应用模块流程")
    public BaseResponse<Object> deleteAppModuleFlow(AppModuleFlow appModuleFlow){
        appModuleFlowService.deleteAppModuleFlow(appModuleFlow);
        return BaseResponse.success(ResponseEnum.DELETE_SUCCESS);
    }

    @PostMapping(value = "/updateAppModuleFlow")
    @EdenWebParamsLog(description = "更新应用模块流程")
    public BaseResponse<Object> updateAppModuleFlow(AppModuleFlow appModuleFlow){
        appModuleFlowService.updateAppModuleFlow(appModuleFlow);
        return BaseResponse.success(ResponseEnum.UPDATE_SUCCESS);
    }

}
