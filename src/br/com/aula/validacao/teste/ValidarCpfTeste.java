package br.com.aula.validacao.teste;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.validacao.ValidarCpf;

public class ValidarCpfTeste {

	@Test
	public void removeCaracteres() throws Exception {
		String cpf = "004.456.282-94";
		String resultado = "00445628294";
		
		Class<?> cla = Class.forName("br.com.aula.validacao.teste.ValidarCpf");
		ValidarCpfTeste xx = (ValidarCpfTeste)cla.newInstance();
		xx.removeCaracteres();
		
		ValidarCpf validar = new ValidarCpf();
		validar.validarCPF(resultado);
		Method m = validar.getClass().getDeclaredMethod("removeCaracteres");
		
		
		
		m.setAccessible(true);
		m.invoke(validar);
		m.setAccessible(false);
		
		
	}
	

}