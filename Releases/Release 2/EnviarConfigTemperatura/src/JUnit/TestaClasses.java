package JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Entidades.Empresa;
import Entidades.Usuario;

//USUARIO = nome rg cpf sexo conta senha horarioEntrada horarioSaida tipo
//EMPRESA =  CNPJ razaoSocial conjuntoNR horarioEntrada horarioEncerramento temperaturaMin temperaturaMax arLigar;arDesligar;

public class TestaClasses {

	Usuario usuario;
	Empresa empresa;

	// TESTES RELACIONADOS AO USUARIO - <<CRUD>

	@Before
	public void usuarioSet() throws Exception {
		usuario = new Usuario("Andre", "123456789987", "123456987654", "M", "1", "2", "11:00", "18:00", "1");
		System.out.println(usuario);
	}

	/// Carregar - Usuario
	@Test
	public void carregarUsuario(String nome) {
		Usuario fixture = new Usuario("Andre", "123456789987", "123456987654", "M", "1", "2", "11:00", "18:00", "1");
		Usuario novo = new Usuario(null, null, null, null, null, null, null, null, null);
		novo.carregar(nome);
		assertEquals("Testa Usuario", novo, fixture);
	}

	// Atualizar - Usuario
	@Test
	public void atualizarUsuario(String nome) {
		usuario.setNome(nome);
		usuario.atualizar(usuario);
		usuario.carregar(nome);
		assertEquals("teste de usuario", usuario);
	}

	// Excluir - Usuario
	@Test
	public void excluirUsuario(String nome) {
		usuario.excluir(nome);
		usuario.carregar(nome);
		assertEquals("Excluir usuario", usuario);
	}

}
