package br.sc.senac.returnit.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class WebServentRoute  extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	private ContatoDAO dao;

	public void init() {
		dao = new ContatoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String action = request.getServletPath();

		try {
				
		switch (action) {
				
		case "/novo":
			mostrarFormularioNovoContato(request, response);
		break;
					
		case "/inserir":
			inserirContato(request, response);
		break;
					
		case "/deletar":
			deletarContato(request, response);
		break;
					
		case "/editar":
			mostrarFormularioEditarContato(request, response);
		break;
					
		case "/atualizar":
			atualizarContato(request, response);
		break;
					
		default:
			listarContatos(request, response);
		break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}

	private void listarContatos(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
			
			List<Contato> contatos = dao.recuperarContatos();
			request.setAttribute("contatos", contatos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar-contato.jsp");
			dispatcher.forward(request, response);
		}

	private void mostrarFormularioNovoContato(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
			dispatcher.forward(request, response);
		}

	private void mostrarFormularioEditarContato(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			
		long id = Long.parseLong(request.getParameter("id"));
			Contato contato = dao.recuperarContato(new Contato(id));
			request.setAttribute("contato", contato);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
			dispatcher.forward(request, response);
		}

	private void inserirContato(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		dao.inserirContato(new Contato(telefone, email));
		response.sendRedirect("listar");
	}

	private void atualizarContato(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
		long id = Long.parseLong(request.getParameter("id"));
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		dao.atualizarContato(new Contato(id,telefone, email));
		response.sendRedirect("listar");
	}

	private void deletarContato(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = dao.recuperarContato(new Contato(id));
		dao.deletarContato(contato);
		response.sendRedirect("listar");
	}