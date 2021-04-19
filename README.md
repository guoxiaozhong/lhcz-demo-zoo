## 一个统一的后台服务模板
以后开发可以只关注于业务代码开发，不需要重复框架的搭建。
> [spring cloud系列](https://www.jianshu.com/p/f083660c65bf)

## 技术选型
- nacos         注册中心 + 配置中心
- gateway       网关
- feign         服务间调用
- sentinel      服务熔断及限流
- seata         分布式事务
- 认证鉴权       spring security + jwt
- 数据库         mysql5.7
- 缓存           redis
- 文件系统       minio
- 链路追踪       zipkin
- 消息队列       RabbitMQ / kafka
- 部署           Docker + k8s
- // todo

##  整体架构

lhcz-demo-zoo
    -- common   通用模块
        -- common-basic     公共依赖
        -- common-feign     feign配置模块,实现调用携带header      
        -- common-core      核心依赖块
        -- common-log       日志
        -- common-oss       文件存储服务
    -- config-service   
    -- gateway-service      统一网关
    -- modules              业务模块
        -- auth-service     单点登录模块
        -- detect-service   业务模块1
        -- system-service   业务模块2
    -- monitor-service      admin监测模块
        
        
## 项目过程
1. 完成注册中心及open-feign调用
2. 完成统一日志功能
3. 完成minio文件服务
4. 完成配置中心
5. 完成spring-admin
6. gateway gateway + nacos配置中心实现动态gateway, 且实现简单的token验证，有其他需要可自行扩充
7. 完成admin监测模块
8. 完成集成sentinel, 及nacos + sentinel

## todo
1. spring-security + oauth2 + jwt 实现登录验证, refresh token, revoke token等
2. 完善gateway


## others
1. 配置dashboard(services)
在.idea中的workspace.xml文件中添加以下内容, 快捷键 `alt+8` 打开即可.
```
<component name="RunDashboard"> 
	<option name="configurationTypes">
	 	<set> 
	 		<option value="SpringBootApplicationConfigurationType" />
	 	</set> 
 	</option> 
 	<option name="ruleStates"> 
 		<list> 
 			<RuleState> 
 				<option name="name" value="ConfigurationTypeDashboardGroupingRule" /> 
 			</RuleState> 
 			<RuleState> 
 				<option name="name" value="StatusDashboardGroupingRule" /> 
 			</RuleState> 
 		</list>
 	</option> 
</component>
```


