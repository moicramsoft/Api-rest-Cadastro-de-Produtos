package com.moicramsoft.cadastroDeProduto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moicramsoft.cadastroDeProduto.models.Produto;
import com.moicramsoft.cadastroDeProduto.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*Recebe requisições http*/
@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")/*informa que todos os dominios podem acessar esta API*/
public class ProdutoResource {
	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Lista Produtos")
	public List<Produto> listaProdutos() {

		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	@ApiOperation(value = "Lista Produto unico")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {

		return produtoRepository.findById(id);
	}
	@PostMapping("/produtos" )
	@ApiOperation(value = "Salva Produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		System.out.println("Salvou.....");
		return produtoRepository.save(produto);
	}
	@DeleteMapping("/produtos")
	@ApiOperation(value = "Deleta um Produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	@PutMapping("/produtos")
	@ApiOperation(value = "Atualiza um Produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
