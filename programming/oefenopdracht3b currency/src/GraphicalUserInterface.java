import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GraphicalUserInterface extends Application{
    public ObservableList<String> valutaList = FXCollections.observableArrayList();
    public ListView inputValutaListView = new ListView(valutaList);
    public ListView outputValutaListView = new ListView(valutaList);
    public Label fieldOutputAmount = new Label();
    public TextField fieldAmount = new TextField("Amount");

    @Override
    public void start(Stage primaryStage){
        CurrencyExchanger Exchanger = new CurrencyExchanger();

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(5);
        pane.setVgap(5);

        for (Currency currency : Exchanger.currencies){
            valutaList.add(currency.name);
        }
        inputValutaListView.setItems(valutaList);
        outputValutaListView.setItems(valutaList);


        Button btGo = new Button("Go");

        pane.getChildren().add(new Label("Huidige koers:"));
        pane.getChildren().add(inputValutaListView);
        pane.getChildren().add(new Label("Nieuwe koers:"));
        pane.getChildren().add(outputValutaListView);
        pane.getChildren().add(fieldAmount);
        pane.getChildren().add(btGo);
        pane.getChildren().add(fieldOutputAmount);
        
        btGo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                int inputValutaIndex = inputValutaListView.getSelectionModel().getSelectedIndex();
                int outputValutaIndex = outputValutaListView.getSelectionModel().getSelectedIndex();

                Currency inputCurrency = Exchanger.currencies[inputValutaIndex];
                Currency outputCurrency = Exchanger.currencies[outputValutaIndex];
                double amount = Double.parseDouble(fieldAmount.getText());
                double result = Exchanger.exchange(amount, inputCurrency, outputCurrency);
                fieldOutputAmount.setText(Double.toString(result));
            }

        });

        Scene scene = new Scene(pane, 1024, 600);
        primaryStage.setTitle("Currency Exchange");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
