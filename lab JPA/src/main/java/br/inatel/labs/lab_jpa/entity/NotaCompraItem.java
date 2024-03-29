package br.inatel.labs.lab_jpa.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class NotaCompraItem {

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

    public NotaCompraItem() {

    }

    public BigDecimal getCalculoTotalItem() {
        return valorCompraProduto.multiply( BigDecimal.valueOf( quantidade ) );
    }


    public NotaCompraItem(@NotNull @Positive BigDecimal valorCompraProduto, @NotNull @Positive Integer quantidade,
                          NotaCompra notaCompra, Produto produto) {
        super();
        this.valorCompraProduto = valorCompraProduto;
        this.quantidade = quantidade;
        this.notaCompra = notaCompra;
        this.produto = produto;
    }



    public NotaCompraItem(NotaCompra nc1, Produto p1, BigDecimal bigDecimal, int i) {

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
        return "NotaCompraItem [id=" + id + ", valorCompraProduto=" + valorCompraProduto + ", quantidade=" + quantidade
                + "]";
    }






}