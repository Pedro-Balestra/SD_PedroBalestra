public class NotaCompraService {
	
	@Autowired
	private NotaCompraRepository ncRepository;
	
	@Autowired
	private NotaCompraItemRepository nciRepository;
	   
	@PersistenceContext
	private EntityManager em;
	
	//nota compra
	public NotaCompra salvarNotaCompra(NotaCompra nc) {
		return em.merge(nc);
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class,id);
	}
	
	public List<NotaCompra> listarNotaCompra(){
		return em.createQuery("Select nc from NotaCompra nc", NotaCompra.class).getResultList();
	}

	
	//nota compra item
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		return em.merge(item);
	}
	
	public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class,id);
	}

    public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		if(opNotaCompra.isPresent()) {
			NotaCompra notaCompra = opNotaCompra.get();
			notaCompra.getListaNotaCompraItem().size();
			return notaCompra;
		} else {
			throw new RuntimeException("Nenhuma nota compra encontrada");
		}
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		return em.createQuery("Select i from NotaCompra i", NotaCompraItem.class).getResultList();
	}
	
}