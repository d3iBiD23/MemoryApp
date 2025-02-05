package com.example.memoryapp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Card extends StackPane {
    private String id;
    private ImageView frontImage;
    private ImageView backImage;
    private boolean flipped = false;
    private boolean matched = false;

    public Card(String id, String imagePath) {
        this.id = id;

        frontImage = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        backImage = new ImageView(new Image(getClass().getResourceAsStream("/images/back.png")));

        frontImage.setVisible(false); // Empieza oculta
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

    public String getId() {
        return id;
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
