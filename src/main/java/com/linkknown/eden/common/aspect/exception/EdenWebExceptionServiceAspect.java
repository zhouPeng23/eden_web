package com.linkknown.eden.common.aspect.exception;

import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.response.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Aspect
@Order(1)
@Component
public class EdenWebExceptionServiceAspect {

    private Logger logger = LoggerFactory.getLogger(EdenWebExceptionServiceAspect.class);

    @Pointcut("@within(com.linkknown.eden.common.aspect.exception.EdenWebExceptionService)")
    public void edenWebExceptionPointCut() {}

    @Around("edenWebExceptionPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();

        } catch (Exception e) {
            return this.handleException(e);
        }
    }

    /**
     * 处理异常
     * @param e 异常
     * @return object
     */
    private Object handleException(Exception e) {
        if (e instanceof EdenWebException) {
            BaseResponse response = ((EdenWebException) e).getResponse();
            logger.info("==========>eden exception ,code:{}，msg:{}",response.getCode(),response.getMsg());
            logger.error("错误信息:",e);
            return response;
        } else {
            logger.info("==========>eden exception ,code:{}，msg:{}",ResponseEnum.EDEN_WEB_IS_BUSY.getCode(),ResponseEnum.EDEN_WEB_IS_BUSY.getMsg());
            logger.error("错误信息:",e);
            return BaseResponse.fail(ResponseEnum.EDEN_WEB_IS_BUSY);
        }
    }
}
