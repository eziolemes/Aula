package br.com.aula.factory.teste;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

import br.com.aula.factory.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		Assert.assertNotNull("Conexão esta nula", conn);
	}

}