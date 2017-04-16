package ConexaoBanco;

import java.sql.SQLException;

import Entidades.Usuario;



public class Service {
	UsuarioDAO dao = new UsuarioDAO();
	
	public String criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	
	public void atualizar(Usuario usuario){
		dao.atualizar2(usuario);
	}
	
	public void excluir(String nome){
		dao.excluir2(nome);
	}
	
	
	public Usuario carregar(String nome){
		return dao.carregar2(nome);
	}

}
