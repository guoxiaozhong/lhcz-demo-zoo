package cn.lhcz.detect.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/getInfo")
    public String getInfo() {
        return "config\tinfo:\t" + configInfo;
    }
}
