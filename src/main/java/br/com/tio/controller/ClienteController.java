package br.com.tio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ClienteController {
	
	@RequestMapping(value = { "/crudCliente" }, method = RequestMethod.GET)

	public ModelAndView getClienteExemplo() {

		ModelAndView mv = new ModelAndView("crudCliente");

		return mv;

}

}
