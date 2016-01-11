import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("deprecation")
public class Test extends Application {
	private Stage primaryStage;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {
		System.out.println("Procedimiento Start");
		this.primaryStage = primaryStage;
		this.primaryStage.setFullScreen(true);
		Button btn = new Button("Login");
		Button buttonPropaganda = new Button("videos");
		Button buttonSalir = new Button("Salir");
		btn.setOnAction(loginClienteHandler());
		buttonPropaganda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				comandos();
			}
		});
		buttonSalir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		root.getChildren().add(buttonPropaganda);

		Scene scene = new Scene(root, 300, 250);

		primaryStage.setTitle("JavaFX version: " + com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@SuppressWarnings("rawtypes")
	public EventHandler loginClienteHandler() {
		EventHandler evh = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(new Scene(VBoxBuilder.create().children(new Text("text")).build()));
				primaryStage.sizeToScene();
				primaryStage.setFullScreen(false);
				primaryStage.setFullScreen(true);
			}
		};
		return evh;
	}

	public static void main(String[] args) {
		System.out.println("procedimiento main");
		launch(args);
	}

	private String leerArchivo() {
		String contenido = "";
		List<String> list = new ArrayList<String>();
		File file = new File("command.cs");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				list.add(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		if (!list.isEmpty()) {
			for (String linea : list) {
				contenido = contenido + linea;
			}
		} else {
			System.out.println("El archivo está vacio");
		}

		return contenido;
	}

	@SuppressWarnings("unused")
	private void comandos() {
		System.out.println();
		try {
			// LINUX: Process p = Runtime.getRuntime().exec(new String[] { "cd
			// /home/pi/contenido && ./videoplayer.sh" });
			// WINDOWS: Process p = Runtime.getRuntime().exec(new String[] {
			// "notepad.exe" });

			Process p = Runtime.getRuntime().exec(new String[] { "notepad","regedit" });


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}