package com.koikeya.project1.app.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * ServerServlet定数取得クラス
 *
 * @author user
 *
 */
@Data
@ConfigurationProperties(prefix = "server.servlet")
@Component
public class ServerServlet {

    private String contextPath;

    private Map<String, String> session;
}
