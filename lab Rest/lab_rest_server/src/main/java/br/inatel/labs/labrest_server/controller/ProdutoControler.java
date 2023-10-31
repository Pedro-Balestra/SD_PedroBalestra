package br.inatel.labs.labrest_server.controller;

import br.inatel.labs.labrest_server.model.Produto;
import br.inatel.labs.labrest_server.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoControler {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> getProduto() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable("id") long produtoId) {
        Optional<Produto> opProduto = service.findById(produtoId);

        if (opProduto.isEmpty()) {
            String msg = String.format("Nehum produto encontrado com id [%s]", produtoId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        }
        //A partir daqui esta tudo ok!
        return opProduto.get();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto postPorduto(@RequestBody Produto p) {
        Produto produtoCriado = service.create(p);
        return produtoCriado;
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void putProduto(@RequestBody Produto p) {
        service.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable("id") Long produtoId) {
        Produto produtoEncontrado = this.getProdutoById(produtoId);
        service.remove(produtoEncontrado);
    }
}
