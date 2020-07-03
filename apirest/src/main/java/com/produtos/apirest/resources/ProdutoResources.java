package com.produtos.apirest.resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRespository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produto")
@CrossOrigin(origins="*")
public class ProdutoResources {

	
	@Autowired
	ProdutoRespository produtorepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna lista de produtos")
	public List<Produto> listaProdutos(){
		return produtorepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna lista um unico produto")
	public Produto listaProdutosUnico(@PathVariable(value="id") long id){
		return produtorepository.findByid(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Salva produto")
	public Produto salvaProduto(@RequestBody Produto produto){
		return produtorepository.save(produto);
		
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta produto")
	public void deletaProduto(@RequestBody Produto produto){
		produtorepository.delete(produto);
	}

	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto){
		return produtorepository.save(produto);
		
	}
}
