package cn.lhcz.common.log.aspect;

import cn.lhcz.common.core.utils.SpringContextHolder;
import cn.lhcz.common.log.annotation.Log;
import cn.lhcz.common.log.event.LogEvent;
import cn.lhcz.system.api.entity.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(log)")
    public Object around(ProceedingJoinPoint point, Log log) throws Throwable {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        logger.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        SysLog logVo = new SysLog();
        logVo.setId(1L);
        SpringContextHolder.publishEvent(new LogEvent(logVo));
        Object obj = point.proceed();
        return obj;
    }
}
