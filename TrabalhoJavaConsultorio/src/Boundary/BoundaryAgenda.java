package Boundary;

import java.util.Date;

import Entidade.Agenda;
import Entidade.Doutor;
import Entidade.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoundaryAgenda implements BoundaryConteudo {
	
	private Label lblIdAgenda = new Label("Cod. Agenda");
	private TextField txtIdAgenda = new TextField();
	private Label lblNomePaciente = new Label("Nome Paciente");
	private TextField txtNomePaciente = new TextField();
	private Label lblRgPaciente = new Label("RG Paciente");
	private TextField txtRGPaciente = new TextField();
	private Label lblNomeDoutor = new Label("Doutor");
	private TextField txtNomeDoutor = new TextField();
	private Label lblCroDoutor = new Label("Número CRO");
	private TextField txtCroDoutor = new TextField();
	private Label lblDataAgenda = new Label("Data Agenda");
	private DatePicker dtpDataAgenda = new DatePicker();
	private Label lblTurno = new Label("Turno");
	private Label lblStatus = new Label("Status");
	private ComboBox<String> cmbStatus = new ComboBox<>();
	private ComboBox<String> cmbTurno = new ComboBox<>();
	private Button btnAdicionar = new Button("Adicionar");
	private TableView<Agenda> tableAgenda = new TableView<>(); 
	
	@Override
	public Pane gerarBoundary() {
		BorderPane  painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		painelPrincipal.setCenter(painelCampos);
		
		painelCampos.add(lblIdAgenda, 0, 0);
		painelCampos.add(txtIdAgenda, 1, 0);
		painelCampos.add(lblNomePaciente, 0, 1);
		painelCampos.add(txtNomePaciente, 1, 1);
		painelCampos.add(lblRgPaciente, 2, 1);
		painelCampos.add(txtRGPaciente, 3, 1);
		painelCampos.add(lblNomeDoutor, 0, 2);
		painelCampos.add(txtNomeDoutor, 1, 2);
		painelCampos.add(lblCroDoutor, 2, 2);
		painelCampos.add(txtCroDoutor, 3, 2);
		painelCampos.add(lblDataAgenda, 0, 3);
		painelCampos.add(dtpDataAgenda, 1, 3);
		painelCampos.add(lblTurno, 2, 3);
		painelCampos.add(cmbTurno, 3, 3);
		painelCampos.add(lblStatus, 0, 4);
		painelCampos.add(cmbStatus, 1, 4);
		painelCampos.add(btnAdicionar, 0, 6);
		
		ObservableList<String> turno = 
						FXCollections.observableArrayList("Manhã","Tarde");
		cmbTurno.setItems(turno);
		
		ObservableList<String> status = 
				FXCollections.observableArrayList("Agendado","Em Atendimento","Finalizado");
		cmbStatus.setItems(status);
		
		TableColumn<Agenda, Long> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Agenda, Long>("idAgenda"));
		
		TableColumn<Agenda, Paciente> colPaciente = new TableColumn<>("Nome Paciente");
		colPaciente.setCellValueFactory(new PropertyValueFactory<Agenda, Paciente>("paciente"));
		
		TableColumn<Agenda, Doutor> colDoutor = new TableColumn<>("Nome Doutor");
		colPaciente.setCellValueFactory(new PropertyValueFactory<Agenda, Paciente>("doutor"));
		
		TableColumn<Agenda, Date> colDataAgendameento = new TableColumn<>("Data Agendamento");
		colDataAgendameento.setCellValueFactory(new PropertyValueFactory<Agenda, Date>("dataAgenda"));
		
		TableColumn<Agenda, String> colTurno = new TableColumn<>("Turno");
		colTurno.setCellValueFactory(new PropertyValueFactory<Agenda, String>("tuno"));
		
		TableColumn<Agenda, String> colStatus = new TableColumn<>("Status");
		colStatus.setCellValueFactory( new PropertyValueFactory<Agenda, String>("status"));
		
		tableAgenda.getColumns().addAll(colId,colPaciente,colDoutor,colDataAgendameento,colTurno,colStatus);
		
		painelPrincipal.setBottom(tableAgenda);
		
		return painelPrincipal;
	}

}
