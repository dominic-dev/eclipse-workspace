import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GraphicalUserInterface extends Application{
    public TextArea dobbelsteenVeld = new TextArea();
    public char dobbelsteenTeken = '*';

    @Override
    public void start(Stage primaryStage){
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(5);
        pane.setVgap(5);

        TextField teken = new TextField("*");
        Button btGo = new Button("Werp");

        dobbelsteenVeld.setPrefHeight(58);
        dobbelsteenVeld.setPrefWidth(30);
        pane.getChildren().add(teken);
        pane.getChildren().add(btGo);
        pane.getChildren().add(dobbelsteenVeld);

        Dobbelsteen dobbelsteen = new Dobbelsteen();
        
        btGo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dobbelsteenTeken = teken.getText().charAt(0);
                        String result = "";
                        int index = 0;
                        while(index != 5){
                            index = dobbelsteen.gooi();
                            String ogen = dobbelsteen.ogen[index];
                            result = ogen.replace('*', dobbelsteenTeken);
                            dobbelsteenVeld.setText(result);

                            // Delay 
                            try{
                                TimeUnit.MILLISECONDS.sleep(200);
                            } catch (InterruptedException ex){

                            }
                        }
                    }
                }).start();
                    
            }

        });

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Dobbelsteen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
