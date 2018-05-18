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

import br.com.tio.domain.Viagem;
import br.com.tio.repository.ViagemRepository;

@RestController
public class ViagemResources {
	
	@Autowired
	private ViagemRepository viagemRepository;

	
	
	/**
	 * Obter todas as viagens
	 * @return
	 */
	@RequestMapping(value= {"/viagens"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterViagens()
	{
		List<Viagem> viagens;
		viagens = viagemRepository.findAll();
		if (viagens == null || viagens.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(viagens);
		return ResponseEntity.status(HttpStatus.OK).body(viagens);
	}
	
	/**
	 * Obter viagem pelo idViagem
	 * @param idViagem
	 * @return
	 */
	
	@RequestMapping(value= {"/viagens/{codigoviagem}"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterViagensCodigo(@PathVariable("codigoviagem") int idViagem )
	{
		Optional<Viagem> viagem = viagemRepository.findById(idViagem);
		if (viagem == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(viagem);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(viagem);
	}
	
	/**
	 * Nova viagem a partir do JSON viagem...
	 * @param viagem
	 * @return
	 */
	
	@RequestMapping(value= {"/viagens"}, method = RequestMethod.POST)
	public ResponseEntity<?> criarViagensCodigo(@RequestBody Viagem viagem)
	{
		if (viagemRepository.existsById(viagem.getcdgViagem()) )
			return ResponseEntity.status(HttpStatus.CONFLICT).body(viagem);
		
		viagemRepository.save(viagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(viagem);
	}
	
	/*
	/**
	 * Alterar viagem existente a partir do JSON viagem
	 * @param viagem
	 * @return
	 */
	/*
	@RequestMapping(value= {"/viagens"}, method = RequestMethod.PUT)
	public ResponseEntity<?> alterarViagensCodigo(@RequestBody Viagem viagem )
	{
		Viagem viagemAtual = viagemRepository.findOne(viagem.getcdgViagem());
		if (viagemAtual == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(viagem);
		
		viagemAtual.setEstado(viagem.getEstado());
		viagemAtual.setPreco(viagem.getPreco());
		viagemAtual.setCompanhia(viagem.getCompanhia());
		viagemAtual.setHora(viagem.getHora());
		
		viagemRepository.save(viagemAtual);
		return ResponseEntity.status(HttpStatus.OK).body(viagemAtual);
		
	}*/
	
	/**
	 *  Eliminar viagem a partir do idViagem
	 * @param idViagem
	 * @return
	 */
	
	@RequestMapping(value= {"/viagens/{codigoviagem}"}, method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarViagensCodigo(@PathVariable("codigoviagem") Integer idViagem )
	{
		if (!viagemRepository.existsById(idViagem) )
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	
		viagemRepository.deleteById(idViagem);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
