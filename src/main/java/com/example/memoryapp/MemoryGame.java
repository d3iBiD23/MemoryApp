package com.example.memoryapp;

import javafx.scene.layout.VBox;

public class MemoryGame extends VBox {
    private GameBoard gameBoard;

    public MemoryGame() {
        gameBoard = new GameBoard();
        getChildren().add(gameBoard);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
