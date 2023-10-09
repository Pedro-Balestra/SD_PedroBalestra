@Service
public class RelatorioService {
	
	@Autowired
	private RelatorioRepository repository;
	
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
		return repository.pesquisarTotalCompradoPorFornecedor();
	}

}