package com.linkknown.eden.controller;

import com.linkknown.eden.bean.DataSource;
import com.linkknown.eden.common.aspect.exception.EdenWebExceptionService;
import com.linkknown.eden.common.aspect.paramslog.EdenWebParamsLog;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.response.BaseResponse;
import com.linkknown.eden.service.IDataSourceService;
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
@RequestMapping("/edenWebApi/dataSource")
@Validated
public class DataSourceController {

    @Resource
    private IDataSourceService dataSourceService;

    @PostMapping(value = "/queryDataSourceList")
    @EdenWebParamsLog(description = "查询数据源集合")
    public BaseResponse<List<DataSource>> queryDataSourceList(DataSource dataSource){
        List<DataSource> dataSourceList = dataSourceService.queryDataSourceList(dataSource);
        return BaseResponse.success(dataSourceList);
    }

    @PostMapping(value = "/addDataSource")
    @EdenWebParamsLog(description = "添加数据源")
    public BaseResponse<Object> addDataSource(DataSource dataSource){
        dataSourceService.addDataSource(dataSource);
        return BaseResponse.success(ResponseEnum.ADD_SUCCESS);
    }

    @PostMapping(value = "/deleteDataSource")
    @EdenWebParamsLog(description = "删除数据源")
    public BaseResponse<Object> deleteDataSource(DataSource dataSource){
        dataSourceService.deleteDataSource(dataSource);
        return BaseResponse.success(ResponseEnum.DELETE_SUCCESS);
    }

    @PostMapping(value = "/updateDataSource")
    @EdenWebParamsLog(description = "更新数据源")
    public BaseResponse<Object> updateDataSource(DataSource dataSource){
        dataSourceService.updateDataSource(dataSource);
        return BaseResponse.success(ResponseEnum.UPDATE_SUCCESS);
    }

}
