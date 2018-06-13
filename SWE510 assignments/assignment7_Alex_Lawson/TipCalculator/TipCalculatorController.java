/**@author Alex Lawson
 * this is the class that draws the entire picture. I make annotations
 * in the parts of the code that I change.
 */

// TipCalculatorController.java
// Controller that handles calculateButton and tipPercentageSlider events
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.InputMismatchException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController { 
   // formatters for currency and percentages
   private static final NumberFormat currency = 
      NumberFormat.getCurrencyInstance();
   private static final NumberFormat percent = 
      NumberFormat.getPercentInstance();
   
   private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default
   
   // GUI controls defined in FXML and used by the controller's code
   @FXML 
   private TextField amountTextField;
   
   //this TextField I added for the user to enter number of people in the party.
   @FXML
   private TextField numOfPeopleTextField;
   
   @FXML
   private Label tipPercentageLabel; 

   @FXML
   private Slider tipPercentageSlider;

   @FXML
   private TextField tipTextField;

   @FXML
   private TextField totalTextField;
   
   //this TextField I added to present what the bill is per person
   @FXML
   private TextField totalPerPersonTextField;

   // calculates and displays the tip and total amounts
   @FXML
   private void calculateButtonPressed(ActionEvent event) {
	   
      try {
         BigDecimal amount = new BigDecimal(amountTextField.getText());
         if (amount.compareTo(BigDecimal.ZERO)<0)
        	 	throw new InputMismatchException();
         
         BigDecimal numberOfPeople = new BigDecimal(numOfPeopleTextField.getText());
         if (numberOfPeople.compareTo(BigDecimal.ZERO)<=0)
        	 	throw new InputMismatchException();
         
         BigDecimal tip = amount.multiply(tipPercentage);
         BigDecimal total = amount.add(tip);
         BigDecimal totalperperson;

         //enter the total, like in the original program
         totalTextField.setText(currency.format(total));
         
         //calculate the number per person that has to be paid
         //using the Rounding function of BigDecimal, so the divide method doesn't throw an exception
         totalperperson = total.divide(numberOfPeople, RoundingMode.HALF_UP);
         
         tipTextField.setText(currency.format(tip));
         totalPerPersonTextField.setText(currency.format(totalperperson));
      }
      catch (NumberFormatException ex) {
         amountTextField.setText("Enter amount");
         numOfPeopleTextField.setText("Enter number of people");
         amountTextField.selectAll();
         amountTextField.requestFocus();
         
         totalTextField.clear();
         totalPerPersonTextField.clear();
         tipTextField.clear();
      }
      catch(InputMismatchException e) {
    	  	 amountTextField.setText("Enter amount");
         numOfPeopleTextField.setText("Enter number of people");
         amountTextField.selectAll();
         amountTextField.requestFocus();
         
         totalTextField.clear();
         totalPerPersonTextField.clear();
         tipTextField.clear();
      }
   }

   // called by FXMLLoader to initialize the controller
   public void initialize() {
      // 0-4 rounds down, 5-9 rounds up 
      currency.setRoundingMode(RoundingMode.HALF_UP);
      
      // listener for changes to tipPercentageSlider's value
      tipPercentageSlider.valueProperty().addListener(
         new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, 
               Number oldValue, Number newValue) {
               tipPercentage = 
                  BigDecimal.valueOf(newValue.intValue() / 100.0);
               tipPercentageLabel.setText(percent.format(tipPercentage));
            }
         }
      );
   }
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
