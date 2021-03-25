package br.com.aula.validacao.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ValidarCpfTeste.class, ValidarEmailTeste.class, ValidarIdadeTeste.class, ValidarSexoTeste.class })
public class AllTests {

}
