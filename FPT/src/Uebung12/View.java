package Uebung12;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class View extends BorderPane {
  public static final double SPACING = 3d;
  HBox numberDisplayContainer = new HBox();
  TextField textField = new TextField("0");

  VBox operatorContainer = new VBox();
  Map<String, Button> operatorButtons = new HashMap<>();
  Button equalsButton = new Button("=");

  GridPane numberButtonsContainer = new GridPane();
  Map<String, Button> numberButtons = new HashMap<>();


  public View() {
    for (Operator operator : Operator.values()) {
      operatorButtons.put(operator.name(), new Button(operator.toString()));
    }

    String[] numberButtonTexts = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "CE"};
    for (String t : numberButtonTexts) {
      numberButtons.put(t, new Button(t));
    }

    operatorContainer.getChildren().addAll(operatorButtons.values());
    operatorContainer.getChildren().add(equalsButton);

    textField.setEditable(false);
    numberDisplayContainer.getChildren().add(textField);

    numberButtonsContainer.add(numberButtons.get("7"), 0, 0);
    numberButtonsContainer.add(numberButtons.get("8"), 1, 0);
    numberButtonsContainer.add(numberButtons.get("9"), 2, 0);
    numberButtonsContainer.add(numberButtons.get("4"), 0, 1);
    numberButtonsContainer.add(numberButtons.get("5"), 1, 1);
    numberButtonsContainer.add(numberButtons.get("6"), 2, 1);
    numberButtonsContainer.add(numberButtons.get("1"), 0, 2);
    numberButtonsContainer.add(numberButtons.get("2"), 1, 2);
    numberButtonsContainer.add(numberButtons.get("3"), 2, 2);
    numberButtonsContainer.add(numberButtons.get("C"), 0, 3);
    numberButtonsContainer.add(numberButtons.get("0"), 1, 3);
    numberButtonsContainer.add(numberButtons.get("CE"), 2, 3);

    numberDisplayContainer.setSpacing(SPACING);
    numberButtonsContainer.setHgap(SPACING);
    numberButtonsContainer.setVgap(SPACING);
    operatorContainer.setSpacing(SPACING);

    setHeight(800d);

    setTop(numberDisplayContainer);
    setCenter(numberButtonsContainer);
    setRight(operatorContainer);
  }

  public void addHandler(Controller controller) {
    for (Button button : operatorButtons.values()) {
      button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> controller.operatorButtonHandler(button, event));
    }

    equalsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, controller::equalsButtonHandler);

    for (int i = 0; i < 10; i++) {
      int finalI = i;
      numberButtons.get(String.valueOf(i)).addEventHandler(MouseEvent.MOUSE_CLICKED, event -> controller.numberButtonHandler(finalI, event));
    }

    numberButtons.get("C").addEventHandler(MouseEvent.MOUSE_CLICKED, controller::cButtonHandler);
    numberButtons.get("CE").addEventHandler(MouseEvent.MOUSE_CLICKED, controller::ceButtonHandler);
  }
}
