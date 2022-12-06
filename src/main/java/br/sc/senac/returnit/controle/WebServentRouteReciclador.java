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

import br.sc.senac.returnit.modelo.dao.reciclador.RecicladorDAO;
import br.sc.senac.returnit.modelo.dao.reciclador.RecicladorDAOImpl;
import br.sc.senac.returnit.modelo.dao.recicladorDeposito.RecicladorDepositoDAO;
import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAO;
import br.sc.senac.returnit.modelo.entidade.RecicladorDeposito.RecicladorDeposito;
import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.reciclador.Reciclador;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;

@WebServlet("/Reciclador")
public class WebServentRouteReciclador extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RecicladorDAO dao;
	private UsuarioDAO usuarioDAO;
	private RecicladorDepositoDAO recicladorDepositoDAO;

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
				
		case "/RecicladorNovo":
			mostrarFormularioNovoReciclador(request, response);
		break;
					
		case "/RecicladorInserir":
			inserirReciclador(request, response);
			inserirAgendamentoRetornavel(request, response);
		break;
					
		case "/RecicladorDeletar":
			deletarReciclador(request, response);
		break;
					
		case "/RecicladorEditar":
			mostrarFormularioEditarReciclador(request, response);
		break;
		
		case "/RecicladorLogar":
			logarReciclador(request, response);
		break;
					
		case "/RecicladorAtualizar":
			atualizarReciclador(request, response);
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
				
				List<Reciclador> recicladores = dao.recuperarRecicladores();
				List<RecicladorDeposito> recicladorDeposito = null;
				for(Reciclador reciclador:recicladores) {
					long idReciclador = reciclador.getIdReciclador();
					recicladorDeposito = recicladorDepositoDAO.recuperarDepositosIdReciclador(idReciclador);
					request.setAttribute("Reciclador", reciclador);
					request.setAttribute("RecicladorDeposito", recicladorDeposito);
				}
				
		
				RequestDispatcher dispatcher = request.getRequestDispatcher("listar-reciclador.jsp");
				dispatcher.forward(request, response);
			}

		private void mostrarFormularioNovoReciclador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-reciclador.jsp");
				dispatcher.forward(request, response);
			}

		private void mostrarFormularioEditarReciclador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
				
				String CPF = request.getParameter("CPF");
				Reciclador reciclador = dao.recuperarRecicladorCPF(CPF);
				request.setAttribute("reciclador", reciclador);
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-reciclador.jsp");
				dispatcher.forward(request, response);
			}

		private void inserirReciclador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			
			String cpfReciclador = request.getParameter("cpf");
			String nome = request.getParameter("nome");
			String generoReciclador = request.getParameter("nome");
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
			
			dao.inserirReciclador(new Reciclador((long) -1, (long) -1,cpfReciclador, generoReciclador,  nome , endereco, contato, senha));
			response.sendRedirect("listar");
		}

		private void atualizarReciclador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			String CPF = request.getParameter("id");
			String idUsuarioStr = request.getParameter("idUsuario");
			String cpfReciclador = request.getParameter("cpfReciclador");
			String generoReciclador = request.getParameter("generoReciclador");
			Long idUsuario = Long.valueOf(idUsuarioStr);
			Reciclador reciclador = dao.recuperarRecicladorCPF(CPF);
			dao.atualizarCpfReciclador(reciclador, cpfReciclador);
			dao.atualizarGenero(reciclador, generoReciclador);
			dao.atualizarIdUsuario(reciclador, idUsuario);
			response.sendRedirect("listar");
		}
		private void logarReciclador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
			
			String nomeUsuario = request.getParameter("nome");
			Usuario usuario = usuarioDAO.recuperarNome(nomeUsuario);
			long id = usuario.getId();
			Reciclador reciclador = dao.recuperarRecicladorIdUsuario(id);
			request.setAttribute("Reciclador", reciclador);
			RequestDispatcher dispatcher = request.getRequestDispatcher("reciclador.jsp");
			dispatcher.forward(request, response);
		}
		private void inserirAgendamentoRetornavel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
        	String idRecicladorStr = request.getParameter("idCooperado");
			String idDepositoStr = request.getParameter("idEmpresa");
			
			Long idReciclador = Long.valueOf(idRecicladorStr);
			Long idDeposito = Long.valueOf(idDepositoStr);
			recicladorDepositoDAO.inserirRecicladorDeposito(new RecicladorDeposito( idReciclador, idDeposito));
			response.sendRedirect("listar");
		}

		private void deletarReciclador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			String CPF = request.getParameter("id");
			Reciclador reciclador = dao.recuperarRecicladorCPF(CPF);
			dao.deletarReciclador(reciclador);
			response.sendRedirect("listar");
		}
		
}
