package com.example.wechat.controller;

import com.example.wechat.entity.Users;
import com.example.wechat.exceptions.BaseException;
import com.example.wechat.response.CommonEnum;
import com.example.wechat.response.ResultBody;
import com.example.wechat.response.ResultUtil;
import com.example.wechat.service.userService.UserService;
import com.example.wechat.utils.StringUtil;
import com.example.wechat.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Tzj
 * @Date 2021/3/5 22:18
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerOrLogin")
    public ResultBody registerOrLogin(@RequestBody Users user) {
        UsersVO usersVO=userService.registerOrLogin(user);
        return ResultUtil.success(usersVO);
    }
}
