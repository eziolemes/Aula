package br.com.aula.bean;

import java.util.Date;
import br.com.aula.validacao.ValidarCpf;
import br.com.aula.validacao.ValidarEmail;
import br.com.aula.validacao.ValidarIdade;
import br.com.aula.validacao.ValidarSexo;

public class PessoaBean {
	private Integer id;
	private String nome,cpf,endereco,telefone,email,sexo,observacao;
	private Date nascimento;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id != null) this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(!cpf.isEmpty()){
			if(ValidarCpf.validarCPF(cpf)) this.cpf = cpf;
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(!email.isEmpty()){
			if( ValidarEmail.validEmail(email) ) this.email = email;
		}
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		Boolean verificador = ValidarSexo.validarSexo(sexo);
		
		if(verificador) this.sexo = sexo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		Boolean verificador = ValidarIdade.getIdade(nascimento);
		
		if(verificador) this.nascimento = nascimento;
	}
}