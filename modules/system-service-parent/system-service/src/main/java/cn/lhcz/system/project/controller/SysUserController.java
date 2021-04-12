package cn.lhcz.system.project.controller;

import cn.lhcz.system.api.entity.SysUser;
import cn.lhcz.system.project.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/searchById")
    public SysUser searchByName(@RequestParam("id") Long id) {
        SysUser user = new SysUser();
        user.setId(1L);
        user.setUserName("guoxiaozhong");
        return user;
    }
}
