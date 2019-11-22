package Entidade;

import java.util.Date;

public class Agenda {

	private Doutor doutor;
	private Paciente paciente; 
	private long idAgenda;
	private Date dataAgenda;
	private String turno;
	private String status;
	
	
	
	public Doutor getDoutor() {
		return doutor;
	}
	public void setDoutor(Doutor doutor) {
		this.doutor = doutor;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public long getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(long idAgenda) {
		this.idAgenda = idAgenda;
	}
	public Date getDataAgenda() {
		return dataAgenda;
	}
	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
	public String getHoraAgenda() {
		return turno;
	}
	public void setHoraAgenda(String turno) {
		this.turno = turno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
