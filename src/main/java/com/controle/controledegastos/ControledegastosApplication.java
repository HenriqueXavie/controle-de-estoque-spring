package com.controle.controledegastos;

import com.controle.controledegastos.domain.Categoria;
import com.controle.controledegastos.domain.Cidade;
import com.controle.controledegastos.domain.Estado;
import com.controle.controledegastos.domain.Produto;
import com.controle.controledegastos.repositories.CategoriaRepository;
import com.controle.controledegastos.repositories.CidadeRepository;
import com.controle.controledegastos.repositories.EstadoRepository;
import com.controle.controledegastos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ControledegastosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ControledegastosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto produto1 = new Produto(null, "Computador", 2000.00);
        Produto produto2 = new Produto(null, "Impressora", 800.00);
        Produto produto3 = new Produto(null, "Mouse", 30.00);

        cat1.getProdutos().addAll(Arrays.asList(produto1,produto2, produto3));
        cat2.getProdutos().addAll(Arrays.asList(produto2));
        produto1.getCategorias().addAll(Arrays.asList(cat1));
        produto2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        produto3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2,c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

    }
}
