package com.linkknown.eden.service.impl;

import com.linkknown.eden.mapper.AppModuleFlowStepMapper;
import com.linkknown.eden.service.IAppModuleFlowStepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Service
public class AppModuleFlowStepServiceImpl implements IAppModuleFlowStepService {

    @Resource
    private AppModuleFlowStepMapper appModuleFlowStepMapper;


}
