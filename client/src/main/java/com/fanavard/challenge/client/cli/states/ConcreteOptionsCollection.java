package com.fanavard.challenge.client.cli.states;

import com.fanavard.challenge.client.cli.options.CliStateOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
public class ConcreteOptionsCollection extends AbstractOptionsCollection {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteOptionsCollection.class);

    private List<CliStateOption> options;
    private int choice;

    public ConcreteOptionsCollection(CliStateOption... options) {
        this.options = Arrays.asList(options);
    }

    @Override
    protected boolean getValidInputFromUser() {
        showOptions();
        choice = getUserChoice();
        logger.debug("User choice is {}", choice);

        return isValidChoiceIndex(choice);
    }

    @Override
    protected State getSelectedState() {
        return getStateByIndex(choice);
    }

    private boolean isValidChoiceIndex(int choice) {
        return choice >= 0 && choice < options.size();
    }

    private State getStateByIndex(int choice) {
        return options.get(choice).getState();
    }

    private void showOptions() {
        int optionIndex = 1;
        for (CliStateOption option: options) {
            System.out.println(optionIndex ++ + ". " + option.getMessage());
        }
    }

    private int getUserChoice() {
        System.out.print("Please give your choice: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt() - 1;
        }
        return -1;
    }
}
