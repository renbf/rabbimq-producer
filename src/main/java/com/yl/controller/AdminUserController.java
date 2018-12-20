package com.yl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yl.modle.AdminUser;
import com.yl.mq.MqProducer;
import com.yl.service.IAdminUserService;
/**
 * @author rbf
 * @createdate 2018/12/20 06:59
 * @desriction
 */
@Controller
public class AdminUserController {

	@Autowired
	private IAdminUserService adminUserService;
	@Autowired
	private MqProducer mqProducer;
	
	@RequestMapping(value = "/getAdminUserList")
	public ModelAndView getAdminUserList(HttpServletRequest request) {
        List<AdminUser> list = adminUserService.queryAdminUserAll();
        ModelAndView mv = new ModelAndView("adminUser");
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("name", "1fds");
        mv.addAllObjects(result);
        return mv;
	}
	
	@RequestMapping(value = "/send")
	@ResponseBody
	public String send(HttpServletRequest request) {
        Map<String,Object> msg = new HashMap<String,Object>();
        msg.put("data","hello,rabbmitmq!");
        mqProducer.sendDataToQueue("test_queue_key", msg);
        return "cg";
	}
	
}
