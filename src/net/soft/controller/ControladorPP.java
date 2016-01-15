package net.soft.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.soft.principal.Principal;

public class ControladorPP {
	private Stage escenario;
	@FXML
	private Button buttonVideosConsola;

	@FXML
	private Button buttonSlider;

	@FXML
	private Button buttonSalir;

	@FXML
	private ImageView imageFondo;

	@FXML
	void slider(ActionEvent event) {
		Principal.CargarSlider();
	}

	@FXML
	void initialize() {
		imageFondo.setImage(new Image("file:recursos/img/fondo-pp.jpg"));
	}

	@FXML
	void salir(ActionEvent event) {
		escenario.close();
	}

	@FXML
	void videosConsola(ActionEvent event) {
		comandos();
	}

	public Stage getEscenario() {
		return escenario;
	}

	public void setEscenario(Stage escenario) {
		this.escenario = escenario;
	}

	@SuppressWarnings("unused")
	private void comandos() {
		System.out.println();
		try {
			// LINUX: Process p = Runtime.getRuntime().exec(new String[] { "cd
			// /home/pi/contenido && ./videoplayer.sh" });
			// WINDOWS: Process p = Runtime.getRuntime().exec(new String[] {
			// "notepad.exe" });

			Process p = Runtime.getRuntime().exec(new String[] { "iniciar-video" });

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
