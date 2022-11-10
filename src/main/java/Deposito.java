import java.time.LocalDateTime;

import br.sc.senac.returnit.entidade.usuario.Usuario;

public class Deposito {

	public Deposito(Colaborador colaborador, Usuario usuario, LocalDateTime data, Retornavel retornavel) {
		super();
		this.colaborador = colaborador;
		this.usuario = usuario;
		this.data = data;
		this.retornavel = retornavel;
	}
	private Colaborador colaborador;
	private Usuario usuario;
	private LocalDateTime data;
	private Retornavel retornavel;
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Retornavel getRetornavel() {
		return retornavel;
	}

	public void setRetornavel(Retornavel retornavel) {
		this.retornavel = retornavel;
	}
}
