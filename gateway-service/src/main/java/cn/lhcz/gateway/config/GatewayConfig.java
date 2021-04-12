package cn.lhcz.gateway.config;

import cn.lhcz.gateway.filter.LogFilter;
import cn.lhcz.gateway.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public TokenFilter getTokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public LogFilter getLogFilter() {
        return new LogFilter();
    }

}
