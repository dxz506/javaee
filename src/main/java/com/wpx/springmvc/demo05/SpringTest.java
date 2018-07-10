package com.wpx.springmvc.demo05;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wpx.springmvc.User;

@RequestMapping("/spring-mvc/demo05")
@Controller
@SessionAttributes({"user"})
public class SpringTest {


	
	private static final String SUCCESS="success";
	
	/**
	 * ӳ������ͷ��Ϣ
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String la) {
		System.out.println(" TestRequestHeader Accept Language "+la);
		return SUCCESS;
	}
	
	/**
	 * 
	 * ����Cookieֵ
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String id) {
		System.out.println(" TestCookieValue JSESSIONID  " +id);
		return SUCCESS;
	}
	
	/**
	 * springmvc��ԭ����ServletApi��֧��
	 * �ɽ��ܵ����Ͳ���:
	 * 	HttpServletRequest	HttpServletResponse
	 * HttpSession java.security.Principal
	 * Locale InputStream OutputStream 
	 * Reader Writer
	 * @throws IOException 
	 * 
	 */
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request) throws IOException {
		String requestParater=(String) request.getParameter("username");
		System.out.println(requestParater);
		return SUCCESS;
	}
	
	/**
	 * ����ModelAndView
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mav=new ModelAndView("success");
		mav.addObject("message", "ModelAndView������Ϣ");
		return mav;
	}
	
	/**
	 * ����Model
	 */
	@RequestMapping("/testModel")
	public String testModel(Model model) {
		model.addAttribute("message", "model��Ϣ");
		return SUCCESS;
	}
	
	/**
	 *����Map 
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map) {
		map.put("message", "map��Ϣ");
		return SUCCESS;
	}
	/**
	 * ����SessionAttribute
	 */
	@RequestMapping("/testSessionAttibute")
	public String testSessionAttribute(Map<String,Object> map) {
		User user=new User(1, "wangpx", 21);
		map.put("user", user);
		return SUCCESS;
	}
	
	/**
	 * ����ModelAttribute
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("�޸�  : "+user);
		return SUCCESS;
	}
	/**
	 * ModelAttributeע��
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false)Integer id,Map<String,Object> map) {
		if(id != null) {
			//ģ������ݿ��л�ȡ����
			User user=new User(1,"wangpx",22);
			System.out.println("�����ݿ��л�ȡһ������: "+user);
			map.put("user", user);
		}
	}
	
	
}
