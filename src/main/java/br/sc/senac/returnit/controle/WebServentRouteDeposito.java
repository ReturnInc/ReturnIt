package br.sc.senac.returnit.controle;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sc.senac.returnit.modelo.dao.deposito.DepositoDAO;
import br.sc.senac.returnit.modelo.dao.deposito.DepositoDAOImp;

import br.sc.senac.returnit.modelo.entidade.deposito.Deposito;

@WebServlet("/Deposito")
public class WebServentRouteDeposito extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DepositoDAO dao;

	public void init() {
		dao = new DepositoDAOImp();
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
				
		case "/DepositoNovo":
			mostrarFormularioNovoDeposito(request, response);
		break;
					
		case "/DepositoInserir":
			inserirDeposito(request, response);
		break;
					
		case "/DepositoDeletar":
			deletarDeposito(request, response);
		break;
					
		case "/DepositoEditar":
			mostrarFormularioEditarDeposito(request, response);
		break;
					
		case "/DepositoAtualizar":
			atualizarDeposito(request, response);
		break;
					
		default:
			listarDepositos(request, response);
		break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}
	private void listarDepositos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				
				List<Deposito> depositos = dao.recuperarDepositos();
				request.setAttribute("Depositos", depositos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listar-deposito.jsp");
				dispatcher.forward(request, response);
			}

		private void mostrarFormularioNovoDeposito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-deposito.jsp");
				dispatcher.forward(request, response);
			}

		private void mostrarFormularioEditarDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
				Deposito deposito = dao.recuperarDepositoId(id);
				request.setAttribute("Deposito", deposito);
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-deposito.jsp");
				dispatcher.forward(request, response);
			}

		private void inserirDeposito(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
			String dataDepositoStr = request.getParameter("dataDeposito");
			String quantidadeDepositoStr = request.getParameter("quantidadeDeposito");
			String idRetornavelStr = request.getParameter("idRetornavel");
			
			Date dataDeposito = Date.valueOf(dataDepositoStr);
			Integer quantidadeDeposito = Integer.valueOf(quantidadeDepositoStr);
			Long idRetornavel = Long.valueOf(idRetornavelStr);
			dao.inserirDeposito(new Deposito((long) -1, dataDeposito, quantidadeDeposito, idRetornavel));
			response.sendRedirect("listar");
		}

		private void atualizarDeposito(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			String quantidadeDepositoStr = request.getParameter("quantidadeDeposito");
			String dataDepositoStr = request.getParameter("dataDeposito");
			String idRetornavelStr = request.getParameter("idRetornavel"); 
			
			Long idRetornavel = Long.valueOf(idRetornavelStr);
			Date dataDeposito = Date.valueOf(dataDepositoStr);
			Integer quantidadeDeposito = Integer.valueOf(quantidadeDepositoStr);
			Deposito deposito = dao.recuperarDepositoId(id);
			dao.atualizarDataDeposito(deposito, dataDeposito);
			dao.atualizarQuantidadeDeposito(deposito, quantidadeDeposito);
			dao.atualizarRetornavelDeposito(deposito, idRetornavel);
			response.sendRedirect("listar");
		}

		private void deletarDeposito(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			Deposito deposito = dao.recuperarDepositoId(id);
			dao.deletarDeposito(deposito);
			response.sendRedirect("listar");
		}
		
}
