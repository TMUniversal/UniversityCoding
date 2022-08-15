package bonusTasks.task7.sub1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BonusTask7_1 extends Application {
  private String potentialPalindrome;

  public static boolean isPalindrome(String potentialPalindrome) {
    for (int i = 0; i < potentialPalindrome.length() / 2; i++) {
      if (potentialPalindrome.charAt(i) != potentialPalindrome.charAt(potentialPalindrome.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane content = new BorderPane();
    TextField textField = new TextField();
    Button submit = new Button("Submit");
    Text result = new Text("Press submit to find out if your word is a palindrome");

    submit.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
      potentialPalindrome = textField.getText();

      if (isPalindrome(potentialPalindrome)) {
        result.setText("Your word is a palindrome.");
      } else {
        result.setText("Your word is not a palindrome.");
      }
    });

    content.setTop(textField);
    content.setCenter(result);
    content.setBottom(submit);

    Scene scene = new Scene(content);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
