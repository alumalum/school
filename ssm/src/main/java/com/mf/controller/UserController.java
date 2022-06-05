package com.mf.controller;

import com.mf.Until.DateUntil;
import com.mf.Until.Pages;
import com.mf.entity.Roles;
import com.mf.entity.User;
import com.mf.service.RolesService;
import com.mf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RolesService rolesService;

    @RequestMapping("/login")
    public String Login(User user, HttpSession session) {
        System.out.println("--------login--------");
        User u = userService.Login(user);
        if (u != null) {
            session.setAttribute("user", u);
            if(u.getRid() == 1){
                return "main";
            }else {
                return "redirect:/product/getAllProduct";
            }
        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/getAllUser")
    public String getAllUser(String name, Integer currentPage, HttpServletRequest request) {
        System.out.println("----------grtAllUser------------");
        System.out.println("name: " + name);
        System.out.println("currentPage: " + currentPage);
        if ("".equals(name)) {
            name = null;
        }
        if (currentPage == null) {
            currentPage = 1;
        }
        Pages pages = new Pages();
        pages.setTotalCount(userService.getUserCount(name));
        pages.setCurrentPage(currentPage);
        List<User> userList = userService.getAllUserAndRoles(name, currentPage, pages.getPageSize());
        request.setAttribute("name", name);
        request.setAttribute("userList", userList);
        request.setAttribute("pages", pages);
        return "userList";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer uid) {
        System.out.println("----------deleteUserById-----------");
        userService.deleteUser(uid);
        return "redirect:/user/getAllUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, String myTime) {
        System.out.println("----------updateUser-----------");
        System.out.println(user);
        user.setCreateTime(DateUntil.StrToDate(myTime));
        userService.updateUserById(user);
        return "redirect:/user/getAllUser";
    }

    @RequestMapping("/getUserById")
    public String getUserById(Integer uid, HttpServletRequest request) {
        System.out.println("----------getUserById-----------");
        User user = userService.getUserById(uid);
        List<Roles> rolesList = rolesService.getRoles();
        System.out.println("user:" + user);
        request.setAttribute("user", user);
        request.setAttribute("rolesList", rolesList);
        return "updateUser";
    }

    @RequestMapping("/toAdd")
    public String toAdd(HttpServletRequest request) {
        System.out.println("----------toAdd-----------");
        List<Roles> rolesList = rolesService.getRoles();
        request.setAttribute("rolesList", rolesList);
        return "addUser";
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public Boolean checkName(String name) {
        System.out.println("----------checkName-----------");
        System.out.println("name:"+name);
        User user = userService.getUserByName(name);
        System.out.println(user);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/addUser")
    public String addUser(User user,String myTime){
        user.setCreateTime(DateUntil.StrToDate(myTime));
        System.out.println("user:"+user);
        userService.addUser(user);
        return "redirect:/login.jsp";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
