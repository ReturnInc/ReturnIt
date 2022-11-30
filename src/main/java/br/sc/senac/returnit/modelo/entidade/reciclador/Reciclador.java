package br.sc.senac.returnit.modelo.entidade.reciclador;

import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;

public class Reciclador extends Usuario{
	
	private String cpf_reciclador;
	private String genero_reciclador;
	private long id_usuario;
	
	public Reciclador(String cpfReciclador, String generoReciclador, long idUsuario, String nome,  Endereco endereco, Contato contato, String senha) {
		super(idUsuario, nome,  endereco, contato, senha);
		setCpf_reciclador(cpfReciclador);
		setGenero_reciclador(generoReciclador);
		setId_usuario(idUsuario);
	}
	public String getCpf_reciclador() {
		return cpf_reciclador;
	}
	public void setCpf_reciclador(String cpfReciclador) {
		this.cpf_reciclador = cpfReciclador;
	}
	public String getGenero_reciclador() {
		return genero_reciclador;
	}
	public void setGenero_reciclador(String genero_reciclador) {
		this.genero_reciclador = genero_reciclador;
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long idUsuario) {
		this.id_usuario = idUsuario;
	}
	public enum Genero {
		
		feminino("Feminino"),
		masculino("Masculino"),
		neutro("Neutro"),
		prefiroNaoDeclarar("prefiro Não declarar");
		
		private String descricao;
		
		Genero(String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
	}
}