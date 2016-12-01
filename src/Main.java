/** Created by Nav on 30/11/16. **/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("==========WELCOME TO ANIME QUIZ=========="); // Name of the game.
        Questions questions = new Questions(); // Creates object from another questions class
        System.out.println("Total questions you would like to be asked, select in range of 1 - 5");
        int totalQuestions;
        do {
            totalQuestions = input.nextInt();
            if(totalQuestions <= 10 && totalQuestions > 0){
                continue;
            }
        }while(totalQuestions > 10 || totalQuestions <= 0);

        questions.beginGame(totalQuestions);

    }

}
