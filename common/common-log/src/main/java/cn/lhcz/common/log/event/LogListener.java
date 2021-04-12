package cn.lhcz.common.log.event;

import cn.lhcz.system.api.entity.SysLog;
import cn.lhcz.system.api.feign.SysUserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * 异步监听日志事件
 */
public class LogListener {

    @Autowired
    private SysUserServiceClient userServiceClient;

    public LogListener(SysUserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    /**
     * 异步记录日志
     *
     * @param event event
     */
    @Async
    @Order
    @EventListener(LogEvent.class)
    public void saveSysLog(LogEvent event) {
        SysLog log = (SysLog) event.getSource();
        userServiceClient.saveLog(log);
    }

}
