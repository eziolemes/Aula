package br.com.aula.validacao.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.validacao.ValidarIdade;

public class ValidarIdadeTeste {

	@Test
	public void validarIdade() throws ParseException {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date nascimento = sdf.parse("06/10/1886");
		Boolean verificador = ValidarIdade.getIdade(nascimento);
		Assert.assertFalse(verificador);

		nascimento = sdf.parse("06/10/1990");
		verificador = ValidarIdade.getIdade(nascimento);
		Assert.assertTrue(verificador);

		
		nascimento = sdf.parse("06/10/2999");
		verificador = ValidarIdade.getIdade(nascimento);
		Assert.assertFalse(verificador);

	}

}