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

import br.com.tio.domain.Voo;
import br.com.tio.repository.VooRepository;

@RestController
public class VooResources {
	
	@Autowired
	private VooRepository vooRepository;

	
	
	/**
	 * Obter todas os voos
	 * @return
	 */
	@RequestMapping(value= {"/voos"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterVoos()
	{
		List<Voo> voos;
		voos = vooRepository.findAll();
		if (voos == null || voos.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(voos);
		return ResponseEntity.status(HttpStatus.OK).body(voos);
	}
	
	/**
	 * Obter voo pelo idVoo
	 * @param idVoo
	 * @return
	 */
	
	@RequestMapping(value= {"/voos/{codigovoo}"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterVoosCodigo(@PathVariable("codigovoo") int idVoo )
	{
		Optional<Voo> voo = vooRepository.findById(idVoo);
		if (voo == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(voo);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(voo);
	}
	
	/**
	 * Novo voo a partir do JSON voo...
	 * @param voo
	 * @return
	 */
	
	@RequestMapping(value= {"/voos"}, method = RequestMethod.POST)
	public ResponseEntity<?> criarVoosCodigo(@RequestBody Voo voo)
	{
		if (vooRepository.existsById(voo.getcdgVoo()) )
			return ResponseEntity.status(HttpStatus.CONFLICT).body(voo);
		
		vooRepository.save(voo);
		return ResponseEntity.status(HttpStatus.CREATED).body(voo);
	}
	
	/**
	 * Alterar voo existente a partir do JSON voo
	 * @param voo
	 * @return
	 */
	/*
	@RequestMapping(value= {"/voo"}, method = RequestMethod.PUT)
	public ResponseEntity<?> alterarVoosCodigo(@RequestBody Voo voo )
	{
		Voo vooAtual = vooRepository.findOne(voo.getcdgVoo());
		if (vooAtual == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(voo);
		
		vooAtual.setClasse(voo.getClasse());
		vooAtual.setPoltrona(voo.getPoltrona());
	
		
		vooRepository.save(vooAtual);
		return ResponseEntity.status(HttpStatus.OK).body(vooAtual);
		
	}*/
	
	/**
	 *  Eliminar voo a partir do idVoo
	 * @param idVoo
	 * @return
	 */
	
	@RequestMapping(value= {"/voos/{codigovoo}"}, method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarVoosCodigo(@PathVariable("codigovoo") Integer idVoo )
	{
		if (!vooRepository.existsById(idVoo) )
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	
		vooRepository.deleteById(idVoo);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

}
