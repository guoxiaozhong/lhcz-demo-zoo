package cn.lhcz.system.api.feign;

import cn.lhcz.common.feign.config.CustomFeignConfig;
import cn.lhcz.system.api.entity.SysLog;
import cn.lhcz.system.api.entity.SysUser;
import cn.lhcz.system.api.feign.factory.SysUserServiceClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "system-service", configuration = CustomFeignConfig.class, fallback = SysUserServiceClientFallbackFactory.class)
public interface SysUserServiceClient {

    @GetMapping(value = "/sysUser/searchById")
    SysUser searchByName(@RequestParam("id") Long id);

    @PostMapping("/sysLog/saveLog")
    void saveLog(@RequestBody SysLog sysLog);
}
