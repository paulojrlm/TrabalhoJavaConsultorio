package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidade.Doutor;

public class DoutorDAOImpl implements DoutorDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/consultorio?serverTimezone=UTC&allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "250507";
	private Connection con;
	
	public DoutorDAOImpl() {
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Conectado");
		} catch (SQLException e) {
			System.out.println("Erro conexão");
			e.printStackTrace();
		}	
		
	}
	
	@Override
	public void adicionar(Doutor d) {
		
		String sql = "INSERT INTO tb_doutor (id_doutor,nome_doutor,cpf_doutor,sexo,data_nasc,endereco,telefone,cargo,especialidade,numero_cro)"
					+" VALUES(0,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, d.getNome());
			st.setString(2, d.getCpf());
			st.setString(3, d.getSexo());
			java.util.Date dt = d.getDataNasc();
			long milliseg = dt.getTime();
			java.sql.Date dataSql = new java.sql.Date(milliseg);			
			st.setDate(4, dataSql);
			st.setString(5, d.getEndereco());
			st.setString(6, d.getTelefone());
			st.setString(7, d.getCargo());
			st.setString(8, d.getEspecialidade());
			st.setLong(9, d.getNumeroCro());
			st.execute();
			System.out.println("Doutor incluido");
		} catch (SQLException e) {
			System.out.println("Erro ao incluir doutor");
			e.printStackTrace();
		}	
		
	}

}
