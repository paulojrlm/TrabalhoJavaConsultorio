package Boundary;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import Controler.DoutorControl;
import Entidade.Doutor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoundaryDoutor implements BoundaryConteudo {
	private Label lblId = new Label("Id");
	private TextField txtId = new TextField();
	private Label lblNome = new Label("Nome");
	private TextField txtNome = new TextField();
	private Label lblCpf = new Label("Cpf");
	private TextField txtCpf = new TextField();
	private Label lblSexo = new Label("Sexo");
	private RadioButton rbSexoMasc = new RadioButton("Masculino");
	private RadioButton rbSexoFem = new RadioButton("Feminino");
	private Label lblDataNasc = new Label("Data Nasc.");
	private DatePicker dpDataNasc = new DatePicker();
	private Label lblEndereco = new Label("Endereço");
	private TextField txtEndereco = new TextField();
	private Label lblTelefone = new Label("Telefone");
	private TextField txtTelefone = new TextField();
	private Label lblCargo = new Label("Cargo");
	private TextField txtCargo = new TextField();
	private Label lblEspecialista = new Label("Especialista");
	private TextField txtEspecialista = new TextField();
	private Label lblNumCRO = new Label("Número C.R.O");
	private TextField txtNumCRO = new TextField();
	private ToggleGroup tgSexo = new ToggleGroup();
	private Button btnAdicionar = new Button("Adicionar");
	
	private RadioButton sexoSelecionado;
	private DoutorControl doutorControl = new DoutorControl();
	
	@Override
	public Pane gerarBoundary() {
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		
		painelPrincipal.setCenter(painelCampos);
	
		rbSexoFem.setToggleGroup(tgSexo);
		rbSexoMasc.setToggleGroup(tgSexo);
		painelCampos.add(lblId, 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(lblNome, 0, 1);
		painelCampos.add(txtNome, 1, 1);
		painelCampos.add(lblCpf, 0, 2);
		painelCampos.add(txtCpf, 1, 2);
		painelCampos.add(lblSexo, 0, 3);
		painelCampos.add(rbSexoMasc, 1, 3);
		painelCampos.add(rbSexoFem, 2, 3);
		painelCampos.add(lblDataNasc, 0, 4);
		painelCampos.add(dpDataNasc, 1, 4);
		painelCampos.add(lblEndereco, 0, 5);
		painelCampos.add(txtEndereco, 1, 5);
		painelCampos.add(lblTelefone, 0, 6);
		painelCampos.add(txtTelefone, 1, 6);
		painelCampos.add(lblCargo, 0, 7);
		painelCampos.add(txtCargo, 1, 7);
		painelCampos.add(lblEspecialista, 0, 8);
		painelCampos.add(txtEspecialista, 1, 8);
		painelCampos.add(lblNumCRO, 0, 9);
		painelCampos.add(txtNumCRO, 1, 9);
		painelCampos.add(btnAdicionar, 0, 10);
	
		btnAdicionar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Doutor d = doFormularioParaDoutor();
				doutorControl.adicionarDoutor(d);
				painelCampos.setDisable(true);

			}			
		});
		
		return painelPrincipal;
	}
	
	
	public Doutor doFormularioParaDoutor() {
		Doutor d = new Doutor();
		sexoSelecionado = (RadioButton) tgSexo.getSelectedToggle();
		
		d.setNome(txtNome.getText());
		d.setCpf(txtCpf.getText());
		d.setCargo(txtCargo.getText());
		d.setSexo(sexoSelecionado.getText());
		d.setTelefone(txtTelefone.getText());
		d.setEndereco(txtEndereco.getText());
		d.setEspecialidade(txtEspecialista.getText());
		d.setNumeroCro(Long.parseLong(txtNumCRO.getText()));
		LocalDate ld = dpDataNasc.getValue();
		Date data = Date.from(
				ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		d.setDataNasc(data);
		return d;
		
	}
	

}
