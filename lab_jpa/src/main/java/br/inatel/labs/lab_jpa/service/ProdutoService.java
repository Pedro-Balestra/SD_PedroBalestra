@Service
@Transactional
public class ProdutoService{
    
    @Autowired
    private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto p) {
		return produtoRepository.save(p);
	}
	
	public Optional<Produto> buscarPeloId(Long id) {
		return produtoRepository.findById(id);
	}
	
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	public void remove(Produto p) {
		produtoRepository.delete(p);
	}

}