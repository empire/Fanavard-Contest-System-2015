package com.fanavard.challenge.client.cli.states;

import com.fanavard.challenge.client.cli.options.AbstractOptionsCollection;
import com.fanavard.challenge.core.commands.Commander;
import com.fanavard.challenge.core.model.NewGameCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
@Scope("singleton")
public class NewGameState implements State {
    @Autowired
    ApplicationContext context;

    private int numberOfPlayers;

    @Override
    public AbstractOptionsCollection getOptions() {
        return new AbstractOptionsCollection() {
            @Override
            protected State getSelectedState(Commander commander) {
                commander.sendAsyncCommand(new NewGameCommand(numberOfPlayers));
                return context.getBean(StartState.class);
            }

            @Override
            protected boolean getValidInputFromUser() {
                showIntro();
                return getNumberOfPlayers();
            }
        };
    }

    private void showIntro() {
        System.out.print("Number of players: ");
    }

    private boolean getNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
            boolean integerAvailable = scanner.hasNextInt();
            if (integerAvailable) {
                numberOfPlayers = scanner.nextInt();
            }
            return integerAvailable;
    }
}
