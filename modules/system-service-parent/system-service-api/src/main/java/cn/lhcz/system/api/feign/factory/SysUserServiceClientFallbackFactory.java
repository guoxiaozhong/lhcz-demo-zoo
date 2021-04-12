package cn.lhcz.system.api.feign.factory;

import cn.lhcz.system.api.feign.SysUserServiceClient;
import cn.lhcz.system.api.feign.fallback.SysUserServiceClientFallback;
import feign.hystrix.FallbackFactory;

public class SysUserServiceClientFallbackFactory implements FallbackFactory<SysUserServiceClient> {

    @Override
    public SysUserServiceClient create(Throwable throwable) {
        SysUserServiceClientFallback fallback = new SysUserServiceClientFallback();
        fallback.setThrowable(throwable);
        return fallback;
    }
}
