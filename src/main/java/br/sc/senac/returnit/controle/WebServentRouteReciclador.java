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

import br.sc.senac.returnit.modelo.dao.empresa.EmpresaDAO;
import br.sc.senac.returnit.modelo.dao.empresa.EmpresaDAOImp;
import br.sc.senac.returnit.modelo.dao.reciclador.RecicladorDAO;
import br.sc.senac.returnit.modelo.dao.reciclador.RecicladorDAOImpl;
import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.empresa.Empresa;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;

public class WebServentRouteReciclador extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RecicladorDAO dao;

	public void init() {
		dao = new RecicladorDAOImpl();
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
			inserirEmpresa(request, response);
		break;
					
		case "/deletar":
			deletarEmpresa(request, response);
		break;
					
		case "/editar":
			mostrarFormularioEditarContato(request, response);
		break;
					
		case "/atualizar":
			atualizarEmpresa(request, response);
		break;
					
		default:
			listarRecicladores(request, response);
		break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}
	private void listarRecicladores(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				
				List<Empresa> empresas = dao.recuperarRecicladores();
				request.setAttribute("contatos", empresas);
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
				Empresa empresa = dao.recuperarEmpresaIdUsuario(id);
				request.setAttribute("Empresa", empresa);
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
				dispatcher.forward(request, response);
			}

		private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			
			String cnpj = request.getParameter("cnpj");
			String nome = request.getParameter("nome");
			String telefoneContato = request.getParameter("telefone");
			String emailContato = request.getParameter("email");
			String numeroEnderecoStr = request.getParameter("numero");
			Short numeroEndereco = Short.valueOf(numeroEnderecoStr);
			String logradouroEndereco  = request.getParameter("logradouro");
			String complementoEndereco = request.getParameter("complemento");
			String bairroEndereco = request.getParameter("bairro");
			String senha = request.getParameter("senha");
			
			
			Contato contato = new Contato((long) -1, telefoneContato, emailContato);
			Endereco endereco = new Endereco((long) -1, numeroEndereco, logradouroEndereco, complementoEndereco, bairroEndereco);
			
			dao.inserirEmpresa(new Empresa((long) -1, (long) -1, nome, endereco, contato,  cnpj, senha));
			response.sendRedirect("listar");
		}

		private void atualizarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			String idUsuarioStr = request.getParameter("idUsuario");
			String cnpjEmpresa = request.getParameter("cnpjEmpresa");
			Long idUsuario = Long.valueOf(idUsuarioStr);
			Empresa empresa = dao.recuperarEmpresaIdUsuario(id);
			dao.atualizarCnpjEmpresa(empresa, cnpjEmpresa);
			dao.atualizarIdUsuario(empresa, idUsuario);
			response.sendRedirect("listar");
		}

		private void deletarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			Empresa empresa = dao.recuperarEmpresaIdUsuario(id);
			dao.deletarEmpresa(empresa);
			response.sendRedirect("listar");
		}
		
}
