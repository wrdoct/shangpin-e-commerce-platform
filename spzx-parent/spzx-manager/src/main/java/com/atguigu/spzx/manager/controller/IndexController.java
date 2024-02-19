package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.manager.service.SysUserService;
import com.atguigu.spzx.manager.service.ValidateCodeService;
import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.system.LoginVo;
import com.atguigu.spzx.model.vo.system.SysMenuVo;
import com.atguigu.spzx.model.vo.system.ValidateCodeVo;
import com.atguigu.spzx.utils.AuthContextUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private SysMenuService sysMenuService;

    // 用户退出
    @Operation(summary = "用户退出")
    @GetMapping(value = "/logout")
    public Result logout(@RequestHeader(value = "token") String token) {
        sysUserService.logout(token) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    // 获取当前登录用户信息
//    @Operation(summary = "获取当前登录用户信息")
//    @GetMapping(value = "/getUserInfo")
////    public Result getUserInfo(HttpServletRequest request) {
////        String token = request.getHeader("token");
//    public Result getUserInfo(@RequestHeader(name = "token") String token) {
//        SysUser sysUser = sysUserService.getUserInfo(token);
//        return Result.build(sysUser, ResultCodeEnum.SUCCESS);
//    }
    @Operation(summary = "获取当前登录用户信息")
    @GetMapping(value = "/getUserInfo")
    public Result getUserInfo() {
        return Result.build(AuthContextUtil.get(), ResultCodeEnum.SUCCESS);
    }

    // 生成图片验证码
    @Operation(summary = "生成图片验证码")
    @GetMapping(value = "/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo , ResultCodeEnum.SUCCESS) ;
    }

    // 用户登录
    @Operation(summary = "登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto){
        LoginVo loginvo = sysUserService.login(loginDto);
        return Result.build(loginvo, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "查询用户系统菜单列表")
    @GetMapping("/menus")
    public Result menus() {
        List<SysMenuVo> sysMenuVoList =  sysMenuService.findUserMenuList() ;
        return Result.build(sysMenuVoList , ResultCodeEnum.SUCCESS) ;
    }

}
