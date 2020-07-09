package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

import javafx.fxml.FXML;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    Data data;
    ObservableList<String> cbList= FXCollections.observableArrayList("None","Water","Coke","Diet Coke","Dr. Pepper");


    @FXML private AnchorPane root;

    @FXML private RadioButton rbIceCreamCaramel;

    @FXML private ToggleGroup rbSet1;

    @FXML private RadioButton rbIceCreamChocolate;

    @FXML private RadioButton rbIceCreamStrawberry;

    @FXML private ToggleGroup rbSet2;

    @FXML private ComboBox<String> cbCombo;

    @FXML private TextField tbPizza;

    @FXML private TextField tbIceCream;

    @FXML private RadioButton rbPepperoni;

    @FXML private RadioButton rbSupreme;

    @FXML private RadioButton rbCheese;

    @FXML private TextArea tfSummary;

    @FXML private Button btnSummary;

    @FXML private Button btnSave;

    @FXML void handleSodaComboBox(ActionEvent event) {

    }

    @FXML
    void onActionMouseEntered(MouseEvent event) {
        btnSave.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
    }

    @FXML
    void onActionMouseEnteredSubmit(MouseEvent event) {
        btnSummary.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
    }

    @FXML
    void onActionMouseExited(MouseEvent event) {
        btnSave.setFont(Font.font("Tahoma", FontWeight.NORMAL, 11));
    }

    @FXML
    void onActionMouseExitedSubmit(MouseEvent event) {
        btnSummary.setFont(Font.font("Tahoma", FontWeight.NORMAL, 11));
    }

    @FXML
    void onActionSave(ActionEvent event) {

        data = new Data();
        String pizza = tbPizza.getText();
        String iceCream = tbIceCream.getText();
        String soda = cbCombo.getValue();
        data.setPizza(pizza);
        data.setIceCream(iceCream);
        data.setSoda(soda);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        File file = fileChooser.showSaveDialog(null);		//Show save file dialog.
        if(file != null)
        {
            data.WriteFile(file);
        }
    }

    @FXML
    public void onActionSummary(ActionEvent event) {
        data = new Data();
        String pizza = tbPizza.getText();
        String iceCream = tbIceCream.getText();
        String soda = cbCombo.getValue();
        RadioButton pizzaToppings = (RadioButton) rbSet2.getSelectedToggle();
        String pizzaGroup = pizzaToppings.getText();
        RadioButton iceCreamToppings = (RadioButton) rbSet1.getSelectedToggle();
        String iceCreamGroup = iceCreamToppings.getText();
        data.setPizzaToppings(pizzaGroup);
        data.setIceCreamToppings(iceCreamGroup);
        data.setPizza(pizza);
        data.setIceCream(iceCream);
        data.setSoda(soda);
        tfSummary.setText(data.toString());




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbCombo.setValue("None");
        cbCombo.setItems(cbList);
    data = new Data();

    }
}