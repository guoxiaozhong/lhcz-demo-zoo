package cn.lhcz.system.project.service.impl;

import cn.lhcz.system.api.entity.SysUser;
import cn.lhcz.system.project.mapper.SysUserMapper;
import cn.lhcz.system.project.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
