package com.wrh.sublet.common.web.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wrh
 * @date 2021/10/14
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = SwaggerProperties.PREFIX, name = "enable", havingValue = "true")
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfig extends WebMvcConfigurationSupport {

    /**
     * 默认的排除路径，排除Spring Boot默认的错误处理路径和端点
     */
    private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

    private static final String BASE_PATH = "/**";


    @Bean
    public Docket createRestApi(SwaggerProperties swaggerProperties) {

        // base-path处理
        if (swaggerProperties.getBasePath().isEmpty())
        {
            swaggerProperties.getBasePath().add(BASE_PATH);
        }
        List<Predicate<String>> basePath = new ArrayList<>();
        swaggerProperties.getBasePath().forEach(path -> basePath.add(PathSelectors.ant(path)));

        // exclude-path处理
        if (swaggerProperties.getExcludePath().isEmpty())
        {
            swaggerProperties.getExcludePath().addAll(DEFAULT_EXCLUDE_PATH);
        }
        List<Predicate<String>> excludePath = new ArrayList<>();
        swaggerProperties.getExcludePath().forEach(path -> excludePath.add(PathSelectors.ant(path)));


        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo(swaggerProperties))
                .globalOperationParameters(globalParamBuilder())
                .select()
                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .build()
                .securitySchemes(security())
//                .securityContexts(Collections.singletonList(securityContext(swaggerProperties)))
                .pathMapping("/");

    }

    /**
     * 静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 获取swagger创建初始化信息
     *
     * @return
     */
    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {

        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(new Contact(swaggerProperties.getContact().getName(),swaggerProperties.getContact().getUrl(),swaggerProperties.getContact().getEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }

    /**
     * 安全认证参数
     *
     * @return
     */
    private List<ApiKey> security() {
        List<ApiKey> list = new ArrayList<>();
        list.add(new ApiKey("Authorization", "Authorization", "header"));
        return list;
    }

    /**
     * 构建全局参数列表
     *
     * @return
     */
    private List<Parameter> globalParamBuilder() {
        List<Parameter> pars = new ArrayList<>();
        pars.add(parameterBuilder("Authorization", "令牌", "string", "header", false).build());
        return pars;
    }

    /**
     * 创建参数
     *
     * @return
     */
    private ParameterBuilder parameterBuilder(String name, String desc, String type, String parameterType, boolean required) {
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(name).description(desc).modelRef(new ModelRef(type)).parameterType(parameterType).required(required).build();
        return tokenPar;
    }


}
