package br.com.aula.validacao;

public class ValidarCpf {

//	private String cpf;
	
	private static String removeCaracteres(String cpf) {
		cpf = cpf.replace("-", "");
		cpf = cpf.replace(".", "");
		
		return cpf;
	}
	
	private static Boolean verificaTamanhoInvalido(String cpf) {
		if( cpf.length() != 11)
			return true;
			return false;
	}
	
	private static Boolean verificaDigIguais(String cpf) {
		char primDig = '0';
		char[] charCpf = cpf.toCharArray();
		for(char c: charCpf) 
			if(c != primDig)
				return false;
				return true;
	}
	
	private static String calculoComCpf(String cpf) {
		int digGerado = 0;
		int mult = cpf.length() + 1;
		char[] charCpf = cpf.toCharArray();
		for(int i=0;i < cpf.length(); i++)
			digGerado += (charCpf[i] - 48) * mult--;
		if(digGerado % 11 < 2)
			digGerado = 0;
		else
			digGerado = 11 - digGerado % 11;
		return String.valueOf(digGerado);
	}
	
	public static Boolean validarCPF(String cpf) {
		if(cpf == null) {
			return false;
		}else{
			String cpfGerado = "";
//			this.cpf = cpf;
			
			cpf = removeCaracteres(cpf);
			
			if(verificaTamanhoInvalido(cpf))
				return false;
			
			if(verificaDigIguais(cpf))
				return false;
			
			cpfGerado = cpf.substring(0, 9);
			cpfGerado = cpfGerado.concat(calculoComCpf(cpfGerado));
			cpfGerado = cpfGerado.concat(calculoComCpf(cpfGerado));
			
			if(!cpfGerado.equals(cpf))
				return false;
		}
		return true;
	}
}