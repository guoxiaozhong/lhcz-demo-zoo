package cn.lhcz.system.api.feign.fallback;

import cn.lhcz.system.api.entity.SysLog;
import cn.lhcz.system.api.entity.SysUser;
import cn.lhcz.system.api.feign.SysUserServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SysUserServiceClientFallback implements SysUserServiceClient {

    private Throwable throwable;

    @Override
    public SysUser searchByName(Long id) {
        log.error("feign searchByName failed: {}", id);
        return new SysUser();
    }

    @Override
    public void saveLog(SysLog sysLog) {
        log.error("feign save log failed");
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
