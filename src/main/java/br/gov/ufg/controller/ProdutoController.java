package br.gov.ufg.controller;

import br.gov.ufg.dto.ProdutoDTO;
import br.gov.ufg.entity.Produto;
import br.gov.ufg.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;


    @PostMapping
    public Produto createProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.createProduto(produtoDTO);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable int id, @RequestBody ProdutoDTO produtoDTO) {
        return produtoService.updateProduto(id, produtoDTO);
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable int id) {
        return produtoService.getProdutoById(id);
    }

    @GetMapping("/listarProdutos")
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduto(@PathVariable int id) {
        return produtoService.deleteProduto(id);
    }
}