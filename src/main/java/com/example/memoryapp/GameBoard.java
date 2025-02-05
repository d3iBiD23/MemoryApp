package com.example.memoryapp;

import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard extends GridPane {
    private static final int PAIRS = 6; // 6 pares (12 cartas)
    private List<Card> cards = new ArrayList<>();
    private Card firstCard = null;
    private Card secondCard = null;

    public GameBoard() {
        loadCards();
        Collections.shuffle(cards);

        int cols = 4;
        for (int i = 0; i < cards.size(); i++) {
            add(cards.get(i), i % cols, i / cols);
        }
    }

    private void loadCards() {
        for (int i = 1; i <= PAIRS; i++) {
            String imgPath = "/images/card" + i + ".png";
            cards.add(new Card(String.valueOf(i), imgPath));
            cards.add(new Card(String.valueOf(i), imgPath)); // Par
        }
    }

    public void checkMatch(Card card) {
        if (firstCard == null) {
            firstCard = card;
        } else {
            secondCard = card;
            if (firstCard.getCardId().equals(secondCard.getCardId())) {  // Usamos getCardId() en lugar de getId()
                firstCard.setMatched(true);
                secondCard.setMatched(true);
            } else {
                firstCard.reset();
                secondCard.reset();
            }
            firstCard = null;
            secondCard = null;
        }
    }
}