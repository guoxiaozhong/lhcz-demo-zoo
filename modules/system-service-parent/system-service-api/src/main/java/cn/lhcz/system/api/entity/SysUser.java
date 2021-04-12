package cn.lhcz.system.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value = "sys_user")
@Data
@NoArgsConstructor
public class SysUser {

    private Long id;

    private String userName;

    private String account;

    private String password;

}
