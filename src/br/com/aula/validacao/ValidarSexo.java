package br.com.aula.validacao;

public class ValidarSexo {

	public static Boolean validarSexo(String sexo) {
		if(sexo.equals("M") || sexo.equals("F"))
			return true;
			return false;
	}
}