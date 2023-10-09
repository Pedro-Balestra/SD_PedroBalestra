public class NotaCompraService {
	
	@Autowired
	private NotaCompraRepository ncRepository;
	
	@Autowired
	private NotaCompraItemRepository nciRepository;
	
	//nota compra
	public NotaCompra salvarNotaCompra(NotaCompra nc) {
		return ncRepository.save(nc);
	}
	
	public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
		return ncRepository.findById(id);
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		Optional<NotaCompra> opNotaCompra = ncRepository.findById(id);
		if(opNotaCompra.isPresent()) {
			NotaCompra notaCompra = opNotaCompra.get();
			notaCompra.getListaNotaCompraItem().size();
			return notaCompra;
		} else {
			throw new RuntimeException("Nenhuma nota compra encontrada");
		}
	}
	
	public List<NotaCompra> listarNotaCompra(){
		return ncRepository.findAll();
	}
	
	//nota compra item
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		return nciRepository.save(item);
	}
	
	public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
		return nciRepository.findById(id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		return nciRepository.findAll();
	}
	
}