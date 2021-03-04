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
        if (userVO.getEmail() == null || userVO.getPassword() == null)
            return ServerResponse.createByErrorMessage("null request");
        ServerResponse<User> response = userService.login(userVO.getEmail(), userVO.getPassword());
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
        ServerResponse<String> response;
        try {
            userRequestVO.checkArguments();
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
    public ServerResponse changePasswd(String old, String now, HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER);
        if (user == null)
            return ServerResponse.createByErrorMessage("未登录");
        return userService.changePassword(old, now, user);
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
