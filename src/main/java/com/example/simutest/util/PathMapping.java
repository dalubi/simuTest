package com.example.simutest.util;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class PathMapping implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //String[] resourceLocation = new String[]{"file:D:\\WangJianIDEA_Test\\activiti-imooc\\src\\main\\resources\\resources\\bpmn\\","classpath:/resources/"};
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/");//默认也有这个路径映射
        //注意要加上file，访问这个路径，回去后面那个路径下去找
        registry.addResourceHandler("/bpmn/**").addResourceLocations("file:/Users/america/Java_study/activiti7_webflow/src/main/resources/resources/bpmn/");
    }
}
