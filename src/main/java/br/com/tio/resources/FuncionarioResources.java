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

import br.com.tio.domain.Funcionario;
import br.com.tio.repository.FuncionarioRepository;


@RestController
public class FuncionarioResources {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	
	/**
	 * Obter todos os funcionarios
	 * @return
	 */
	@RequestMapping(value= {"/funcionarios"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterFuncionarios()
	{
		List<Funcionario> funcionarios;
		funcionarios = funcionarioRepository.findAll();
		if (funcionarios == null || funcionarios.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(funcionarios);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
	}
	
	/**
	 * Obter funcionario pelo idFuncionario
	 * @param idFuncionario
	 * @return
	 */
	
	@RequestMapping(value= {"/funcionarios/{codigofunc}"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterFuncionariosCodigo(@PathVariable("codigofunc") int idFuncionario )
	{
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		if (funcionario == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(funcionario);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(funcionario);
	}
	
	/**
	 * Novo funcionario a partir do JSON funcionario...
	 * @param funcionario
	 * @return
	 */
	
	@RequestMapping(value= {"/funcionarios"}, method = RequestMethod.POST)
	public ResponseEntity<?> criarFuncionariosCodigo(@RequestBody Funcionario funcionario)
	{
		if (funcionarioRepository.existsById(funcionario.getcdgFuncionario()) )
			return ResponseEntity.status(HttpStatus.CONFLICT).body(funcionario);
		
		funcionarioRepository.save(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
	}
	/*
	/**
	 * Alterar funcionario existente a partir do JSON funcionario
	 * @param funcionario
	 * @return
	 */
	/*
	@RequestMapping(value= {"/funcionarios"}, method = RequestMethod.PUT)
	public ResponseEntity<?> alterarFuncionarioCodigo(@RequestBody Funcionario funcionario )
	{
		Funcionario funcionarioAtual = funcionarioRepository.findOne(funcionario.getcdgFuncionario());
		if (funcionarioAtual == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(funcionario);
		
		funcionarioAtual.setNomefunc(funcionario.getNomefunc());
		funcionarioAtual.setCargo(funcionario.getCargo());
		funcionarioAtual.setAdmissao(funcionario.getAdmissao());
	
		
		funcionarioRepository.save(funcionarioAtual);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioAtual);
		
	}*/
	
	/**
	 *  Eliminar funcionario a parter do idFuncionario
	 * @param idFuncionario
	 * @return
	 */
	
	@RequestMapping(value= {"/funcionarios/{codigofunc}"}, method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarFuncionariosCodigo(@PathVariable("codigofunc") Integer idFuncionario )
	{
		if (!funcionarioRepository.existsById(idFuncionario) )
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	
		funcionarioRepository.deleteById(idFuncionario);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

}
