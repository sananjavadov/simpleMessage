package az.senan.simpleMessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import az.senan.simpleMessage.Service.MessageService;
import az.senan.simpleMessage.Service.UserService;
import az.senan.simpleMessage.entity.Message;
import az.senan.simpleMessage.entity.User;
import az.senan.simpleMessage.model.GoogleReCaptcha;
import az.senan.simpleMessage.model.Login;
import az.senan.simpleMessage.model.MessageModel;

import static az.senan.simpleMessage.constant.Const.GoReLink;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
public class mainController {
	
	@Autowired
	UserService u;
	
	@Autowired
	MessageService m;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletResponse response;
		
	@RequestMapping("/")
	public ModelAndView index() {
		if(user()==null) {
			return new ModelAndView("main");			
		}
		return new ModelAndView("main","all",u.getAll()).addObject("includePage", "users.jsp");					
	}
	
	@RequestMapping("/reg")
	public ModelAndView regPage() throws IOException {
		if(user()!=null) {
			session.removeAttribute("username");
			response.sendRedirect("/reg");
		}
		return new ModelAndView("main","user",new User()).addObject("includePage", "reg.jsp");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() throws IOException {
		if(user()!=null) {
			session.removeAttribute("username");
			response.sendRedirect("/login");
		}
		return new ModelAndView("main","login", new Login()).addObject("includePage", "login.jsp");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(@ModelAttribute("login") Login login, String errMessage) throws IOException  {
		if(u.getByUsername(login.getUsername())==null || !u.getByUsername(login.getUsername()).getPassword().equals(login.getPassword())) {			
			errMessage="İstifadəçi adı və ya şifrə səhvdir";
			return new ModelAndView("main","errorMessage",errMessage).addObject("includePage","login.jsp");			
		}
		
		session.setAttribute("username", login.getUsername());
		response.sendRedirect("/");
		
		return null;		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() throws IOException {
		session.removeAttribute("username");
		response.sendRedirect("/");
		return null;
	}
	
	@RequestMapping(value="/regresult", method=RequestMethod.GET)
	public ModelAndView regResultGet() {
		return new ModelAndView("main","user",new User()).addObject("includePage", "reg.jsp");
	}
	
	@RequestMapping(value="/regresult",  method=RequestMethod.POST)
	public ModelAndView regResult(@Valid @ModelAttribute("user")  User user, BindingResult b, String result, @RequestParam(value="g-recaptcha-response",required=false) String  response) {
		
		GoogleReCaptcha captcha=new RestTemplate().exchange(GoReLink+response, HttpMethod.POST, null, GoogleReCaptcha.class).getBody();
		
		if(b.hasErrors() || !captcha.isSuccess()) {
			result="Qeydiyyat məlumatlarını düzgün doldurun";
		}else if(u.getByUsername(user.getUsername())!=null) {
			result="Bu istifadəçi artıq qeydiyyatdan keçib!!";
		}else {
			u.saveUser(user);
			result="Qeydiyyat uğurla tamamlandı";
		}
		
		return new ModelAndView("main", "resultMessage", result).addObject("includePage", "regresult.jsp");
	}
	
	@RequestMapping("/message/{partner}")
	public ModelAndView message(@PathVariable("partner") int partner) throws NoHandlerFoundException  {
		if(user()==null) {
			throw new NoHandlerFoundException(null, null, null);			
		}else if(u.getById(partner)==null) {
			throw new NoHandlerFoundException(null, null, null);			
		}
		
		session.setAttribute("partner", partner);
		
		return new ModelAndView("main","messages",m.getMessages(user().getId(), partner))
				.addObject("includePage", "messages.jsp")
				.addObject("sendMessage", new MessageModel())
				.addObject("partnerUser", u.getById(partner));
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public void send(@ModelAttribute("sendMessage") MessageModel model) throws IOException, NoHandlerFoundException {
		if(user()!=null) {
			int partner=(int) session.getAttribute("partner");
			m.saveMessage(new Message(model.getMessage(), partner, user()));
			session.removeAttribute("partner");
			response.sendRedirect("/message/"+partner);
		}
		throw new NoHandlerFoundException(null, null, null);		
	}

	@ModelAttribute("userSession")
	public User user() {
		return u.getByUsername((String) session.getAttribute("username"));
	}
		
}
