package DAO;

import java.util.List;

import Entidade.Paciente;

public interface PacienteDAO {
	
	void adicionar(Paciente p);
	List<Paciente> pesquisarPorNome(String nome);

}
