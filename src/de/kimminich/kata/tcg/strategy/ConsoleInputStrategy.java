package de.kimminich.kata.tcg.strategy;

import de.kimminich.kata.tcg.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ConsoleInputStrategy implements Strategy {

    private static final Logger logger = Logger.getLogger(ConsoleInputStrategy.class.getName());

    @Override
    public Optional<Card> nextCard(int mana, List<Card> availableCards) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Optional.of(new Card(Integer.decode(br.readLine())));
        } catch (IOException e) {
            logger.severe("Could not read console input!");
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
