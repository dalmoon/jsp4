package com.test.user;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join.do")
	public String userInsert(UserVO vo) {
		userService.userInsert(vo);
		return "login";
	}
	
	@RequestMapping(value = "/login.do")
	public String login(UserVO vo, HttpSession session) {
		if(userService.userLogin(vo) != null) {
			session.setAttribute("userName", vo.getId());
			return "redirect:list.do";
		}
		else return "login";
	}
	
	@RequestMapping(value = "/idDuplChk.do" , method = RequestMethod.POST)
	public @ResponseBody String idDuplChk(@ModelAttribute("vo") UserVO vo , Model model) throws Exception{
	    int result = userService.idDuplChk(vo.getId());
	    return String.valueOf(result);
	}
}
