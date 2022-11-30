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

import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.empresa.*;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;
import br.sc.senac.returnit.modelo.dao.empresa.*;
import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAOImpl;

@WebServlet("/")
public class WebServentRouteEmpresa  extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	private EmpresaDAO dao;

	public void init() {
		dao = new EmpresaDAOImp();
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
				
		case "/CadastrarEmpresa":
			mostrarFormularioNovoEmpresa(request, response);
		break;
					
		case "/inserirEmpresa":
			inserirEmpresa(request, response);
		break;
					
		case "/deletarEmpresa":
			deletarEmpresa(request, response);
		break;
					
		case "/editarEmpresa":
			mostrarFormularioEditarEmpresa(request, response);
		break;
					
		case "/logarEmpresa":
			logarEmpresa(request, response);
		break;
		case "/atualizarEmpresa":
			atualizarEmpresa(request, response);
		break;
					
		default:
			listarEmpresas(request, response);
		break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}

	private void listarEmpresas(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
			
			List<Empresa> empresas = dao.recuperarEmpresas();
			request.setAttribute("contatos", empresas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar-contato.jsp");
			dispatcher.forward(request, response);
		}

	private void mostrarFormularioNovoEmpresa(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
			dispatcher.forward(request, response);
		}

	private void mostrarFormularioEditarEmpresa(HttpServletRequest request, HttpServletResponse response)
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

	private void logarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		String nomeUsuario = request.getParameter("nome");
		Empresa empresa = dao.recuperarEmpresaIdUsuario(id);
		dao.deletarEmpresa(empresa);
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		Usuario usuario = usuarioDAO.recuperarNome(nomeUsuario);
		System.out.println(usuario);
		response.sendRedirect("listar");
	}
	
	private void deletarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
		long id = Long.parseLong(request.getParameter("id"));
		Empresa empresa = dao.recuperarEmpresaIdUsuario(id);
		dao.deletarEmpresa(empresa);
		response.sendRedirect("listar");
	}
	
	}