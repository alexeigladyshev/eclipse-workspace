// DrawSmiley.java
/**
 * this is the class that launches the application, no changes were made to the class
 * from what was already there originally
 */

// Main application class that loads and displays the DrawSmiley GUI.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DrawSmiley extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      // loads Welcome.fxml and configures the DrawSmileyController
      // CHANGED: Parent -> BorderPane
      BorderPane root = 
         FXMLLoader.load(getClass().getResource("DrawSmiley.fxml"));

      Scene scene = new Scene(root); // attach scene graph to scene
      stage.setTitle("Draw Smiley"); // displayed in window's title bar
      stage.setScene(scene); // attach scene to stage
      stage.show(); // display the stage
      
      // CHANGED: bind the size of the border pane to the size of scene
      // so that the size of border pane changes whenever the window size changes
      // Note that the Smiley's face moved up a little bit after I made this change.
      // Please let me know if you find how to fix it.
      root.prefWidthProperty().bind(scene.widthProperty());
      root.prefHeightProperty().bind(scene.heightProperty());
   }

   public static void main(String[] args) {
      launch(args); 
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
