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