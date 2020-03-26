package cn.crabapples.spring.system.controller;

import cn.crabapples.spring.system.common.BaseController;
import cn.crabapples.spring.system.common.groups.IsLogin;
import cn.crabapples.spring.system.dto.ResponseDTO;
import cn.crabapples.spring.system.entity.SysMenu;
import cn.crabapples.spring.system.entity.SysUser;
import cn.crabapples.spring.system.form.UserForm;
import cn.crabapples.spring.system.service.SysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO 系统相关接口
 *
 * @author Mr.He
 * 2020/1/28 23:17
 * e-mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name 29404
 */

@Controller
@Api("系统管理")
public class SysController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private cn.crabapples.spring.system.service.SysService sysService;

    public SysController(SysService sysService) {
        this.sysService = sysService;
    }

    /**
     * 进入登录页面
     * @return 返回登录页面html
     */
    @GetMapping("/")
    public String toIndex(){
        logger.info("收到请求->进入主页");
        return "login";
    }

    /**
     * 发起登录请求
     * @param form 用户名和密码
     * @return 登录成功返回token
     */
    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "用户登陆", notes = "用户登陆接口")
    public cn.crabapples.spring.system.dto.ResponseDTO login(@RequestBody UserForm form){
        logger.info("收到请求->用户登陆验证:[{}]",form);
        super.validator(form, IsLogin.class);
        cn.crabapples.spring.system.dto.ResponseDTO responseDTO = sysService.login(form);
        logger.info("登录验证结束->用户信息:[{}]",responseDTO);
        return responseDTO;
    }

    /**
     * 进入主页面
     * @return 登录后的主页面
     */
    @GetMapping("/index")
    @RequiresPermissions("abc:wewe")
    public String index(){
        logger.info("收到请求->进入主页");
        return "index";
    }

    /**
     * 获取系统菜单
     * @return 返回当前用户拥有的系统菜单
     */
    @GetMapping("/getSysMenus")
    @ResponseBody
    public cn.crabapples.spring.system.dto.ResponseDTO getSysMenus(){
        cn.crabapples.spring.system.entity.SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        logger.info("收到请求->获取用户[{}]的菜单列表",user.getId());
        List<SysMenu> menus = sysService.getSysMenus(user);
        logger.info("获取菜单列表成功:[{}]",menus);
        return ResponseDTO.returnSuccess("操作成功",menus);
    }

}
