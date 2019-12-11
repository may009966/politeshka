package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Classes.Car;
import sample.Classes.Cars;
import sample.Classes.Realization;

public class Controller {
    private ObservableList<Car> list = FXCollections.observableArrayList();
    Realization realization = new Realization("Cars.txt");
    private static Cars cars;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSearchModel;

    @FXML
    private TextField txtSearchColor;

    @FXML
    private MenuButton btnMenuSearchBy;

    @FXML
    private MenuItem findByColMod;

    @FXML
    private MenuItem viewInv;

    @FXML
    private TextField txtFIOAdd;

    @FXML
    private TextField txtNumberAdd;

    @FXML
    private TextField txtAdressAdd;

    @FXML
    private Button btnAddCar;

    @FXML
    private TextField txtYearAdd;

    @FXML
    private TextField txtModelAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtcolorAdd;

    @FXML
    private TableView<Car> tableCars;

    @FXML
    private TableColumn<Car, String> registrationNumberColumn;

    @FXML
    private TableColumn<Car, String> modelColumn;

    @FXML
    private TableColumn<Car, Integer> yearColumn;

    @FXML
    private TableColumn<Car, String> colorColumn;

    @FXML
    private TableColumn<Car, String> FullnameColumn;

    @FXML
    private TableColumn<Car, String> adressColumn;

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void openFile(ActionEvent event) {

    }

    @FXML
    void printList(ActionEvent event) {

    }

    @FXML
    void onChangeSearch(MouseEvent event) {

    }

    @FXML
    void onEnteredAdress(MouseEvent event) {

    }

    @FXML
    void onEnteredFullname(MouseEvent event) {

    }

    @FXML
    void onEnteredNumberAdd(MouseEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {
        try {
            realization.New(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setItemMenuFind(MouseEvent event) {
        findByColMod.setOnAction((e) -> btnMenuSearchBy.setText("По цвету и модели"));
        viewInv.setOnAction((e) -> btnMenuSearchBy.setText("Список инвесторов"));
    }

    @FXML
    void initialize() {
        cars = new Cars();

        FullnameColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("FIO"));
        registrationNumberColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("registrationNumber"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("address"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("color"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("year"));

        addToTable();
    }

    private void addToTable() {
        list.clear();
        tableCars.getItems().clear();

        list.addAll(cars.getList());
        tableCars.setItems(list);
    }

    @FXML
    void addToListByForm(ActionEvent event) {
        try {
            if (Car.CheckCorrectName(txtFIOAdd.getText()) && Car.CheckCorrectNumber(txtYearAdd.getText())) {
                cars.addToList(new Car(txtNumberAdd.getText(), txtModelAdd.getText(), Integer.parseInt(txtYearAdd.getText()), txtcolorAdd.getText(), txtFIOAdd.getText(), txtAdressAdd.getText()));
                addToTable();
            } else {
                AlertInformation("Добавление машины в список", "Некорректный ввод", "Поля заполнены неверно", Alert.AlertType.INFORMATION);

            }
        } catch (Exception ex) {
        }
        ;
    }

    @FXML
    void deleteFromList(ActionEvent event) {
        Cars sublist=new Cars();

        sublist = (Cars) cars.deleteWithRegNum(txtDelete.getText());
        cars.clear();
        cars=sublist;
        addToTable();
    }

    @FXML
    void findByDep(ActionEvent event) {
    }

    @FXML
    void findByFIO(ActionEvent event) {
    }

    @FXML
    void findByTerm(ActionEvent event) {
    }

    @FXML
    void viewInvestors(ActionEvent event) {
    }

    @FXML
    void btnSearch(ActionEvent event) {
        ObservableList<Car> sublist = FXCollections.observableArrayList();
        sublist.clear();

        if (btnMenuSearchBy.getText().equals("По цвету и модели")) {

                sublist.addAll((cars.getWithModelAndColor(txtSearchModel.getText(), txtSearchColor.getText()).getList()));
                tableCars.getItems().clear();
                tableCars.setItems(sublist);
        }

        if (btnMenuSearchBy.getText().equals("Список машин "))
            addToTable();
    }

    private void AlertInformation(String title, String header, String content, Alert.AlertType typeAlert) {
        Alert alert = new Alert(typeAlert);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
