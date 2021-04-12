package cn.lhcz.common.log.event;

import cn.lhcz.system.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * 日志事件
 */
public class LogEvent extends ApplicationEvent {
    public LogEvent(SysLog source) {
        super(source);
    }
}
