package org.example.Service;

import org.example.configuration.Config;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class TestService implements InitializingBean {
    Config config;

    public TestService(Config config) {
        this.config = config;
    }

    @PostConstruct
    public void init() {
        System.out.println("init test service");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Before delete test service");
    }

    public void test() {
        System.out.println(config.getAddr());
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("after properties set");
    }
}
