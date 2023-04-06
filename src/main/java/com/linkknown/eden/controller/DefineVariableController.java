package com.linkknown.eden.controller;

import com.linkknown.eden.bean.DefineVariable;
import com.linkknown.eden.common.aspect.exception.EdenWebExceptionService;
import com.linkknown.eden.common.aspect.paramslog.EdenWebParamsLog;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.response.BaseResponse;
import com.linkknown.eden.service.IDefineVariableService;
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
@RequestMapping("/edenWebApi/defineVariable")
@Validated
public class DefineVariableController {

    @Resource
    private IDefineVariableService defineVariableService;

    @PostMapping(value = "/queryVariableList")
    @EdenWebParamsLog(description = "查询变量集合")
    public BaseResponse<List<DefineVariable>> queryVariableList(DefineVariable defineVariable){
        List<DefineVariable> defineVariableList = defineVariableService.queryVariableList(defineVariable);
        return BaseResponse.success(defineVariableList);
    }

    @PostMapping(value = "/addVariable")
    @EdenWebParamsLog(description = "添加变量")
    public BaseResponse<Object> addVariable(DefineVariable defineVariable){
        defineVariableService.addVariable(defineVariable);
        return BaseResponse.success(ResponseEnum.ADD_SUCCESS);
    }

    @PostMapping(value = "/deleteVariable")
    @EdenWebParamsLog(description = "删除变量")
    public BaseResponse<Object> deleteVariable(DefineVariable defineVariable){
        defineVariableService.deleteVariable(defineVariable);
        return BaseResponse.success(ResponseEnum.DELETE_SUCCESS);
    }

    @PostMapping(value = "/updateVariable")
    @EdenWebParamsLog(description = "更新变量")
    public BaseResponse<Object> updateVariable(DefineVariable defineVariable){
        defineVariableService.updateVariable(defineVariable);
        return BaseResponse.success(ResponseEnum.UPDATE_SUCCESS);
    }

}
