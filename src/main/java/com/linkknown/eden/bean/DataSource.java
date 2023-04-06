package com.linkknown.eden.bean;

import lombok.Data;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:29
 */
@Data
public class DataSource {

    private Integer appId;

    private Integer id;

    private String dataSourceName;

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
