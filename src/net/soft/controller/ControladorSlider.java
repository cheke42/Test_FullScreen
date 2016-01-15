package net.soft.controller;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ControladorSlider {
	private Stage esenario;

	public Stage getEsenario() {
		return esenario;
	}

	public void setEsenario(Stage esenario) {
		this.esenario = esenario;
	}

	@FXML
	private WebView webView;

	@FXML
	void initialize() {
		WebEngine webEngine = webView.getEngine();
		webEngine.load("http://localhost/sliders");
	}

}
