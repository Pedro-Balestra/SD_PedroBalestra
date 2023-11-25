package br.inatel.labs.labrest_client.model.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProdutoDTO {
    private Long is;
    private String descricao;
    private BigDecimal preco;

    public Long getIs() {
        return is;
    }

    public void setIs(Long is) {
        this.is = is;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Objects.equals(is, that.is);
    }

    @Override
    public int hashCode() {
        return Objects.hash(is);
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "is=" + is +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
