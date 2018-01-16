package hello.controller;

import hello.service.IUserInfoTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/1/10.
 */
@Controller
@RequestMapping("/userInfoTempController")
public class UserInfoTempController {

    @Autowired
    private IUserInfoTempService userInfoTempService;

    @RequestMapping("/getUserInfoPage")
    public String getUserInfoPage(String userCode,HttpServletRequest request) {
        String userName = userInfoTempService.getUserNameByCode(userCode);
        request.setAttribute("userName", userName);
        return "/UserInfo";
    }
}
