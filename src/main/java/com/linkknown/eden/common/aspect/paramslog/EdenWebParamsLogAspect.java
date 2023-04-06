package com.linkknown.eden.common.aspect.paramslog;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author zhoupeng
 */
@Aspect
@Order(2)
@Component
public class EdenWebParamsLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Pointcut("@annotation(com.linkknown.eden.common.aspect.paramslog.EdenWebParamsLog)")
    public void edenWebParamsLogPointCut(){}

    @Around("edenWebParamsLogPointCut()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        //执行切点，执行切点后，会去依次调用 @Before -> 接口逻辑代码 -> @After -> @AfterReturning；
        Object res = joinPoint.proceed();
        //打印出参
        logger.info("Response params:{}", JSON.toJSONString(res));
        //执行耗时
        logger.info("Time-consuming:{}", System.currentTimeMillis()-startTime);
        return res;
    }


    /**
     * 在切点之前织入
     * @param joinPoint 切点
     */
    @Before("edenWebParamsLogPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取 @EdenWebParamsLog3 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);
        // 打印请求相关参数
        logger.info("==================== Start ====================");
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印描述信息
        logger.info("Description    : {}", methodDescription);
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request params : {}", JSON.toJSONString(joinPoint.getArgs()));
    }


    /**
     * 在切点之后织入
     */
    @After("edenWebParamsLogPointCut()")
    public void doAfter() throws Throwable {
        // 接口结束后换行，方便分割查看
        logger.info("==================== End ====================" + LINE_SEPARATOR);
    }


    /**
     * 获取切面注解的描述
     * @param joinPoint 切点
     * @return 描述信息
     */
    private String getAspectLogDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(EdenWebParamsLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }



}
