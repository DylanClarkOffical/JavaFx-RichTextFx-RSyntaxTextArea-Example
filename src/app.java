import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.TextEditorPane;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.IOException;




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



        /**
         * Comment the code below or above to activate different types
         */
/*
        TextArea textArea = new TextArea();
        System.out.println(textArea.getFont().getSize());
        textArea.setStyle("-fx-font-size: 1em;");
        //textArea.setStyle("-fx-font-size: 2em; -fx-font-style: italic;");
        anchorPane.getChildren().add(textArea);
*/


        /**
         * Comment the code below or above to activate different types
         */
        // Workaround based on screen scale, on windows scale 125% settings shows 175% text size increase
        // Start segment

        //swingNode.setScaleX(1/Screen.getPrimary().getOutputScaleX());
        //swingNode.setScaleY(1/Screen.getPrimary().getOutputScaleY());


        // Calculate in terms of dpi and scale, new_scale = 100 / (dpi * scale)
        swingNode.setScaleX(100 / (Screen.getPrimary().getDpi() * Screen.getPrimary().getOutputScaleX()));
        swingNode.setScaleY(100 / (Screen.getPrimary().getDpi() * Screen.getPrimary().getOutputScaleY()));


        // The lower scale size and larger font size the crisper the font is in windows with 125% scaling
        // There may be problem with positioning within another element
        //swingNode.setScaleX(.5);
        //swingNode.setScaleY(.5);


        anchorPane.getChildren().add(swingNode);
        // End segment

        System.out.println(Screen.getPrimary().getDpi());
        System.out.println(Screen.getPrimary().getOutputScaleX() + " \t " + Screen.getPrimary().getOutputScaleY());
        System.out.println(Screen.getPrimary().getBounds().getHeight() + " \t " + Screen.getPrimary().getBounds().getWidth());


        primaryStage.show();


    }


    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


                /**
                 * Comment the code below or above to activate different types
                 */
/*
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
                swingNode.setContent(cp);
*/


                /**
                 * Comment the code below or above to activate different types
                 */
                JPanel jPanel = new JPanel();
                JTextArea jTextArea = new JTextArea(20, 40);
                jTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 32));
//                jTextArea.setFont(jTextArea.getFont().deriveFont(30f));
                JScrollPane scrollPane = new JScrollPane( jTextArea );
                jPanel.add(scrollPane);
                swingNode.setContent(jPanel);
            }
        });
    }
}
