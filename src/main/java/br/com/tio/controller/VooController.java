package br.com.tio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VooController {

	@RequestMapping(value = { "/crudVoo" }, method = RequestMethod.GET)

	public ModelAndView getVooExemplo() {

		ModelAndView mv = new ModelAndView("crudVoo");

		return mv;

}
	
}
