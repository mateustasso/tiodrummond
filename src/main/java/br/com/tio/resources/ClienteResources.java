package br.com.tio.resources;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tio.domain.Cliente;
import br.com.tio.repository.ClienteRepository;


@RestController
public class ClienteResources {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping(value= {"/hello","/health", "/"}, method = RequestMethod.GET)
	public ResponseEntity<?> hello()
	{
		String retorno = "Sistema ativo -" + Calendar.getInstance().getTime().toString();
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
	
	/**
	 * Obter todas os clientes
	 * @return
	 */
	@RequestMapping(value= {"/clientes"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterClientes()
	{
		List<Cliente> clientes;
		clientes = clienteRepository.findAll();
		if (clientes == null || clientes.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clientes);
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
	/**
	 * Obter cliente pelo idCliente
	 * @param idCliente
	 * @return
	 */
	 
	
	@RequestMapping(value= {"/clientes/{codigocliente}"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterClientesCodigo(@PathVariable("codigocliente") int idCliente )
	{
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		if (cliente == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	
	/**
	 * Novo cliente a partir do JSON cliente...
	 * @param cliente
	 * @return
	 */
	
	
	@RequestMapping(value= {"/clientes"}, method = RequestMethod.POST)
	public ResponseEntity<?> criarClientesCodigo(@RequestBody Cliente cliente)
	{
		if (clienteRepository.existsById(cliente.getcdgCliente()) )
			return ResponseEntity.status(HttpStatus.CONFLICT).body(cliente);
		
		clienteRepository.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
	
	/**
	 * Alterar cliente existente a partir do JSON cliente
	 * @param cliente
	 * @return
	 */
	/*
	@RequestMapping(value= {"/clientes"}, method = RequestMethod.PUT)
	public ResponseEntity<?> alterarClientesCodigo(@RequestBody Cliente cliente )
	{
		Cliente clienteAtual = clienteRepository.findOne(cliente.getcdgCliente());
		if (clienteAtual == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
		
		clienteAtual.setCPF(cliente.getCPF());
		clienteAtual.setNome(cliente.getNome());
	
		
		clienteRepository.save(clienteAtual);
		return ResponseEntity.status(HttpStatus.OK).body(clienteAtual);
		
	}*/
	
	/**
	 *  Eliminar cliente a partir do idCliente
	 * @param idCliente
	 * @return
	 */
	
	@RequestMapping(value= {"/clientes/{codigocliente}"}, method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarClientesCodigo(@PathVariable("codigocliente") Integer idCliente )
	{
		if (!clienteRepository.existsById(idCliente) )
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	
		clienteRepository.deleteById(idCliente);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

}
