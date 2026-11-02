package com.vendetta.lab10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrimaryController {
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private MenuItem closeItem;

    @FXML
    private MenuItem copyItem;

    @FXML
    private MenuItem findItem;

    @FXML
    private CheckMenuItem gridItem;

    @FXML
    private RadioMenuItem largeItem;

    @FXML
    private RadioMenuItem mediumItem;

    @FXML
    private MenuItem newItem;

    @FXML
    private MenuItem openItem;

    @FXML
    private ToggleGroup radioMenuItems;

    @FXML
    private MenuItem replaceItem;

    @FXML
    private MenuItem saveItem;

    @FXML
    private RadioMenuItem smallItem;
    
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup tg = new ToggleGroup();
        smallItem.setToggleGroup(tg);
        mediumItem.setToggleGroup(tg);
        largeItem.setToggleGroup(tg);
        closeItem.setDisable(true); // disabled until a file is "opened"
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
    
        ContextMenu popup = new ContextMenu();
        MenuItem help = new MenuItem("Help");
        MenuItem inspect = new MenuItem("Inspect");
        popup.getItems().addAll(help, inspect);
        mainPane.setOnMouseClicked(e -> {
         if (e.getButton() == MouseButton.SECONDARY) {
         popup.show(mainPane, e.getScreenX() - 50, e.getScreenY() -
        25);
         }
        });

    }
    @FXML
    void handleClose(ActionEvent e) {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
    
    
    
    @FXML
    void handleNew(ActionEvent e) {
        System.out.println("NEW has been pressed");
        newItem.setDisable(true);
        openItem.setDisable(true);
        closeItem.setDisable(false);
    }
    
    @FXML
    void handleGrid(ActionEvent e) {
        if (gridItem.isSelected())
        System.out.println("USE GRIDLINES selected");
        else
        System.out.println("USE GRIDLINES unselected");
    }
    
}
