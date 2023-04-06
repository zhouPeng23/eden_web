package com.linkknown.eden.common.aspect.exception;

import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.common.response.BaseResponse;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public class EdenWebException extends RuntimeException {

    private BaseResponse response;

    /**
     * 返回错误枚举
     */
    public EdenWebException(ResponseEnum responseEnum) {
        //直接返回定义过的错误信息枚举
        this.response = BaseResponse.fail(responseEnum);
    }


    public BaseResponse getResponse() {
        return response;
    }

    public void setResponse(BaseResponse response) {
        this.response = response;
    }
}
