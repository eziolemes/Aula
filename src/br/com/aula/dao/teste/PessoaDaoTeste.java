package br.com.aula.dao.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.bean.PessoaBean;
import br.com.aula.dao.PessoaDao;

public class PessoaDaoTeste {
	
	public PessoaBean getPessoa(){
		
		PessoaBean pessoa = new PessoaBean();
		
		pessoa.setId(1);
		pessoa.setNome("Alana Casarotto");
		pessoa.setCpf("004.456.282-94");
		pessoa.setEndereco("Rua Jose Gildo, 17");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nascimento = new Date();
		try {
			nascimento = sdf.parse("1999-10-11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pessoa.setNascimento(nascimento);
		pessoa.setTelefone("69-99606-7434");
		pessoa.setEmail("alanacasarotto19@gmail.com");
		pessoa.setSexo("F");
		pessoa.setObservacao("Teste de update classe DAO");
		
		return pessoa;
	}
	

	@Test
	public void testaInsert() throws SQLException{
		PessoaBean pessoa = getPessoa();
		
		PessoaDao.incluir(pessoa);
		Assert.assertNotNull("Erro ao incluir registro!");
	}
	
	@Test
	public void testaUpdate() throws SQLException {
		PessoaBean pessoa = getPessoa();
		PessoaDao.alterar(pessoa);
		Assert.assertNotNull("Erro ao alterar registro!");
	}
	
	@Test
	public void testaSelect() throws SQLException {
		PessoaBean pessoa = getPessoa();
		
		List<PessoaBean> lista = PessoaDao.getPessoas(PessoaDao.selectPessoaPorNome(pessoa.getNome()));
		Assert.assertEquals(lista.get(0).getNome(), pessoa.getNome());
	}
	
	@Test
	public void testeDelete() throws SQLException{
		Integer id = 2;
		
		PessoaDao.excluir(id);
		
		Assert.assertNotNull("Erro ao executar exclusão!");
	}

}
