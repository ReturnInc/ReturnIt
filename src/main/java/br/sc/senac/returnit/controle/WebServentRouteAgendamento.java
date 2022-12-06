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
import br.sc.senac.returnit.modelo.dao.agendamentoRetornavel.AgendamentoRetornavelDAO;
import br.sc.senac.returnit.modelo.dao.empresa.EmpresaDAO;
import br.sc.senac.returnit.modelo.entidade.agendamento.Agendamento;
import br.sc.senac.returnit.modelo.entidade.agendamentoRetornavel.AgendamentoRetornavel;
import br.sc.senac.returnit.modelo.entidade.empresa.Empresa;

@WebServlet("/Agendamento")
public class WebServentRouteAgendamento extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AgendamentoDAO dao;
	private EmpresaDAO empresaDao;
	private AgendamentoRetornavelDAO agendamentoRetornavelDAO;
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
				
		case "/AgendamentoNovo":
			mostrarFormularioNovoAgendamento(request, response);
		break;
					
		case "/AgendamentoInserir":
			inserirAgendamento(request, response);
			inserirAgendamentoRetornavel(request, response);
		break;
					
		case "/AgendamentoDeletar":
			deletarAgendamento(request, response);
		break;
					
		case "/AgendamentoEditar":
			mostrarFormularioEditarAgendamento(request, response);
		break;
					
		case "/AgendamentoAtualizar":
			atualizarAgendamento(request, response);
		break;
		
		default:
			listarAgendamentos(request, response);
		break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}
	private void listarAgendamentos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				if (request.getParameter("cnpj") != "" ) {
					if(request.getParameter("data") != "") {
						Empresa empresa = empresaDao.recuperarCnpjEmpresa(request.getParameter("cnpj"));
						long id = empresa.getId();
						List<Agendamento> agendamentos = dao.recuperarAgendamentoIdEmpresaDataAtual(id);
						request.setAttribute("contatos", agendamentos);
						RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
						dispatcher.forward(request, response);
					}
					else if(request.getParameter("realisado") != "" ) {
						if(request.getParameter("periodo") != "") {
							Empresa empresa = empresaDao.recuperarCnpjEmpresa(request.getParameter("cnpj"));
							boolean realizado = Boolean.parseBoolean(request.getParameter("realizado")); 
							Date dataInicio = Date.valueOf(request.getParameter("dataInicio"));
							Date dataFim = Date.valueOf(request.getParameter("dataFim"));
							long id = empresa.getId();
							List<Agendamento> agendamentos = dao.recuperarAgendamentoIdEmpresaRealizadoPeriodo(id, realizado, dataInicio, dataFim);
							request.setAttribute("contatos", agendamentos);
							RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
							dispatcher.forward(request, response);
							
						}
						else {
							Empresa empresa = empresaDao.recuperarCnpjEmpresa(request.getParameter("cnpj"));
							long id = empresa.getId();
							List<Agendamento> agendamentos = dao.recuperarAgendamentoIdEmpresaDataAtual(id);
							request.setAttribute("contatos", agendamentos);
							RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
							dispatcher.forward(request, response);
						}
					}
					else if(request.getParameter("periodo") != "") {
						Empresa empresa = empresaDao.recuperarCnpjEmpresa(request.getParameter("cnpj"));
						Date dataInicio = Date.valueOf(request.getParameter("dataInicio"));
						Date dataFim = Date.valueOf(request.getParameter("dataFim"));
						long id = empresa.getId();
						List<Agendamento> agendamentos = dao.recuperarAgendamentoIdEmpresaPeriodo(id, dataInicio, dataFim);
						request.setAttribute("contatos", agendamentos);
						RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
						dispatcher.forward(request, response);
					}
				}
				else if(request.getParameter("realisado") != "" ) {
					if(request.getParameter("periodo") != "") {
						boolean realizado = Boolean.parseBoolean(request.getParameter("realizado"));
						Date dataInicio = Date.valueOf(request.getParameter("dataInicio"));
						Date dataFim = Date.valueOf(request.getParameter("dataFim"));
						List<Agendamento> agendamentos = dao.recuperarAgendamentoRealizadosPeriodo(realizado, dataInicio, dataFim);
						request.setAttribute("contatos", agendamentos);
						RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
						dispatcher.forward(request, response);
					}
					else {
						boolean realizado = Boolean.parseBoolean(request.getParameter("realizado"));
						List<Agendamento> agendamentos = dao.recuperarAgendamentoRealizados(realizado);
						request.setAttribute("contatos", agendamentos);
						RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
						dispatcher.forward(request, response);
					}
					
					
				}
				else if(request.getParameter("periodo") != "") {
					Date dataInicio = Date.valueOf(request.getParameter("dataInicio"));
					Date dataFim = Date.valueOf(request.getParameter("dataFim"));
					List<Agendamento> agendamentos = dao.recuperarAgendamentoPeriodo(dataInicio, dataFim);
					request.setAttribute("contatos", agendamentos);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
					dispatcher.forward(request, response);
				}
				else if(request.getParameter("data") != "") {
				List<Agendamento> agendamentos = dao.recuperarAgendamentoDataAtual();
				request.setAttribute("contatos", agendamentos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
				dispatcher.forward(request, response);
			}
				else {
					List<Agendamento> agendamentos = dao.recuperarAgendamentos();
					request.setAttribute("contatos", agendamentos);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listar-agendamento.jsp");
					dispatcher.forward(request, response);
				}
			
				}

		private void mostrarFormularioNovoAgendamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-agendamento.jsp");
				dispatcher.forward(request, response);
			}

		private void mostrarFormularioEditarAgendamento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
				Agendamento agendamento = dao.recuperarAgendamentoId(id);
				request.setAttribute("Agendamento", agendamento);
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-agendamento.jsp");
				dispatcher.forward(request, response);
			}

		private void inserirAgendamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			
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
        private void inserirAgendamentoRetornavel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
        	int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        	String idRetornavelStr = request.getParameter("idCooperado");
			String idAgendamentostr = request.getParameter("idEmpresa");
			
			 
			
			Long idAgendamento = Long.valueOf(idAgendamentostr);
			Long idRetornavel = Long.valueOf(idRetornavelStr);
			agendamentoRetornavelDAO.inserirAgendamentoRetornavel(new AgendamentoRetornavel(quantidade, idRetornavel, idAgendamento));
			response.sendRedirect("listar");
		}
		private void atualizarAgendamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
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

		private void deletarAgendamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			Agendamento agendamento = dao.recuperarAgendamentoId(id);
			dao.deletarAgendamento(agendamento);
			response.sendRedirect("listar");
		}
		
}
