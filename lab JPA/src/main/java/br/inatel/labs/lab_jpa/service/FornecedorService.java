package br.inatel.labs.lab_jpa.service;

import br.inatel.labs.lab_jpa.entity.Fornecedor;
import br.inatel.labs.lab_jpa.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor salvar(Fornecedor f) {
		return fornecedorRepository.save(f);
	}
	
	public Optional<Fornecedor> buscarPeloId(Long id) {
		return fornecedorRepository.findById(id);
	}
	
	public List<Fornecedor> listar(){
		return fornecedorRepository.findAll();
	}
	
	public void remover(Fornecedor f) {
		fornecedorRepository.delete(f);
	}
}