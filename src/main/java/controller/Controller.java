package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/login", "/editar", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans usuario = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/login")) {
			novoUsuario(request, response);
		} else if (action.equals("/insert")) {
			inserirNovoUsuario(request, response);
		} else if (action.equals("/editar")) {
			listarUsuario(request, response);
		} else if (action.equals("/update")) {
			editarUsuario(request, response);
		} else if (action.equals("/delete")) {
			removerUsuario(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("Index.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("txt/html");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		usuario.setEmail(email);
		usuario.setSenha(senha);

		try {

			if (dao.validar(usuario)) {
				response.sendRedirect("telaPrincipal.jsp");
			} else {

				request.setAttribute("erro", "E-mail ou senha incoretos");

				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Listar contatos = Ir para a tela de login
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarUsuarios();
		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listarUsuarios.jsp");
		rd.forward(request, response);

	}

	// Novo Usuario = Ir para a tela de login
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setar a variáveis JavaBeans
		usuario.setNome(request.getParameter("nome"));
		usuario.setFone(request.getParameter("fone"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		dao.inserirUsuario(usuario);
		response.sendRedirect("login.jsp");

	}

	protected void inserirNovoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setar a variáveis JavaBeans
		usuario.setNome(request.getParameter("nome"));
		usuario.setFone(request.getParameter("fone"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		dao.inserirUsuario(usuario);

		response.sendRedirect("listarUsuarios.jsp");

	}

	// Editar Tarefa

	protected void listarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idusu = request.getParameter("idusu");
		usuario.setIdusu(idusu);

		dao.selecionarUsuario(usuario);

		request.setAttribute("idusu", usuario.getIdusu());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("fone", usuario.getFone());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("senha", usuario.getSenha());

		RequestDispatcher rd = request.getRequestDispatcher("editarUsuario.jsp");
		rd.forward(request, response);

	}

	protected void editarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar variaveis JavaBeans
		usuario.setIdusu(request.getParameter("idusu"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setFone(request.getParameter("fone"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));

		dao.alterarUsuario(usuario);
		response.sendRedirect("main");

	}

	// Remover Usuario
	protected void removerUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idusu = request.getParameter("idusu");
		usuario.setIdusu(idusu);
		dao.deletarUsuario(usuario);
		response.sendRedirect("main");
	}

	// Gerar Relatório em PDF

	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Tipo do Conteudo
			response.setContentType("aplication/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			// criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento -> conteudo
			documento.open();
			documento.add(new Paragraph("Lista de Tarefas"));
			documento.add(new Paragraph(" "));
			// criar uma tabela
			PdfPTable tabela = new PdfPTable(3);
			// cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
			// PdfPCell col4 = new PdfPCell(new Paragraph("Senha"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			// tabela.addCell(col4);

			// Popular a tabela lista com os Usuários
			ArrayList<JavaBeans> lista = dao.listarUsuarios();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());
				// tabela.addCell(lista.get(i).getSenha());

			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}
}
