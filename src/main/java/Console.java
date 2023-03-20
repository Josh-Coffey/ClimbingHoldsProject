import java.util.Scanner;

public class Console {
    private Scanner userInput = new Scanner(System.in);

    public String promptForResponse(String prompt){
        System.out.print(prompt);
        return userInput.nextLine();
    }

    public void chooseColorType(){
        System.out.println("");
        System.out.println("How do you want to enter your color?");
        System.out.println("(1) RGB");
        System.out.println("(2) hexadecimal");
        System.out.println("(3) print list of colors");
        System.out.println("(4) sort colors");
        System.out.println("(5) compare two colors");
        System.out.println("(0) exit");
    }

    public void colorSortingOptions(){
        System.out.println("");
        System.out.println("How do you want to sort your holds?");
        System.out.println("(1) minimum difference between adjacent colors");
        System.out.println("(2) maximize difference between hold colors");
    }

}

