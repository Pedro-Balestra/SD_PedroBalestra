@Service
@Transactional
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public Fornecedor salvar(Fornecedor f) {
		f = em.merge(f);
        return f;
	}
	
	public Optional<Fornecedor> buscarPeloId(Long id) {
        Fornecedor fornecedorEncontrado = em.find(Fornecedor.class, id)
		return fornecedorEncontrado;
	}
	
	public List<Fornecedor> listar(){
        String jpql = "Select f from Fornecedor f";
        List<Fornecedor> fornecedores - em.createQuery(jpql, Fornecedor.class)
		return fornecedores;
	}
	
	public void remover(Fornecedor f) {
        em.remove(em.merge(f));
	}
}