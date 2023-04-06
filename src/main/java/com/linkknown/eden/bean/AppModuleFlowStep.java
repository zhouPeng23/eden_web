package com.linkknown.eden.bean;

import lombok.Data;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:27
 */
@Data
public class AppModuleFlowStep {

    private Integer appId;

    private Integer moduleId;

    private Integer flowId;

    private Integer stepId;

    private Integer stepPreId;

    private String stepName;

    private String stepContent;

}
