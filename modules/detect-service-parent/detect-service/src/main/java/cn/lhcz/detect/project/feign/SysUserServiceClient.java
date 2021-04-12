/*package cn.lhcz.detect.project.feign;

import cn.lhcz.detect.project.feign.fallback.SysUserServiceClientFallback;
import cn.lhcz.system.api.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "system-service", fallback = SysUserServiceClientFallback.class)
public interface SysUserServiceClient {

    @RequestMapping(value = "/sysUser/searchById", method = RequestMethod.GET)
    SysUser searchByName(@RequestParam("id") Long id);
}*/
