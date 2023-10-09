@Entity
public class NotaCompraItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Positive
	@Getter @Setter private BigDecimal valorCompraProduto;

	@NotNull
	@Positive
	private Integer quantidade;

	@ManyToOne
	private NotaCompra notaCompra;

	@ManyToOne
	private Produto produto;

    // acessores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorCompraProduto() {
		return valorCompraProduto;
	}

	public void setValorCompraProduto(BigDecimal valorCompraProduto) {
		this.valorCompraProduto = valorCompraProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public NotaCompra getNotaCompra() {
		return notaCompra;
	}

	public void setNotaCompra(NotaCompra notaCompra) {
		this.notaCompra = notaCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
    
    //Calculo do total do item em tempo de execução
    public BigDecimal getCalculoTotalItem() {
        return valorCompraProduto.multiply( BigDecimal.valueOf( quantidade ) );
    }


}