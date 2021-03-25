package br.com.aula.validacao.teste;

import org.junit.Assert;
import org.junit.Test;
import br.com.aula.validacao.ValidarEmail;

public class ValidarEmailTeste {

	@Test
	public void validarEmailTeste() {
		String email = "ezio@gmail";
		
		Boolean verificador = ValidarEmail.validEmail(email);
		Assert.assertTrue(verificador);
	}
}