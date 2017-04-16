package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ConexaoBanco.Service;
import Entidades.Usuario;


/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pRg = request.getParameter("rg");
		String pCpf = request.getParameter("cpf");
		String pSexo = request.getParameter("sexo");
		String pConta = request.getParameter("conta");
		String pSenha = request.getParameter("senha");
		String pHorarioEntrada = request.getParameter("horarioEntrada");
		String pHorarioSaida = request.getParameter("horarioSaida");

		
		//instanciar o javabean
		Usuario usuario = new Usuario();
		usuario.setNome(pNome);
		usuario.setRg(pRg);
		usuario.setCpf(pCpf);
		usuario.setSexo(pSexo);
		usuario.setConta(pConta);
		usuario.setSenha(pSenha);
		usuario.setHorarioEntrada(pHorarioEntrada);
		usuario.setHorarioSaida(pHorarioSaida);
		
		//instanciar o service
		Service cs = new Service();
		cs.criar(usuario);
		usuario = cs.carregar(usuario.getRg());
		
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"nome: "+usuario.getNome()+"<br>");
		out.println(	"rg: "+usuario.getRg()+"<br>");
		out.println(	"cpf: "+usuario.getCpf()+"<br>");
		out.println(	"sexo: "+usuario.getSexo()+"<br>");
		out.println(	"conta: "+usuario.getConta()+"<br>");
		out.println(	"senha: "+usuario.getSenha()+"<br>");
		out.println(	"horarioEntrada: "+usuario.getHorarioEntrada()+"<br>");
		out.println(	"horarioSaida: "+usuario.getHorarioSaida()+"<br>");
	    out.println("</body></html>");
		
	}

}
