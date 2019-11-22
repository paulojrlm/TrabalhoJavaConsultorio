package Controler;

import DAO.DoutorDAO;
import DAO.DoutorDAOImpl;
import Entidade.Doutor;

public class DoutorControl {
	
	private DoutorDAO doutorDAO = new DoutorDAOImpl();
	
	public void adicionarDoutor(Doutor d) {
		doutorDAO.adicionar(d);
		
	}

}
