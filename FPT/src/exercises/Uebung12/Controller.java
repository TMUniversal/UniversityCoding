package exercises.Uebung12;

import javafx.event.Event;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;

public class Controller {
  private Model model;
  private View view;

  private Map<String, Operator> operatorMap = new HashMap<String, Operator>();

  public Controller() {
    for (Operator operator : Operator.values()) {
      operatorMap.put(operator.toString(), operator);
    }
  }

  public void link(View view, Model model) {
    this.view = view;
    this.model = model;
  }

  public void operatorButtonHandler(Button button, Event event) {
    Operator operator = operatorMap.get(button.getText());
    System.out.println("Operator Button Pressed: " + operator.toString());

    model.lastNumber = Integer.parseInt(view.textField.getText());
    model.lastOperator = operator;

    view.textField.setText("0");
  }

  public void numberButtonHandler(int value, Event event) {
    System.out.println("Number Button Pressed " + value);

    if (view.textField.getText().equals("0")) {
      if (value == 0) return;

      view.textField.setText(String.valueOf(value));
    } else {
      view.textField.setText(view.textField.getText() + value);
    }
  }

  public void cButtonHandler(Event event) {
    System.out.println("C Button Pressed " + event.getTarget().toString());
    view.textField.setText("");
  }

  public void ceButtonHandler(Event event) {
    System.out.println("CE Button Pressed " + event.getTarget().toString());
    view.textField.setText("");
    model.lastOperator = Operator.ADD;
    model.lastNumber = 0;
  }

  public void equalsButtonHandler(Event event) {
    int currentNumber = Integer.parseInt(view.textField.getText());
    System.out.println("Equals Button Pressed: " + model.lastNumber + model.lastOperator.toString() + currentNumber);

    int result = 0;

    switch (model.lastOperator) {
      case ADD:
        result = model.lastNumber + currentNumber;
        break;
      case SUBTRACT:
        result = model.lastNumber - currentNumber;
        break;
      case MULTIPLY:
        result = model.lastNumber * currentNumber;
        break;
      case DIVIDE:
        if (currentNumber == 0) {
          view.textField.setText("E");
          return;
        }
        result = model.lastNumber / currentNumber;
        break;
    }

    view.textField.setText(String.valueOf(result));
  }
}
