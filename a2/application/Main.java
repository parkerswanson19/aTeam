package application;

import java.util.List;
import java.util.Observable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Main extends Application {
	// store any command-line arguments that were entered.
	// NOTE: this.getParameters().getRaw() will get these also
	private List<String> args;

	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	private static final String APP_TITLE = "Hello World!";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// save args example
		args = this.getParameters().getRaw();
				
		//list to be stored in the hobbies ComboBox
		String[] hobbies = { "Tennis", "Hockey", "Table Tennis", 
            "Programming", "Yotube", "Biking"};			
		//ComboBox to be put in the left pannel
		ComboBox hobbiesCombo = new ComboBox(FXCollections.observableArrayList(hobbies));
		
		//list to be stored in the majorsComboBox
		String[] majors = { "Computer Science", "Data Science"};	
		//ComboBox to be put in the right pannel
		ComboBox majorsCombo = new ComboBox(FXCollections.observableArrayList(majors));
		
		
		//image to be put in the center pannel
		Image image = new Image("me.JPG");
		ImageView iv1 = new ImageView();
		iv1.setImage(image);
		iv1.setFitWidth(100);
		iv1.setFitHeight(100);
		
		//button to be put in the bottom pannel
		Button button = new Button("Click here");
			
		// Create a vertical box with Hello labels for each args
        VBox vbox = new VBox();
        for (String arg : args) {
        	vbox.getChildren().add(new Label("hello "+arg));
        }

		// Main layout is Border Pane example (top,left,center,right,bottom)
        	BorderPane root = new BorderPane();

		// Add the vertical box to the center of the root pane
        root.setLeft(hobbiesCombo);
        //set all of the differnt components
        root.setCenter(iv1);
		root.setTop(new Label("CS400 My First JavaFX Program"));
		root.setBottom(button);
		root.setRight(majorsCombo);
		
        //root.setCenter(vbox);
		Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

		// Add the stuff and set the primary stage
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setScene(mainScene);
        primaryStage.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   launch(args);
	}
}
