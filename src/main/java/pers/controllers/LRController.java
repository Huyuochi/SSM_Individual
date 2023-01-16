package pers.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import pers.entity.User;
import pers.result.Result;
import pers.service.UserService;

import javax.annotation.Resource;

//Login and Register controller
@RestController
public class LRController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Result Register(@RequestBody User user) {
        try {
            int flag = userService.Register(user);
            return Result.success(flag);
        }catch(Exception e) {
            e.printStackTrace();
            return Result.fail();
        }
    }

    @GetMapping("/login")
    public Result Login(@RequestParam String account, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        try {
            subject.login(token);
            return Result.success("ooo");
        }catch(Exception e) {
            e.printStackTrace();
            return Result.fail();
        }
    }
}
