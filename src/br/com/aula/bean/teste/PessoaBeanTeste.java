package br.com.aula.bean.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.bean.PessoaBean;

public class PessoaBeanTeste {
	PessoaBean pessoa = new PessoaBean();

	@Test
	public void testaId() {
		pessoa.setId(5);
		
		int id = pessoa.getId();
		Assert.assertEquals(id ,  5);
	}
	
	@Test
	public void testaNome() {
		String nome = "Ezio";
		pessoa.setNome(nome);
		
		Assert.assertEquals(pessoa.getNome(), nome);
	}

	@Test
	public void setCpf() {
		String cpf = "004.456.282-94";
		pessoa.setCpf(cpf);
		
		Assert.assertEquals(pessoa.getCpf(), cpf);
	}
	
	@Test
	public void testaEndereco() {
		String endereco = "Rua X";
		pessoa.setEndereco(endereco);
		
		Assert.assertEquals(pessoa.getEndereco(), endereco);
	}
	
	@Test
	public void testaTelefone() {
		String telefone = "99606-5641";
		pessoa.setTelefone(telefone);
		
		Assert.assertEquals(pessoa.getTelefone(), telefone);
	}
	
	@Test
	public void testaEmail() {
		String email = "c@d.com";
		
		pessoa.setEmail(email);
		Assert.assertEquals(pessoa.getEmail(), email);
	}
	
	@Test
	public void testaSexo() {
		String sexo = "M";
		
		pessoa.setSexo(sexo);
		Assert.assertEquals(pessoa.getSexo(), sexo);
	}
	
	@Test
	public void testaObservacao() {
		String observacao = "Teste de Observação";
		pessoa.setObservacao(observacao);
		
		Assert.assertEquals(pessoa.getObservacao(), observacao);
	}
	
	@Test
	public void testaNascimento() {
		   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		   Date data = null;
		try {
			data = sdf.parse("06/04/1987");
		} catch (ParseException e) {
			System.out.println("Erro ao definir data.");
			e.printStackTrace();
		}
		
		pessoa.setNascimento(data);
		
		Assert.assertEquals(pessoa.getNascimento(), data);
//		Assert.assertNotNull("Nenhuma data válida foi informada!", pessoa.getNascimento());
	}
}