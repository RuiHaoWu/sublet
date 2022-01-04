package com.wrh.sublet.common.web.swagger;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wrh
 * @date 2021/10/14
 */
@Getter
@Setter
@ConfigurationProperties(prefix = SwaggerProperties.PREFIX )
public class SwaggerProperties {

    public static final String PREFIX = "sublet.swagger";

    /**
     * 是否开启swagger
     */
    private Boolean enabled = false;

    /**
     * swagger会解析的包路径
     **/
    private String basePackage = "com.wrh.sublet";

    /**
     * swagger会解析的url规则
     **/
    private List<String> basePath = new ArrayList<>();

    /**
     * 在basePath基础上需要排除的url规则
     **/
    private List<String> excludePath = new ArrayList<>();

    /**
     * 需要排除的服务
     */
    private List<String> ignoreProviders = new ArrayList<>();

    /**
     * 标题
     **/
    private String title = "swagger 接口文档";

    /**
     * 描述
     **/
    private String description = "";

    /**
     * 版本
     **/
    private String version = "1.0";

    /**
     * host信息
     **/
    private String host = "";

    /**
     * 联系人信息
     */
    private Contact contact = new Contact();


    @Data
    @NoArgsConstructor
    public static class Contact {

        /**
         * 联系人
         **/
        private String name = "wrh";

        /**
         * 联系人url
         **/
        private String url = "";

        /**
         * 联系人email
         **/
        private String email = "";

    }
}
