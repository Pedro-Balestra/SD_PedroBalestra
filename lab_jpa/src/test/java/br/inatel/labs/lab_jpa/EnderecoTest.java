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