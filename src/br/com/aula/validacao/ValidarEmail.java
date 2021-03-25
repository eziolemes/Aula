package br.com.aula.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarEmail {

	public static boolean validEmail(String email) {
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		Matcher m = p.matcher(email); 
		if (m.find()){
			return true;
		}

		return false;
	}
}