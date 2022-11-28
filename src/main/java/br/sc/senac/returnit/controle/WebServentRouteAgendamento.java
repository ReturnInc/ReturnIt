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

import br.sc.senac.returnit.modelo.dao.agendamento.AgendamentoDAO;
import br.sc.senac.returnit.modelo.dao.agendamento.AgendamentoDAOImp;
import br.sc.senac.returnit.modelo.entidade.agendamento.Agendamento;

public class WebServentRouteAgendamento {

	private static final long serialVersionUID = 1L;
	private AgendamentoDAO dao;

	public void init() {
		dao = new AgendamentoDAOImp();
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
			listarEmpresas(request, response);
		break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}
	private void listarEmpresas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				
				List<Agendamento> empresas = dao.recuperarAgendamentos();
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
				Agendamento agendamento = dao.recuperarAgendamentoId(id);
				request.setAttribute("Agendamento", agendamento);
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
				dispatcher.forward(request, response);
			}

		private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			
			String realizadoAgendamentoStr = request.getParameter("realizadoAgendamento");
			String dataAgendamentoStr = request.getParameter("dataAgendamento");
			String idEmpresastr = request.getParameter("idEmpresa");
			String idCooperadoStr = request.getParameter("idCooperado");
			
			Boolean realizadoAgendamento = Boolean.valueOf(realizadoAgendamentoStr);
			Date dataAgendamento = Date.valueOf(dataAgendamentoStr);
			Long idEmpresa = Long.valueOf(idEmpresastr);
			Long idCooperado = Long.valueOf(idCooperadoStr);
			dao.inserirAgendamento(new Agendamento((long) -1,realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
			response.sendRedirect("listar");
		}

		private void atualizarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			String idCooperadoStr = request.getParameter("idCooperado");
			String idEmpresaStr = request.getParameter("idEmpresa");
			Long idCooperado = Long.valueOf(idCooperadoStr);
			Long idEmpresa = Long.valueOf(idEmpresaStr);
			String dataAgendamentoStr = request.getParameter("dataAgendamento");
			Date dataAgendamento = Date.valueOf(dataAgendamentoStr);
			Agendamento agendamento = dao.recuperarAgendamentoId(id);
			dao.atualizarIdCooperado(agendamento, idCooperado);
			dao.atualizarDataAgendamento(agendamento, dataAgendamento);
			dao.atualizarIdEmpresa(agendamento, idEmpresa);
			dao.atualizarRealizadoAgendamento(agendamento, false);
			response.sendRedirect("listar");
		}

		private void deletarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			Agendamento agendamento = dao.recuperarAgendamentoId(id);
			dao.deletarAgendamento(agendamento);
			response.sendRedirect("listar");
		}
		
}
