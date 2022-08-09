package Uebung12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Uebung12 extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller();

    controller.link(view, model);

    view.addHandler(controller);

    Scene scene = new Scene(view);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Calculator");
    primaryStage.show();
  }
}
