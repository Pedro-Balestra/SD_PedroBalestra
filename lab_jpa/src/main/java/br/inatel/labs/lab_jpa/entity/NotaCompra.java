package br.inatel.labs.lab_jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class NotaCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Past
	private LocalDate dataEmissao;

    @ManyToOne
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "notaCompra")
    private List<NotaCompraItem> listaNotaCompraItem;

	//construtores
	public NotaCompra() {
		
	}
	
	public NotaCompra(@NotNull @Past LocalDate dataEmissao, Fornecedor fornecedor) {
		super();
		this.dataEmissao = dataEmissao;
		this.fornecedor = fornecedor;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaCompra other = (NotaCompra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NotaCompra [id=" + id + ", dataEmissao=" + dataEmissao + "]";
	}

    @Entity
    public static class NotaCompraItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Positive
        private BigDecimal valorCompraProduto;

        @NotNull
        @Positive
        private Integer quantidade;

        @ManyToOne
        private NotaCompra notaCompra;

        @ManyToOne
        private Produto produto;

        //construtores
        public NotaCompraItem(NotaCompra nc1, Produto p1, BigDecimal bigDecimal, int i) {

        }

        public NotaCompraItem(BigDecimal valorCompraProduto, @NotNull @Positive Integer quantidade,
                NotaCompra notaCompra, Produto produto) {
            super();
            this.valorCompraProduto = valorCompraProduto;
            this.quantidade = quantidade;
            this.notaCompra = notaCompra;
            this.produto = produto;
        }

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

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            NotaCompraItem other = (NotaCompraItem) obj;
            return Objects.equals(id, other.id);
        }

        @Override
        public String toString() {
            return "NotaCompra.NotaCompraItem [id=" + id + ", valorCompraProduto=" + valorCompraProduto + ", quantidade=" + quantidade
                    + "]";
        }

    }
}