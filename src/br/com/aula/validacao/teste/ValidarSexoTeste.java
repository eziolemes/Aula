package br.com.aula.validacao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.validacao.ValidarSexo;

public class ValidarSexoTeste {

	@Test
	public void validarSexoTeste() {
		String sexo = "M";
		
		Boolean validacao = ValidarSexo.validarSexo(sexo);
		
		Assert.assertTrue(validacao);
				
	}

}