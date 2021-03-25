package br.com.aula.validacao;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidarIdade {
	public static Boolean getIdade(java.util.Date dataNasc) {

		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNasc);

		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		// se a data de hoje é antes da data de Nascimento, então diminui 1.
		if (today.before(dateOfBirth)) {
			age--;
		}

		System.out.println("Idade: " + age);

		if(age < 0 && age > 130)
			return false;
		
		
		return true;
	}
}