package br.com.tio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ViagemController {
	
	@RequestMapping(value = { "/crudViagem" }, method = RequestMethod.GET)

	public ModelAndView getViagemExemplo() {

		ModelAndView mv = new ModelAndView("crudViagem");

		return mv;

}
}
