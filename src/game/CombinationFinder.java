package game;

import cards.Card;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class finding the shortest combination of commands to get from a starting situation to a goal situation.
 * @author Corentin L. / Seweryn C.
 */

public class CombinationFinder {
    /** The starting situation */
    private final Card startingSituation;

    /** The goal situation that we find the combination for */
    private final Card goalSituation;

    /**
     * Enum representing the possible commands in the game
     */
    public enum POSSIBLE_COMMANDS {
        /** KI command : Move the top animal of the blue podium to the top of the red podium */
        KI,

        /** LO command : Move the top animal of the red podium to the top of the blue podium */
        LO,

        /** NI command : Move the bottom animal of the blue podium to the top of the blue podium */
        NI,

        /** MA command : Move the bottom animal of the red podium to the top of the red podium */
        MA,

        /** SO command : Swaps top of red with top of blue podiums */
        SO;

        /**
         * String representation of the enum
         * @return Associated string
         */
        @Override
        public String toString() {
            return name();
        }
    }

    /**
     * Constructor of the class
     * @param startingSituation The starting situation
     * @param goalSituation The goal situation
     */
    public CombinationFinder(Card startingSituation, Card goalSituation) {
        this.startingSituation = startingSituation;
        this.goalSituation = goalSituation;
    }

    /**
     * Applies all commands in the combination to the starting situation, and returns the resulting copy cards
     * @param combination The combination of commands to apply
     * @return The resulting copy cards after applying all commands in the combination to the starting situation,
     * or null if the combination is invalid (throws an exception)
     */
    public Card applyAllCommands(String combination) {
        try {
        Card temp = new Card(startingSituation);
        for (String subCommand : combination.split("(?<=\\G.{2})"))
            if (subCommand.length() == 2)
                temp.executeCommand(subCommand);
        return temp;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Finds the shortest combination of commands to get from the starting situation to the goal situation
     * @return The shortest combination of commands to get from the starting situation to the goal situation
     */
    public String findCombination() {
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        do {
            String currentCombination = queue.poll();
            for (POSSIBLE_COMMANDS command : POSSIBLE_COMMANDS.values()) {
                if (isCommandPossible(command, currentCombination)) {
                    String newCombination = currentCombination + command;
                    Card newCardWithCombination = applyAllCommands(newCombination);
                    if (newCardWithCombination != null) {
                        if (newCardWithCombination.equals(goalSituation))
                            return newCombination;
                        if (!newCardWithCombination.equals(startingSituation))
                            queue.add(newCombination);
                    }
                }
            }
        } while (!queue.isEmpty());
        return null;
    }

    /**
     * Checks if the command is possible to apply on the current combination
     * @param command To check
     * @param currentCombination To check
     * @return true if the command is possible to apply on the current combination, false otherwise
     */
    public boolean isCommandPossible(POSSIBLE_COMMANDS command, String currentCombination) {
        Card temp;
        if (currentCombination.length() > 2)
            temp = applyAllCommands(currentCombination);
        else
            temp = startingSituation;
        switch (command) {
        case KI:
            return temp.canKI();
        case LO:
            return temp.canLO();
        case NI:
            return temp.canNI();
        case MA:
            return temp.canMA();
        case SO:
            return temp.canSO();
        default:
            return false;
        }
    }
}