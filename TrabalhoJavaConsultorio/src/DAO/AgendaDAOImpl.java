package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Entidade.Agenda;

public class AgendaDAOImpl implements AgendaDAO {
	
	private static final String URL ="jdbc:mysql://localhost:3306/consultorio?serverTimezone=UTC&allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "250507";
	
	private Connection con;
	
	public AgendaDAOImpl() {
		 try {
			con = DriverManager.getConnection(URL,USER,PASS);
		} catch (SQLException e) {		
			e.printStackTrace();
		}

	}

	@Override
	public void adicionar(Agenda a) {
		// TODO Auto-generated method stub
		
	}
	
	

}
