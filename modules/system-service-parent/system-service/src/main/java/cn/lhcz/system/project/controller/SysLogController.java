package cn.lhcz.system.project.controller;

import cn.lhcz.system.api.entity.SysLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysLog")
public class SysLogController {

    @PostMapping("/saveLog")
    public void saveLog(@RequestBody SysLog sysLog) {
        System.out.println(1);
    }
}
