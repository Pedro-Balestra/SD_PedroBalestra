@Repository
public interface RelatorioRepository extends JpaRepository<NotaCompraItem, Long>{
	
	@Query(""" 
			select new br.inatel.labs.lab_jpa.dto.TotalCompraPorFornecedorDTO
				( f.razaoSocial
				, sum(i.quantidade * i.valorCompraProduto)	
				)
				from NotaCompraItem i
					join i.notaCompra n
					join n.fornecedor f
				group by f.razaoSocial
			""")
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor();
}