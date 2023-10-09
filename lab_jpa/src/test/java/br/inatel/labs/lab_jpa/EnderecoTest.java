package br.inatel.labs.lab_jpa;

import br.inatel.labs.lab_jpa.entity.Endereco;
import br.inatel.labs.lab_jpa.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoTest {
	
	@Autowired
	private EnderecoService service;
	
	@Test
	public void testarUUIDGeradoPeloJPAListener() {
		
		Endereco endereco = new Endereco();
		endereco.setRua("Av. Joao de Camargo");
		endereco.setNumero("510");
		endereco.setCidade("Santa Rita");
		endereco.setUf("MG");
		
		service.salvar(endereco);
		
		System.out.println(endereco);
	}
}