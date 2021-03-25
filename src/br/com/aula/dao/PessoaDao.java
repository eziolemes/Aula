package br.com.aula.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.aula.bean.PessoaBean;
import br.com.aula.factory.ConnectionFactory;

public class PessoaDao {

	private static Connection conn;
	private static String pl = "\n";

	private PessoaDao(){
		try {
			conn = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void incluir(PessoaBean pessoa)throws SQLException{
		new PessoaDao();

		StringBuilder sql = new StringBuilder();
		sql.append("insert into pessoa(pes_nome,pes_cpf,pes_endereco,pes_nascimento,pes_telefone,");
		sql.append("pes_email,pes_sexo,pes_observacao)values(?,?,?,?,?,?,?,?)");

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getCpf());
		ps.setString(3, pessoa.getEndereco());
		
		java.sql.Date data = new java.sql.Date(pessoa.getNascimento().getTime());
		ps.setDate(4, data);
		
		ps.setString(5, pessoa.getTelefone());
		ps.setString(6, pessoa.getEmail());
		ps.setString(7, pessoa.getSexo());
		ps.setString(8, pessoa.getObservacao());

		ps.execute();

		ps.close();
		conn.close();
	}

	public static void alterar(PessoaBean pessoa) throws SQLException{
		new PessoaDao();

		StringBuilder sql = new StringBuilder();

		sql.append("update pessoa set pes_nome=?,pes_cpf=?,pes_endereco=?,pes_nascimento=?,pes_telefone=?,pes_email=?,pes_sexo=?,pes_observacao=? where pes_id=?");

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getCpf());
		ps.setString(3, pessoa.getEndereco());

		java.sql.Date data = new java.sql.Date(pessoa.getNascimento().getTime());
		ps.setDate(4, data);
		
		ps.setString(5, pessoa.getTelefone());
		ps.setString(6, pessoa.getEmail());
		ps.setString(7, pessoa.getSexo());
		ps.setString(8, pessoa.getObservacao());
		ps.setInt(9, pessoa.getId());

		ps.execute();

		ps.close();
		conn.close();
	}

	public static void excluir(Integer id) throws SQLException{
		new PessoaDao();

		StringBuilder sql = new StringBuilder();
		sql.append("delete from pessoa where pes_id=?");

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ps.setInt(1, id);

		ps.execute();
		ps.close();
		conn.close();
	}

	public static List<PessoaBean> getPessoas(String sql)throws SQLException{
		new PessoaDao();

		System.out.println(sql);
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<PessoaBean> lista = new ArrayList();
		
		while(rs.next()){
			PessoaBean pessoa = new PessoaBean();
			
			pessoa.setId(rs.getInt("pes_id"));
			pessoa.setNome(rs.getString("pes_nome"));
			pessoa.setCpf(rs.getString("pes_cpf"));
			pessoa.setEndereco(rs.getString("pes_endereco"));
			pessoa.setNascimento(rs.getDate("pes_nascimento"));
			pessoa.setTelefone(rs.getString("pes_telefone"));
			pessoa.setEmail(rs.getString("pes_email"));
			pessoa.setSexo(rs.getString("pes_sexo"));
			pessoa.setObservacao(rs.getString("pes_observacao"));
			
			lista.add(pessoa);
		}
		rs.close();
		ps.close();
		conn.close();
				
		return lista;
	}

	public static String selectPessoaPorId(Integer id) {
		StringBuilder sql = new StringBuilder();

		sql.append("select *" + pl);
		sql.append("from pessoa" + pl);
		sql.append("where pes_id = " + id + pl);
		sql.append("order by pes_nome" + pl);
		
		return sql.toString();
	}
	
	public static String selectPessoaPorNome(String nome) {
		StringBuilder sql = new StringBuilder();

		sql.append("select *" + pl);
		sql.append("from pessoa" + pl);
		sql.append("where pes_nome like '" + nome + "%'" +  pl);
		sql.append("order by pes_nome" + pl);
		
		return sql.toString();
	}
}