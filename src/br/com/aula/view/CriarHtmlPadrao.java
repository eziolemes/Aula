package br.com.aula.view;

public class CriarHtmlPadrao {

	private static String pl = "\n";

	public static String criarHtmlTopo(){
		StringBuilder sb = new StringBuilder();

		sb.append("<html>" + pl);
		sb.append("<head>" + pl);
		sb.append("  <title>Cadastrar</title>" + pl);
		sb.append("<link href=\"bootstrap/css/bootstrap.min.css\" type=\"text/css\" rel=\"stylesheet\">" + pl);
		sb.append("<link href=\"bootstrap/css/bootstrap.min.css\" type=\"text/css\" rel=\"stylesheet\">" + pl);
		sb.append("</head>" + pl);
		sb.append("<body>" + pl);
		sb.append("<nav class=\"navbar navbar-inverse\">" + pl);
		sb.append("  <div class=\"container\">" + pl);
		sb.append("    <div class=\"navbar-header\">" + pl);
		sb.append("      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#\" aria-expanded=\"false\" aria-controls=\"navbar\">" + pl);
		sb.append("        <span class=\"sr-only\">Toogle navigation</span>" + pl);
		sb.append("        <span class=\"icon-bar\"></span>" + pl);
		sb.append("        <span class=\"icon-bar\"></span>" + pl);
		sb.append("        <span class=\"icon-bar\"></span>" + pl);
		sb.append("      </button>" + pl);
		sb.append("      <a class=\"navbar-brand\" href=\"#\">Unesc</a>" + pl);
		sb.append("    </div>" + pl);
		sb.append("    <div id=\"navbar\" class=\"collapse navbar-collapse\">" + pl);
		sb.append("      <ul class=\"nav navbar-nav\">" + pl);
		sb.append("        <li class=\"active\"><a href=\"PessoaServlet\">Listar</a></li>" + pl);
		sb.append("        <li><a href=\"PessoaServlet?acao=novo\">Cadastrar</a></li>" + pl);
		sb.append("      </ul>" + pl);
		sb.append("    </div>" + pl);
		sb.append("  </div>" + pl);
		sb.append("</nav>" + pl);
		sb.append("<div class=\"container\">" + pl);

		return sb.toString();
	}

	public static String criarHtmlRodape(){
		StringBuilder sb = new StringBuilder();

		sb.append("<div id=\"rodape\">" + pl);
		sb.append("    <small>Unesc - 2018. Todos os direitos reservados</small>" + pl);
		sb.append("</div>" + pl);
		sb.append("</div>" + pl);
		sb.append("</body>" + pl);

		return sb.toString();
	}
}