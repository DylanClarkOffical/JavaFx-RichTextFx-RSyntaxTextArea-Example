import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class app extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AppView.fxml"));
        primaryStage.setTitle("BrainLess IDE");
        primaryStage.setScene(new Scene(root, 900, 600));


        AnchorPane anchorPane = (AnchorPane) primaryStage.getScene().lookup("#main_body");

        final SwingNode swingNode = new SwingNode();
        createAndSetSwingContent(swingNode);

        //StackPane pane = new StackPane();
        //pane.getChildren().add(swingNode);








        anchorPane.getChildren().add(swingNode);













        primaryStage.show();




    }



    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


                JPanel cp = new JPanel(new BorderLayout());
                RSyntaxTextArea textArea = new RSyntaxTextArea(30, 100);
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                textArea.setCodeFoldingEnabled(true);
                RTextScrollPane sp = new RTextScrollPane(textArea);

                sp.setIconRowHeaderEnabled(true);



                Gutter gutter = sp.getGutter();
                gutter.setBookmarkIcon(new ImageIcon("C:\\Users\\computer\\IdeaProjects\\RSTA_TRIAL\\src\\bookmark1.png"));
                gutter.setBookmarkingEnabled(true);


                try {
                    gutter.addLineTrackingIcon(0, new ImageIcon("C:\\Users\\computer\\IdeaProjects\\RSTA_TRIAL\\src\\bookmark1.png"));
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }


                cp.add(sp);





//                swingNode.setContent(new JButton("Click me!"));
                swingNode.setContent(cp);
            }
        });
    }
}
