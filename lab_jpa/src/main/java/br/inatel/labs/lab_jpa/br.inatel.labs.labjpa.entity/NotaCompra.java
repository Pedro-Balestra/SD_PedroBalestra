@Entity
public class NotaCompra {
	
	@Id
	private Long id;
	
	@NotNull
	@Past
	private LocalDate dataEmissao;

    @ManyToOne
    private Fornecedor fornecedor;

    @OneToMany(mappeBy = "notaCompra")
    private List<NotaCompaItem> listaNotaCompraItem;

    // acessores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<NotaCompraItem> getListaNotaCompraItem() {
		return listaNotaCompraItem;
	}

	public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
		this.listaNotaCompraItem = listaNotaCompraItem;
	}


    //Calcula o total da nota somando os totais de cada item    
    public BigDecimal getCalculoTotalNota() {
        BigDecimal totalNota = this.listaNotaCompraItem.stream()
            .map( i -> i.getCalculoTotalItem() )
            .reduce( BigDecimal.ZERO, BigDecimal::add );

        return totalNota;
    }   

}