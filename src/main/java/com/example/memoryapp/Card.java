package com.example.memoryapp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.InputStream;

public class Card extends StackPane {
    private String cardId;  // Renombramos la variable para evitar conflictos
    private ImageView frontImage;
    private ImageView backImage;
    private boolean flipped = false;
    private boolean matched = false;

    public Card(String id, String imagePath) {
        this.cardId = id;

        // Use getResourceAsStream with absolute path
        InputStream frontImageStream = getClass().getResourceAsStream(imagePath);
        InputStream backImageStream = getClass().getResourceAsStream("/images/back.png");

        if (frontImageStream == null || backImageStream == null) {
            throw new RuntimeException("Image resources not found: " + imagePath + " or back.png");
        }

        frontImage = new ImageView(new Image(frontImageStream));
        backImage = new ImageView(new Image(backImageStream));

        frontImage.setVisible(false);
        getChildren().addAll(backImage, frontImage);

        setOnMouseClicked(this::flipCard);
    }

    private void flipCard(MouseEvent event) {
        if (!matched) {
            flipped = !flipped;
            frontImage.setVisible(flipped);
            backImage.setVisible(!flipped);
        }
    }

    public String getCardId() {
        return cardId;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public void reset() {
        flipped = false;
        frontImage.setVisible(false);
        backImage.setVisible(true);
    }
}