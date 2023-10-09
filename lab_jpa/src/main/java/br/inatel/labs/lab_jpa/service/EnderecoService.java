@Service
@Transactional
public class EnderecoService {
	
	@PersistenceContext
	private EntityManager em;
	
	public Endereco salvar(Endereco e) {
		return em.merge(e);
	}
}