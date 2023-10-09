@SpringBootTest
public class RelatorioServiceTest {
	
	@Autowired
	private RelatorioService service;
	
	@Test
	void test() {
		List<TotalCompradoPorFornecedorDTO> listaDTO = service.pesquisarTotalCompradoPorFornecedor();
		
		assertFalse(listaDTO.isEmpty());
		
		// System.out.println("FornecedorRazaoSocial : TotalComprada");
		// listaDTO.forEach(r -> {
		// 	System.out.println(r.fornecedorRazaoSocial());
		// 	System.out.print(" : ");
		// 	System.out.println(r.totalComprado());
		// });
		
		listaDTO.forEach(r -> System.out.println(r));
		
		listaDTO.forEach(System.out :: println);
	}
}