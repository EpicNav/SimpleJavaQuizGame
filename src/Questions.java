/** Created by Nav on 1/12/16. **/

import java.util.Scanner;
public class Questions {

    Scanner input = new Scanner(System.in);

    private int totalQuestions;
    private int lives;
    private int price;

    private void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getLives() {
        return lives;
    }

    private void setLives(int lives) {
        this.lives = lives;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    // Begin's the game.
    public void beginGame(int totalQuestions){
        setTotalQuestions(totalQuestions);
        setLives(3);
        setPrice(200);

        // Here you can add total questions, this loop will run for total number of questions.
        for(int i = 1; i <= getTotalQuestions(); i++){
            switch (i){
                case 1: question("Who was named 6th Hokage in Naruto?", "Naruto Uzumaki", "Tsunade Senju", "Kakashi Hatake", "Danzo", 'C', "Correct, Kakashi was named 6th hokage after the fouth great ninja war.");
                    break;
                case 2: question("What is the name of dragon who raised Natsu Dragneel in Fairy Tail?", "Matelicana", "Grandeeney", "Acnologia", "Igneel", 'D', "Right, Igneel is the name of fire dragon who raised Natsu");
                    break;
                case 3: question("Who was Gol D. Roger?", "Bandit", "Pirate King", "Fish Man", "Scientist", 'B', "Yes, Gol D. Roger was the Pirate King");
                    break;
                case 4: question("What is Rias Gremory?", "Fallen Angel", "Angel", "Devil", "Human", 'C', "Correct, Rias Gremory is the Devil.");
                    break;
                case 5: question("Who is son of Dragon in One Piec?", "Roronoa Zoro", "Vinsmoke Sanji", "Monkey D. Garp", "Monkey D. Lufy", 'D', "Right, Luffy is the son of Monkey D. Dragon");
                    break;
                default:
                    System.out.println("Hello, World!");
            }
            // Once player has answered all the questions this will be executed
            if(i == getTotalQuestions()){
                System.out.println("Congratulations, on completing the game");
                System.exit(0);
            }
        }

    }

    private void question(String Question, String optionA, String optionB, String optionC, String optionD, char correctOption, String messageOnFinish){
        char option;
        System.out.println("$: " + getPrice() + "       Lives: " + getLives());
        System.out.println(Question); // Prints the question...
        System.out.println("A: " + optionA + "\nB: " + optionB + "\nC: " + optionC + "\nD: " + optionD); // Prints the outputs for the user.

        // Continues to loop till the user enters the correct option or runs out of lives.
        do{
            System.out.println("Enter your answer.");

            option = input.next().charAt(0); // Asks for input option

            if(option == correctOption){
                setPrice(getPrice() + getPrice() / 100 * 25); // Price increases by 25% for every correct answer
                continue; // Exits the loop if answer is correct
            }else{
                if(getLives() > 0 && getPrice() > 0){
                    System.out.println("Wrong answer, please try again.");
                    setLives(getLives() - 1); // Loses lives if the answer is wrong
                    setPrice(getPrice() - getPrice() / 100 * 20); // Loses 5% of total price for every wrong answer
                }else{
                    if(getPrice() <= 0){
                        System.out.println("Oops... you don't have enough money to continue.");
                    }else{
                        System.out.println("Oops... you don't have enough lives to continue.");
                    }
                    // If out of lives and still didn't answer correctly the game exits
                    System.exit(0);
                }
            }
        }while (option != correctOption);

        System.out.println(messageOnFinish);  // Prints the finish message

    }
}
