package cn.lhcz.detect.project.controller;

import cn.lhcz.common.log.annotation.Log;
import cn.lhcz.system.api.entity.SysUser;
import cn.lhcz.system.api.feign.SysUserServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private SysUserServiceClient sysUserServiceClient;

    @Log(value = "test")
    @GetMapping("/test")
    public SysUser getUser() {
        return sysUserServiceClient.searchByName(1L);
    }
}
