package com.example.demo.controller;

import com.example.demo.VO.UserVO;
import com.example.demo.VO.request.UserRequestVO;
import com.example.demo.aspect.RequireAuth;
import com.example.demo.common.Const;
import com.example.demo.common.response.ServerResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(@RequestBody UserVO userVO, HttpSession session) {
        if (!userVO.checkArguments())
            return ServerResponse.createByErrorMessage("wrong arguments");
        ServerResponse<User> response = userService.login(userVO.getName(), userVO.getPassword());
        if (response.isSuccess()) {
            session.setAttribute(Const.CUR_USER, response.getData());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "userInfo", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> userInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        if (user == null)
            return ServerResponse.createByError();
        return ServerResponse.createBySuccess(user);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(@RequestBody UserRequestVO userRequestVO) {
        if (!userRequestVO.checkArguments()) {
            return ServerResponse.createByErrorMessage("wrong arguments");
        }
        ServerResponse<String> response;
        try {
            userService.register(userRequestVO.getName(), userRequestVO.getTelephone(), userRequestVO.getEmail(), userRequestVO.getUserTypeEnum(),
                    userRequestVO.getPassword());

            response = ServerResponse.createBySuccess("Success");
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "password", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changePasswd(@RequestParam("oldPassword") String oldPassword,
                                       @RequestParam("newPassword") String newPassword, HttpSession session) {
        if (oldPassword == null || newPassword == null) {
            return ServerResponse.createByErrorMessage("wrong arguments");
        }
        User user = (User) session.getAttribute(Const.CUR_USER);
        if (user == null)
            return ServerResponse.createByErrorMessage("未登录");
        return userService.changePassword(oldPassword, newPassword, user);
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> logout(HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER);
        if (user == null)
            return ServerResponse.createByErrorMessage("未登录");
        session.setAttribute(Const.CUR_USER, null);
        return ServerResponse.createBySuccess();
    }
}
