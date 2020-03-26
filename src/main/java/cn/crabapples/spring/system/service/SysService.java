package cn.crabapples.spring.system.service;

import cn.crabapples.spring.system.dto.ResponseDTO;
import cn.crabapples.spring.system.entity.SysMenu;
import cn.crabapples.spring.system.entity.SysUser;
import cn.crabapples.spring.system.form.UserForm;

import java.util.List;
import java.util.Set;

/**
 * TODO 系统相关服务
 *
 * @author Mr.He
 * 2020/1/28 23:22
 * e-mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name 29404
 */
public interface SysService {
    /**
     * 用户登录
     * @return 登录成功后返回的登录信息
     */
    ResponseDTO login(UserForm form);

    /**
     * 获取系统菜单
     * @return
     */
    List<SysMenu> getSysMenus(SysUser user);
}
