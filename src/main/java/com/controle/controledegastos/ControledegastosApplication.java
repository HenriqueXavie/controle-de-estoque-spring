package com.controle.controledegastos;

import ch.qos.logback.core.net.server.Client;
import com.controle.controledegastos.domain.*;
import com.controle.controledegastos.enums.TipoCliente;
import com.controle.controledegastos.repositories.*;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "11122233344", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("4444-4444", "5555-5555"));

        Endereco e1 = new Endereco(null, "Rua 05", "300", "ap 303", "Jardim", "4545645656", cli1, c1);
        Endereco e2 = new Endereco(null, "Rua 20", "105", "ap 105", "Sao Paulo", "774545687", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
    }
}
