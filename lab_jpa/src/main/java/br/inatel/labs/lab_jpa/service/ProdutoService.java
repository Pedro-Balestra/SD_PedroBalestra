@Service
@Transactional
public class ProdutoService{
    
    @PersistenceContext
    private EntityManager em;

    public Produto salvar(Produto p){
        p = em.merge(p);
        return p;
    }

    public Produto buscaPeloId(Long id){
        Produto produtoEncontrado = em.find(Produto.class,id);
        return produtoEncontrado;
    }

    public List<Produto> listar(){
        List<Produto> produtos = em.createQuery("Select p from Produto p", Produto.class).getResultList();
        return produtos;
    }

    
    public void remover(Produto p) {
        p = em.merge( p );
        em.remove( p );
    }

}