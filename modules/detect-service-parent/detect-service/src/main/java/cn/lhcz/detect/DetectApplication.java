package cn.lhcz.detect;

import cn.lhcz.common.core.constant.CommonConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {CommonConstant.BASE_PACKAGE})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {CommonConstant.BASE_PACKAGE})
public class DetectApplication {
    public static void main(String[] args) {
        SpringApplication.run(DetectApplication.class, args);
    }
}
