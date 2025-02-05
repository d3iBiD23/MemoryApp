package com.example.memoryapp;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class GameController {

    @FXML
    private GridPane gameBoard;

    @FXML
    public void initialize() {
        GameBoard board = new GameBoard();
        gameBoard.getChildren().setAll(board.getChildren());
    }

    @FXML
    private void onBackToMenuClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/memoryapp/hello-view.fxml"));
            Parent menuView = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(menuView, 600, 600);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}