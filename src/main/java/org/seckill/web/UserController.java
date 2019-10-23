package org.seckill.web;

import java.security.MessageDigest;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seckill") //url:模块
public class UserController {
	
	@Autowired
    private UserService userService;
	
	/**
     * 登录页面
     * @param model
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }	
    
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String test(Model model){
        return "test";
    }
	
	//执行登录
    @RequestMapping(value = "login_check", method = RequestMethod.POST)
    @ResponseBody
    public int login(String userName,String userPassword) {
    	String passwordBySha1 = getSha1(userPassword);
    	boolean count = userService.selectUserByUsernameAndPassword(userName,passwordBySha1);
    	int message;
    	if(count == true) {
    		message = 1;
    		userService.recordUser(userName,new Date());
    	} else {
    		message = 0;
    	}
    	//System.out.println("Message:+++++++++" + message);
    	return message;
    }
    
    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }

}
