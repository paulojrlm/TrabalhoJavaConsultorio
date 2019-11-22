package Controler;

import DAO.AgendaDAO;
import DAO.AgendaDAOImpl;
import Entidade.Agenda;

public class AgendaControl {
	
	private AgendaDAO agendaDao = new AgendaDAOImpl();
	
	public void adicionarAgenda( Agenda a) {
		agendaDao.adicionar(a);
	}

}
