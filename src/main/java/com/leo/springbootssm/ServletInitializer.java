package com.leo.springbootssm;

import javafx.application.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Description:
 * Created by Liuq on 2019-11-18.
 */
public class ServletInitializer extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(SpringbootssmApplication.class);
    }
}
