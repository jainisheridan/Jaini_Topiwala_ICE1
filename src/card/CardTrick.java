/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * @author Jaini Bhaveshbhai Topiwala
 * Student Id :- 991669857
 */
package card;

import java.util.Scanner;

public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        int[] randomValues = new int[7]; // Array to store random values
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            
            // Set random value for the card and store it in the array
            int randomValue = (int) (Math.random() * 13) + 1;
            randomValues[i] = randomValue;
            c.setValue(randomValue);
            //just for info - System.out.println(randomValue);
            
            // Set random suit for the card
            int randomSuitIndex = (int) (Math.floor(Math.random() * 4));
            c.setSuit(Card.SUITS[randomSuitIndex]);
            //just for info - System.out.println(randomSuitIndex);
            
            magicHand[i] = c;
        }
        
        // Add a hardcoded luckyCard
        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit("Hearts");
        
        // Ask the user to enter card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your card value (1-13): ");
        int userValue = scanner.nextInt();
        
        System.out.println("Enter your card suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.next();
        
        // Create user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // Search for the user's card value in randomValues
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getSuit().equalsIgnoreCase(userCard.getSuit()) && card.getValue() == userCard.getValue() || luckyCard.getValue() == userCard.getValue() && luckyCard.getSuit().equalsIgnoreCase(userCard.getSuit())){
                found = true;
                break;
            }
        }
        
        // Report the result
        if (found) {
            System.out.println("Congratulations! Your card value is in the magic hand.");
        } else {
            System.out.println("Sorry, your card value is not in the magic hand.");
        }
        
        scanner.close();
    }
}
