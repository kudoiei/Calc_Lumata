import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

   private TextField number1;
   private TextField number2;
   private Label resultText;

   @Override
   public void start(Stage primaryStage) {
      
      Label num1Label = new Label("Number 1:");
      number1 = new TextField();
      Label num2Label = new Label("Number 2:");
      number2 = new TextField();
      Button add = new Button("Add");
      Button sub = new Button("Subtract");
      Button mul = new Button("Multiply");
      Button div = new Button("Divide");
      
      resultText = new Label();
      resultText.setTextFill(Color.RED);
      resultText.setFont(Font.font("Arial", 15));
      
      add.setOnAction(e -> calculate('+'));
      sub.setOnAction(e -> calculate('-'));
      mul.setOnAction(e -> calculate('*'));
      div.setOnAction(e -> calculate('/'));
   
      
      HBox buttonBox = new HBox(10); 
      buttonBox.getChildren().addAll(add, sub, mul, div);
   
     
      VBox vbox = new VBox(10); 
      vbox.setPadding(new Insets(20));
      vbox.getChildren().addAll(
             num1Label, number1,
             num2Label, number2,
             buttonBox, 
             resultText
         );
   
      
      Scene scene = new Scene(vbox, 300, 300);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Simple Calculator_Lumata");
      primaryStage.show();
   }

   private void calculate(char operation) {
      try {
         double num1 = Double.parseDouble(number1.getText());
         double num2 = Double.parseDouble(number2.getText());
         double result;
         switch (operation) {
            case '+':
               result = num1 + num2;
               break;
            case '-':
               result = num1 - num2;
               break;
            case '*':
               result = num1 * num2;
               break;
            case '/':
               if (num2 == 0) {
                  resultText.setText("Error: Division by zero");
                  return;
               }
               result = num1 / num2;
               break;
            default:
               result = 0;
         }
         resultText.setText("Result: " + result);
      } catch (NumberFormatException e) {
         resultText.setText("Please enter valid numbers.");
      }
   }

   public static void main(String[] args) {
      launch(args);
   }
}
