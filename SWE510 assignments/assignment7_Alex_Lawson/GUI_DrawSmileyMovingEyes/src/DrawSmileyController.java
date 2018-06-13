// Modified from Fig. 3.16: DrawSmileyController.java
// Drawing a smiley face using colors and filled shapes.
// The eyes will move when the button is clicked or the window is resized

/**@author Alex Lawson
 * 
 * This class draws the smiley. I made two enum classes for the eyes and face.
 * In the Draw() method, I have two random numbers between 1 and 4 that determine
 * which enum constant to use for the eyes and face of the application.
 */

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;



public class DrawSmileyController { 
	
	//enum class for eyes
	public enum eExpressions{ 
		EEXPRESSION1(Color.RED, 46, 15), 
		EEXPRESSION2(Color.BLUE, 30, 45), 
		EEXPRESSION3(Color.AQUA, 25,28),
		EEXPRESSION4(Color.BROWN, 14, 40);
		
		private final Color color;
		private final int width;
		private final int height;
		
		eExpressions(Color color, int width, int height){
			this.color = color;
			this.width = width;
			this.height = height;
		}		
		
		public Color getColor() {
			return color;
		}
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
	}
	//enum class for mouth expression
	public enum fExpressions{
		FEXPRESSION1(Color.BLUE, 220, 110),
		FEXPRESSION2(Color.GREEN, 190, 150),
		FEXPRESSION3(Color.MAGENTA, 185, 140),
		FEXPRESSION4(Color.PINK, 150, 110);
		
		private final Color color;
		private final int width;
		private final int height;
		
		fExpressions(Color color, int width, int height){
			this.color = color;
			this.width = width;
			this.height = height;
		}
		public Color getColor() {
			return color;
		}
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
	}
			
	//method to convert a random int between 1 and 4 to an eExpression enum type
	static eExpressions intToEE(int selection) {
		
		switch(selection) {
		case 1: 
			return eExpressions.EEXPRESSION1;
		case 2:
			return eExpressions.EEXPRESSION2;
		case 3:
			return eExpressions.EEXPRESSION3;
		default:
			return eExpressions.EEXPRESSION4;
		}
	}
	//method to convert a random int between 1 and 4 to an fExpression enum type
	static fExpressions intToFE(int selection) {
		
		switch(selection) {
		case 1: 
			return fExpressions.FEXPRESSION1;
		case 2:
			return fExpressions.FEXPRESSION2;
		case 3:
			return fExpressions.FEXPRESSION3;
		default:
			return fExpressions.FEXPRESSION4;
		}
	}
	
	
   @FXML private Canvas canvas;
   @FXML private BorderPane smileyBorderPain; // CHANGED: Declare this instance variable in this class and also in the fxml file 
   
   private int eyeX1 = 75; // CHANGED: change the x-coordinate when the button is clicked or window is resized
   private int eyeX2 = 185;
   
   // draws a smiley face
   @FXML
   void drawSmileyButtonPressed(ActionEvent event) {
      draw();
   }

   // CHANGED: modularized the drawing code so that it can be called when the button is clicked 
   // as well as when the border pane is resized
   private void draw() {
    // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      // draw the face
      // create two random integers between 1 and 4 for the different enum classes for eyes and mouth
		Random rn = new Random();
		int rn1 = rn.nextInt(4) + 1;
		int rn2 = rn.nextInt(4) + 1;

		eExpressions ee = intToEE(rn1);
		fExpressions fe = intToFE(rn2);

		gc.setFill(Color.YELLOW);
		gc.fillOval(10, 10, 280, 280);
		gc.strokeOval(10, 10, 280, 280);
      
      // draw the eyes
	//call methods to get the color, width, and height values of the eyes and mouth
      gc.setFill(ee.color);
      gc.fillOval(eyeX1, 85, ee.getWidth(), ee.getHeight() );
      gc.fillOval(eyeX2, 85, ee.getWidth(), ee.getHeight() );
      
      // draw the mouth
      //call the instance values of the mouth enum class for color, width, height
      gc.setFill(fe.color);
      gc.fillOval(50, 130, fe.getWidth(), fe.getHeight() );
      
      // "touch up" the mouth into a smile
      gc.setFill(Color.YELLOW);
      gc.fillRect(50, 130, 200, 60);
      gc.fillOval(50, 140, 200, 90);
      
      //I kept the eye movement function in the program
//      eyeX1 += 10;
//      eyeX2 += 10;
//      if(eyeX1 > 120) {
//          eyeX1 = 75;
//          eyeX2 = 185;
//      }
   }
   
   // CHANGED: Added this initialize method
   // This method is called by FXMLLoader when it initialized this controller
   public void initialize() {

      // The code with -> is called lambda expression. We will learn it later. 
      // Lambda expression is simpler than anonymous class we've learned in last class
      smileyBorderPain.prefWidthProperty().addListener((ov, oldValue, newValue) -> {
          canvas.setWidth(newValue.doubleValue());
          draw();
      });

      smileyBorderPain.prefHeightProperty().addListener((ov, oldValue, newValue) -> {
          canvas.setHeight(newValue.doubleValue());
          draw();
      });
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
