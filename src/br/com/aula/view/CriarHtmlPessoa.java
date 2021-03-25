package br.com.aula.view;

import java.util.List;

import br.com.aula.bean.PessoaBean;

public class CriarHtmlPessoa {
	private static String pl = "\n";

	public static String criarHtmlListaPessoa(List<PessoaBean> lista){
		StringBuilder sb = new StringBuilder();

		sb.append("<form method=\"post\" action=\"PessoaServlet\">" + pl);
		sb.append("  <input type=\"hidden\" name=\"acao\" value=\"listar\">" + pl);
		sb.append("<div class=\"form-horizontal\">" + pl);
		sb.append("    <legend>Pesquisar Pessoa</legend>" + pl);
		sb.append("    <div class=\"row\">" + pl);
		sb.append("		  <div class=\"col-xs-10\">" + pl);
		sb.append("			<label for=\"nome\" class=\"control-label text-right col-xs-1\">Nome:</label>" + pl);
		sb.append("			<div class=\"input-group col-xs-11\">" + pl);
		sb.append("				<input type=\"text\" name=\"nome\" class=\"form-control\" id=\"nome\">" + pl);
		sb.append("		    </div>" + pl);
		sb.append("		  </div>" + pl);
		sb.append("		<div class=\"col-xs-2\">" + pl);
		sb.append("			<button type=\"submit\" class=\"btn btn-success col-xs-7\">Pesquisar</button>" + pl);
		sb.append("</div>" + pl);
		sb.append("</form>" + pl);
		sb.append("<br />" + pl);

		sb.append("<table class=\"table table-striped table-bordered table-condensed table-hover\">" + pl);
		sb.append("  <thead>" + pl);
		sb.append("      <th>Código</th>" + pl);
		sb.append("      <th>Nome</th>" + pl);
		sb.append("      <th>CPF</th>" + pl);
		sb.append("      <th>Endereço</th>" + pl);
		sb.append("      <th>E-mail</th>" + pl);
		sb.append("      <th>Telefone</th>" + pl);
		sb.append("      <th>Data Nascimento</th>" + pl);
		sb.append("      <th>Sexo</th>" + pl);
		sb.append("      <th>Ações</th>" + pl);
		sb.append("  </thead>" + pl);
		sb.append("  <tbody>" + pl);

		for(PessoaBean pessoa : lista){
			sb.append("      <tr>" + pl);
			sb.append("        <td>" + pessoa.getId() + "</td>" + pl);
			sb.append("        <td>" + pessoa.getNome() + "</td>" + pl);
			sb.append("        <td>" + pessoa.getCpf() + "</td>" + pl);
			sb.append("        <td>" + pessoa.getEndereco() + "</td>" + pl);
			sb.append("        <td>" + pessoa.getEmail() + "</td>" + pl);
			sb.append("        <td>" + pessoa.getTelefone() + "</td>" + pl);
			sb.append("        <td>" + pessoa.getNascimento() + "</td>" + pl);
			sb.append("        <td>" + pessoa.getSexo() + "</td>" + pl);
			sb.append("        <td><a href=\"PessoaServlet?acao=editar&id=" + pessoa.getId() + "\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span></a><a href=\"PessoaServlet?acao=excluir&id=" + pessoa.getId() + "\"><span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span></a></td>" + pl);
			sb.append("    </tr>" + pl);
		}

		sb.append("  </tbody>" + pl);
		sb.append("</table>" + pl);

		return sb.toString();
	}

	public static String criarHtmlFormularioCadastro(){
		StringBuilder sb = new StringBuilder();

		sb.append("    <div class=\"row\">" + pl);
		sb.append("      <div class=\"col-xs-12\">" + pl);
		sb.append("	<div class=\"well\">" + pl);
		sb.append("	<h3>Cadastro de Pessoa</h3>" + pl);

		sb.append("<form method=\"post\" action=\"PessoaServlet\">" + pl);
		sb.append("  <input type=\"hidden\" name=\"acao\" value=\"gravar\">" + pl);

		sb.append("	 <div class=\"row\">" + pl);
		sb.append("    <div class=\"form-group col-xs-12\">" + pl);
		sb.append("     <label for=\"nome\">Nome</label>" + pl);
		sb.append("     <input type=\"text\" class=\"form-control\" name=\"nome\" required>" + pl);
		sb.append("    </div>" + pl);

		sb.append("    <div class=\"form-group col-md-6\">" + pl);
		sb.append("        <label for=\"cpf\">CPF</label>" + pl);
		sb.append("        <input type=\"text\" class=\"form-control\" name=\"cpf\" required>" + pl);
		sb.append("    </div>" + pl);

		sb.append("    <div class=\"form-group col-md-6\">" + pl);
		sb.append("        <label for=\"nascimento\">Data de Nascimento</label>" + pl);
		sb.append("        <input type=\"date\" class=\"form-control\" name=\"nascimento\" required>" + pl);
		sb.append("    </div>" + pl);

		sb.append("  <div class=\"form-group col-md-12\">" + pl);
		sb.append("      <label for=\"endereco\">Endereço</label>" + pl);
		sb.append("      <input type=\"text\" class=\"form-control\" name=\"endereco\" >" + pl);
		sb.append("  </div>" + pl);

		sb.append("    <div class=\"form-group col-md-4\">" + pl);
		sb.append("      <label for=\"email\">E-mail</label>" + pl);
		sb.append("      <input type=\"email\" class=\"form-control\" name=\"email\" required>" + pl);
		sb.append("    </div>" + pl);
		sb.append("    <div class=\"form-group col-md-4\">" + pl);
		sb.append("      <label for=\"telefone\">Telefone</label>" + pl);
		sb.append("      <input type=\"text\" class=\"form-control\" name=\"telefone\" required>" + pl);
		sb.append("    </div>" + pl);
		sb.append("    <div class=\"form-group col-md-4\">" + pl);
		sb.append("      <label for=\"sexo\">Sexo</label>" + pl);
		sb.append("      <select name=\"sexo\" class=\"form-control\">" + pl);
		sb.append("      <option value=\"M\">Masculino</option>" + pl);
		sb.append("      <option value=\"F\">Feminino</option>" + pl);
		sb.append("      </select>" + pl);
		sb.append("    </div>" + pl);

		sb.append("  <div class=\"form-group col-md-12\">" + pl);
		sb.append("     <label for=\"obs\">Observação</label>" + pl);
		sb.append("     <textarea class=\"form-control\" name=\"obs\"></textarea>" + pl);
		sb.append("  </div>" + pl);
		sb.append("  </div>" + pl);
		sb.append("<input class=\"btn btn-success\" type=\"submit\" value=\"Gravar\">" + pl);
		sb.append("<input class=\"btn btn-danger\" type=\"reset\" value=\"Limpar\">" + pl);
		sb.append("</form>" + pl);
		sb.append("</div>" + pl);
		sb.append("</div>" + pl);
		sb.append("</div>" + pl);

		return sb.toString();
	}
}