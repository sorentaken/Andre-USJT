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

	// TESTES RELACIONADOS A EMPRESA <<CRUD>>

	@Before
	public void empresaSet() throws Exception {
		empresa = new Empresa("USJT", "CNPJ", "PQPWE", 222, "11:00", "18:00", 13, 27, "10:30", "17:55");
		System.out.println(empresa);
	}

	@Test
	public void carregarEmpresa(String nome) {
		Empresa fixture2 = new Empresa();
		Empresa novo2 = new Empresa(null, null, null, 0, null, null, 0, 0, null, null);
		novo2.carregar(nome);
		assertEquals("Testa Empresa", novo2, fixture2);
	}

	public void excluirEmpresa(String nome) {
		Empresa empresa = new Empresa();
		empresa.excluir(nome);
		empresa.carregar(nome);
		assertEquals("Excluir empresa", empresa);
	}

	@Test
	public void atualizarEmpresa(String nome) {
		empresa.setNomeEmpresa("Dude");
		empresa.atualizar(empresa);
		empresa.carregar(nome);
		assertEquals("testa de empresa", empresa);
	}

}
