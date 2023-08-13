package org.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    Config(String nameA, String address) {
        System.out.println("Config constructor");
        System.out.println("name: " + name + "addr: " + addr);
        this.name = "name";
        this.addr = "addr";
    }

    Config(String nameA) {
        System.out.println("Config constructor with one param");
        System.out.println("name: " + name + "addr: " + addr);
        this.name = "param_name";
        this.addr = "param_addr";
    }

    Config() {}

    @Value("aaa")
    private String name;

    @Value("bbb")
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Config: \n" + "name: " + name + "\n" + "addr: " + addr + "\n";
    }
}
