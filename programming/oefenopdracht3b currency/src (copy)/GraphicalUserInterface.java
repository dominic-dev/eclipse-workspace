import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GraphicalUserInterface extends Application{
    @Override
    public void start(Stage primaryStage){
        CurrencyExchanger Exchanger = new CurrencyExchanger();

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        ObservableList<String> valutaList = FXCollections.observableArrayList();
        ListView valutaListView = new ListView(valutaList);
        for (Currency currency in )
        valutaListView.setItems(valutaList);

        TextField fieldAmount = new TextField("Amount");
        Button btGo = new Button("Go");

        pane.getChildren().add(valutaListView);
        pane.getChildren().add(fieldAmount);
        pane.getChildren().add(btGo);

        Scene scene = new Scene(pane, 500, 250);
        primaryStage.setTitle("Currency Exchange");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
