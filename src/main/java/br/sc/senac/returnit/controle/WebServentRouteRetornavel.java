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


import br.sc.senac.returnit.modelo.dao.retornavel.RetornavelDAO;
import br.sc.senac.returnit.modelo.dao.retornavel.RetornavelDAOImp;
import br.sc.senac.returnit.modelo.entidade.retornavel.Retornavel;

@WebServlet("/Retornavel")
public class WebServentRouteRetornavel extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RetornavelDAO dao;

	public void init() {
		dao = new RetornavelDAOImp();
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
			deletarRetornavel(request, response);
		break;
					
		case "/editar":
			mostrarFormularioEditarContato(request, response);
		break;
					
		case "/atualizar":
			atualizarRetornavel(request, response);
		break;
					
		default:
			listarRetornaveis(request, response);
		break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		}
	private void listarRetornaveis(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				
				List<Retornavel> empresas = dao.recuperarRetornaveis();
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
				Retornavel retornavel = dao.recuperarRetornavelId(id);
				request.setAttribute("Retornavel", retornavel);
				RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
				dispatcher.forward(request, response);
			}

		private void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			
			String material = request.getParameter("cnpj");
			String marca = request.getParameter("nome");
			String modelo = request.getParameter("telefone");
			String cnpjEmpresa = request.getParameter("email");
			
			dao.inserirRetornavel(new Retornavel((long) -1, material, marca, modelo, cnpjEmpresa));
			response.sendRedirect("listar");
		}

		private void atualizarRetornavel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {				
			
			long id = Long.parseLong(request.getParameter("id"));
			String cnpjEmpresa = request.getParameter("cnpjEmpresa");
			String material = request.getParameter("material");
			String marcaRetornavel = request.getParameter("material");
			String modeloRetornavel = request.getParameter("material");
			Retornavel retornavel = dao.recuperarRetornavelId(id);
			dao.atualizarMaterial(retornavel, material);
			dao.atualizarCnpjEmpresa(retornavel, cnpjEmpresa);
			dao.atualizarMarcaRetornavel(retornavel, marcaRetornavel);
			dao.atualizarModeloRetornavel(retornavel, modeloRetornavel);
			response.sendRedirect("listar");
		}

		private void deletarRetornavel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				
			long id = Long.parseLong(request.getParameter("id"));
			Retornavel retornavel = dao.recuperarRetornavelId(id);
			dao.deletarRetornavel(retornavel);
			response.sendRedirect("listar");
		}
		
}
