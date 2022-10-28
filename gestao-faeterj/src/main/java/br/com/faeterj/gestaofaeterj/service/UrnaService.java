package br.com.faeterj.gestaofaeterj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faeterj.gestaofaeterj.exception.ResourceBadRequestException;
import br.com.faeterj.gestaofaeterj.exception.ResourceNotFoundException;
import br.com.faeterj.gestaofaeterj.model.Urna;
import br.com.faeterj.gestaofaeterj.repository.UrnaRepository;

@Service
public class UrnaService {

	@Autowired
	private UrnaRepository repositorio;
	
	public List<Urna> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Urna> obterPorId(Long id){
		
		Optional<Urna> optUrna = repositorio.findById(id);
		
		if(optUrna.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar a urna com id " + id);
		}
		
		return optUrna;
	}
	
	public Urna cadastrar(Urna urna) {
		
		validarModelo(urna);
		
		urna.setId(null);
		return repositorio.save(urna);
	}
	
	public Urna atualizar(Long id, Urna urna) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		validarModelo(urna);
		
		urna.setId(id);
		return repositorio.save(urna);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	
}
