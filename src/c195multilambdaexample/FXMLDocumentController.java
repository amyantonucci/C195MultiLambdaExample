/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c195multilambdaexample;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author amy.antonucci
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Fruit> table;

    @FXML
    private TableColumn<Fruit, String> colName;

    @FXML
    private TableColumn<Fruit, String> colColor;
    
    @FXML
    private TableColumn<Fruit, Integer> colAge;

    @FXML
    private TableColumn<Fruit, LocalDateTime> colDate;

    ObservableList<Fruit> fruitList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fruitList = FXCollections.observableArrayList();

        fruitList.add(new Fruit(
                new ReadOnlyStringWrapper("apple"),
                new ReadOnlyStringWrapper("green"),
                new ReadOnlyObjectWrapper(10),
                new ReadOnlyObjectWrapper(LocalDateTime.now())));
        fruitList.add(new Fruit(
                new ReadOnlyStringWrapper("banana"),
                new ReadOnlyStringWrapper("yellow"),
                new ReadOnlyObjectWrapper(20),
                new ReadOnlyObjectWrapper(LocalDateTime.now().plusDays(3))));
        fruitList.add(new Fruit(
                new ReadOnlyStringWrapper("cherry"),
                new ReadOnlyStringWrapper("red"),
                new ReadOnlyObjectWrapper(30),
                new ReadOnlyObjectWrapper(LocalDateTime.now().plusMonths(3))));

        colName.setCellValueFactory(cellData -> {
            return cellData.getValue().getName();
        });
        colColor.setCellValueFactory(cellData -> {
            return cellData.getValue().getColor();
        });
        colAge.setCellValueFactory(cellData -> {
            return cellData.getValue().getAge();
        });
        colDate.setCellValueFactory(cellData -> {
            return cellData.getValue().getDate();
        });
        table.setItems(fruitList);


    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlus7 = now.plusDays(7);
        FilteredList<Fruit> filteredData = new FilteredList<>(fruitList);
        filteredData.setPredicate(row -> {

            LocalDateTime rowDate = row.getDate().getValue();

            return rowDate.isAfter(now) && rowDate.isBefore(nowPlus7);
        });
        table.setItems(filteredData);

    }

    @FXML
    void handleMouseClick(MouseEvent event) {
        TablePosition tp = table.getSelectionModel().getSelectedCells().get(0);
        int row = tp.getRow();
        TableColumn tc = tp.getTableColumn();
        String data = (String) tc.getCellObservableValue(row).getValue().toString();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setHeaderText("You chose " + data + "!");

        alert.setContentText("Great choice! " );

        alert.showAndWait();
    }
}
