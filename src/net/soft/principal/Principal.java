package net.soft.principal;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.soft.controller.ControladorPP;
import net.soft.controller.ControladorSlider;
import net.soft.util.Utilidades;

public class Principal extends Application {
	private static Stage escenario;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		System.out.println("Procedimiento Start");
		CargarPrincipal(primaryStage);
	}

	public static void CargarPrincipal(Stage primaryStage) {
		Principal.escenario = primaryStage;
		Principal.escenario.setFullScreen(true);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Utilidades.restToURL("/net/soft/view/pp.fxml"));
		Scene escena = null;
		try {
			escena = new Scene(loader.load());
			primaryStage.setTitle("Software Central");
			primaryStage.setScene(escena);
			ControladorPP contPP = loader.getController();
			contPP.setEscenario(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		primaryStage.show();

	}

	public static void CargarSlider() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Utilidades.restToURL("/net/soft/view/slider.fxml"));
		Scene escenaSlider;
		try {
			escenaSlider = new Scene(loader.load());
			escenario.setTitle("JavaFX version: " + com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
			escenario.setScene(escenaSlider);
			ControladorSlider contSl = loader.getController();
			contSl.setEsenario(escenario);
			escenario.setFullScreen(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}