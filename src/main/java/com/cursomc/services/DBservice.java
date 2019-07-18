package com.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Cidade;
import com.cursomc.domain.Cliente;
import com.cursomc.domain.Endereco;
import com.cursomc.domain.Estado;
import com.cursomc.domain.ItemPedido;
import com.cursomc.domain.Pagamento;
import com.cursomc.domain.PagamentoComBoleto;
import com.cursomc.domain.PagamentoComCartao;
import com.cursomc.domain.Pedido;
import com.cursomc.domain.Produto;
import com.cursomc.domain.enums.EstadoPagamento;
import com.cursomc.domain.enums.Perfil;
import com.cursomc.domain.enums.Sexo;
import com.cursomc.domain.enums.TipoCliente;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.repositories.CidadeRepository;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.repositories.EnderecoRepository;
import com.cursomc.repositories.EstadoRepository;
import com.cursomc.repositories.ItemPedidoRepository;
import com.cursomc.repositories.PagamentoRepository;
import com.cursomc.repositories.PedidoRepository;
import com.cursomc.repositories.ProdutoRepository;

@Service
public class DBservice {
	
	@Autowired
	private BCryptPasswordEncoder pe;

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

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Cachorro");
		Categoria cat2 = new Categoria(null, "Gato");
		Categoria cat3 = new Categoria(null, "Pássaro");
		Categoria cat4 = new Categoria(null, "Reptil");
		Categoria cat5 = new Categoria(null, "Outros");

		Produto p1 = new Produto(null, "Dalmatas", 0.00, 4, Sexo.Masculino, "Matheus Lima");
		Produto p2 = new Produto(null, "Pastor Alemão", 0.00, 3, Sexo.Masculino, "Vinicius Filho");
		Produto p3 = new Produto(null, "Pitbull", 0.00, 4, Sexo.Feminino, "Larissa Jaraia");
		Produto p4 = new Produto(null, "Vira Lata", 0.00, 5, Sexo.Feminino, "Ana Bianca");
		Produto p5 = new Produto(null, "Bulldogue", 0.00, 6, Sexo.Masculino, "Fernanda Paula");
		Produto p6 = new Produto(null, "Labrador", 0.00, 5, Sexo.Feminino, "Iane Arruda");
		Produto p7 = new Produto(null, "Chihuahua", 0.00, 6, Sexo.Masculino, "Arthur Vieira");
		Produto p8 = new Produto(null, "Poodle", 0.00, 7, Sexo.Masculino, "Rodrigo Santos");
		Produto p9 = new Produto(null, "Husky Siberiano", 0.00, 6, Sexo.Masculino, "Humberto Alves");
		Produto p10 = new Produto(null, "Pug", 0.00, 5, Sexo.Masculino, "Antonio Pereira");
		Produto p11 = new Produto(null, "Beagle", 0.00, 7, Sexo.Feminino, "Bianca Freitas");
		Produto p12 = new Produto(null, "Boxer", 0.00, 8, Sexo.Masculino, "Sabrina Sato");
		Produto p13 = new Produto(null, "Rottweiler", 0.00, 2, Sexo.Feminino, "Paulo Pereira");
		Produto p14 = new Produto(null, "Pincher", 0.00, 1, Sexo.Feminino, "Igor Lunatico");
		Produto p15 = new Produto(null, "Chow-Chow", 0.00, 2, Sexo.Masculino, "Davila Santos");
		Produto p16 = new Produto(null, "Boston Terrier", 0.00, 3, Sexo.Feminino, "Rodolfo Santos");
		Produto p17 = new Produto(null, "Yorkshire", 0.00, 4, Sexo.Masculino, "Jordan Fernandes");
		Produto p18 = new Produto(null, "Shih Tzu", 0.00, 4, Sexo.Feminino, "Ramon Souza");
		Produto p19 = new Produto(null, "Golden Retriever", 0.00, 5, Sexo.Masculino, "Paulo Santos");
		Produto p20 = new Produto(null, "Bulldogue Inglês", 0.00, 6, Sexo.Feminino, "Rodolfo Mendes");
		Produto p21 = new Produto(null, "Cocker Spaniel", 0.00, 6, Sexo.Masculino, "Garataia Samander");
		Produto p22 = new Produto(null, "Outras raças", 0.00, 7, Sexo.Feminino, "Bruna Medeiros");

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16,
				p17, p18, p19, p20, p21, p22));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat1));
		p6.getCategorias().addAll(Arrays.asList(cat1));
		p7.getCategorias().addAll(Arrays.asList(cat1));
		p8.getCategorias().addAll(Arrays.asList(cat1));
		p9.getCategorias().addAll(Arrays.asList(cat1));
		p10.getCategorias().addAll(Arrays.asList(cat1));
		p11.getCategorias().addAll(Arrays.asList(cat1));
		p12.getCategorias().addAll(Arrays.asList(cat1));
		p13.getCategorias().addAll(Arrays.asList(cat1));
		p14.getCategorias().addAll(Arrays.asList(cat1));
		p15.getCategorias().addAll(Arrays.asList(cat1));
		p16.getCategorias().addAll(Arrays.asList(cat1));
		p17.getCategorias().addAll(Arrays.asList(cat1));
		p18.getCategorias().addAll(Arrays.asList(cat1));
		p19.getCategorias().addAll(Arrays.asList(cat1));
		p20.getCategorias().addAll(Arrays.asList(cat1));
		p21.getCategorias().addAll(Arrays.asList(cat1));
		p22.getCategorias().addAll(Arrays.asList(cat1));

		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16,
				p17, p18, p19, p20, p21, p22));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli = new Cliente(null, "Maria Silva", "benisscosta@gmail.com", "58528130100", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli.getTelefones().addAll(Arrays.asList("33427712", "24906872"));

		Cliente cli2 = new Cliente(null, "Ana hah", "matheuslimat@gmail.com", "97332812045", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("33218598", "24905874"));
		cli2.addPerfil(Perfil.ADMIN);
		
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "108", null, "Centro", "58407125", cli2, c2);


		cli.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));


		clienteRepository.saveAll(Arrays.asList(cli, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli2, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
