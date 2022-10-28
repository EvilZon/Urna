package br.com.faeterj.gestaofaeterj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.faeterj.gestaofaeterj.model.Urna;
import br.com.faeterj.gestaofaeterj.service.UrnaService;

@RestController // Corretor
@RequestMapping("/api/urnas") // Só entra aqui se na url tiver essa URI.
public class UrnaController {

	@Autowired
	private UrnaService servico;
	
	@GetMapping
	public ResponseEntity<List<Urna>> obterTodos(){
		
		List<Urna> lista = servico.obterTodos();
		return ResponseEntity.ok(lista); // 200
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Urna> obterPorId(@PathVariable Long id){
		
		Optional<Urna> optUrna = servico.obterPorId(id);
		return ResponseEntity.ok(optUrna.get()); // 200
	}
	
	@PostMapping 
	public ResponseEntity<Urna> cadastrar(@RequestBody Urna urna) {
		urna = servico.cadastrar(urna);
		return new ResponseEntity<>(urna, HttpStatus.CREATED); // 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Urna> atualizar(@PathVariable Long id, @RequestBody Urna urna) {
		return ResponseEntity.ok(servico.atualizar(id, urna)); // 200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
