package com.koikeya.project1.app.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * AppMyProperty定数取得クラス
 *
 * @author user
 *
 */
@Data
@ConfigurationProperties(prefix = "app.config")
public class AppMyProperty {

    /**
     * IPv4 Address
     */
    private String ipAddress;

    /**
     * port
     */
    private String port;
}
