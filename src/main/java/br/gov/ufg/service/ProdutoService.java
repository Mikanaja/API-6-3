package br.gov.ufg.service;

import br.gov.ufg.dto.ProdutoDTO;
import br.gov.ufg.entity.Produto;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.tools.javac.Main;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final List<Produto> produtos;

    private static final String CAMINHO_ARQUIVO = "database/produtos.txt";

    public static List<Produto> lerProdutosDoArquivo() throws IOException, URISyntaxException {

        // Tentar obter o caminho do arquivo como um recurso
        java.net.URL resource = Main.class.getClassLoader().getResource(CAMINHO_ARQUIVO);

        // Converter URL para URI e obter o caminho absoluto
        java.nio.file.Path caminhoArquivoAbsoluto = Paths.get(resource.toURI());

        if (resource != null) {

            return Files.lines(caminhoArquivoAbsoluto)
                    .map(line -> {
                        String[] prod = line.split(",");
                        return new Produto(Integer.parseInt(prod[0]), prod[1], prod[2], Double.parseDouble(prod[3]), Integer.parseInt(prod[4]), prod[5]);
                    })
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public ProdutoService() {
        produtos = new ArrayList<>();
    }

    public Produto createProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setIdProduto(produtoDTO.getIdProduto());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setEstoque(produtoDTO.getEstoque());
        produtos.add(produto);
        return produto;
    }

    public Produto updateProduto(int id, ProdutoDTO produtoDTO) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id) {
                produto.setNome(produtoDTO.getNome());
                produto.setDescricao(produtoDTO.getDescricao());
                produto.setPreco(produtoDTO.getPreco());
                produto.setEstoque(produtoDTO.getEstoque());
                return produto;
            }
        }
        return null; // ou lançar uma exceção
    }

    public Produto getProdutoById(int id) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id) {
                return produto;
            }
        }
        return null; // ou lançar uma exceção
    }

    public List<Produto> getAllProdutos() {
        try {
            return lerProdutosDoArquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteProduto(int id) {
        return produtos.removeIf(produto -> produto.getIdProduto() == id);
    }
}