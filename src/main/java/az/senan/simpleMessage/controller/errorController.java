package az.senan.simpleMessage.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;




@ControllerAdvice
public class errorController {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ModelAndView nfo() {
		return new ModelAndView("main","errorMsg","Belə bir səhifə yoxdur").addObject("includePage", "error.jsp");
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ModelAndView isr() {
		return new ModelAndView("main","errorMsg","Belə bir səhifə yoxdur").addObject("includePage", "error.jsp");
	}    
}  
