package br.com.aula.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.bean.PessoaBean;
import br.com.aula.dao.PessoaDao;
import br.com.aula.view.CriarHtmlPadrao;
import br.com.aula.view.CriarHtmlPessoa;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/PessoaServlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String pl = "\n";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = "listar";
		
		if(request.getParameter("acao") != null){
			acao = request.getParameter("acao");
		}
		
		
		if(acao.equals("novo")){
			criarFormCadastroPessoa(request, response);
		}else if(acao.equals("listar")){
			criarListaPessoa(request, response);
		}else if(acao.equals("gravar")){
			gravarPessoa(request, response);
		}else if(acao.equals("editar")){
			criarFormEditarPessoa(request, response);
		}
		
	}
	
	private void criarFormEditarPessoa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		
	}
	
	private void gravarPessoa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String nascimento = request.getParameter("nascimento");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String sexo = request.getParameter("sexo");
		String obs = request.getParameter("obs");
		
		PessoaBean pessoa = new PessoaBean();
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		try {
			pessoa.setNascimento(sdf.parse(nascimento));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pessoa.setEndereco(endereco);
		pessoa.setEmail(email);
		pessoa.setTelefone(telefone);
		pessoa.setSexo(sexo);
		pessoa.setObservacao(obs);
		
		try {
			PessoaDao.incluir(pessoa);
			response.sendRedirect("PessoaServlet?alerta=ok");
		} catch (SQLException e) {
			System.out.println("Deu pau");
			response.sendRedirect("javascript:history.go(-1)");  
//			response.sendRedirect("PessoaServlet?alerta=erro");
			e.printStackTrace();
		}
		
	}
	
	private void criarListaPessoa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		StringBuilder sb = new StringBuilder();
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String alerta = request.getParameter("alerta");
		
		if(nome ==  null) nome = "";
		if(alerta == null) alerta = "";
		
		System.out.println("var nome: " + nome);
		List<PessoaBean> lista = new ArrayList();
		
		try {
			lista = PessoaDao.getPessoas(PessoaDao.selectPessoaPorNome(nome));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sb.append( CriarHtmlPadrao.criarHtmlTopo() + pl);
		sb.append( CriarHtmlPessoa.criarHtmlListaPessoa(lista) + pl);
		if(alerta.equals("ok")){


			sb.append("<SCRIPT LANGUAGE=\"JavaScript\" TYPE=\"text/javascript\">" + pl);
			sb.append("  window.alert(\"Pessoa cadastrada com Sucesso!\");" + pl);
			sb.append("</SCRIPT>" + pl);
		}else if(alerta.equals("erro")){


			sb.append("<SCRIPT LANGUAGE=\"JavaScript\" TYPE=\"text/javascript\">" + pl);
			sb.append("  window.alert(\"Erro!\");" + pl);
			sb.append("</SCRIPT>" + pl);
		}
		sb.append( CriarHtmlPadrao.criarHtmlRodape());
		
		out.print(sb.toString());
	}
	
	private void criarFormCadastroPessoa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		StringBuilder sb = new StringBuilder();
		PrintWriter out = response.getWriter();
		
		sb.append( CriarHtmlPadrao.criarHtmlTopo() + pl);
		sb.append( CriarHtmlPessoa.criarHtmlFormularioCadastro() + pl);
		sb.append( CriarHtmlPadrao.criarHtmlRodape());
		
		out.print(sb.toString());
	}
}
