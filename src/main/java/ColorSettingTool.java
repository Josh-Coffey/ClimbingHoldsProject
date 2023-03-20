import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColorSettingTool {
    //I guess im doing a CLI for now.
    private Scanner userInput = new Scanner(System.in);
    private List<Color> holds=new ArrayList<>();

    public static void main(String[] args) {
        ColorSettingTool colorSettingTool = new ColorSettingTool();
        colorSettingTool.run();
    }

    public void run(){
        askUserForHolds();
    }

    public void askUserForHolds(){
        while(true){
            System.out.println("How do you want to enter your color?");
            System.out.println("(1) RGB");
            System.out.println("(2) hexadecimal");
            System.out.println("(3) exit");
            System.out.println("(4) print list of colors");
            String userResponse = userInput.nextLine();
            if(userResponse.equals("1")){
                System.out.println("What is the red value?");
                int red = Integer.parseInt(userInput.nextLine());
                System.out.println("What is the green value?");
                int green = Integer.parseInt(userInput.nextLine());
                System.out.println("What is the blue value?");
                int blue = Integer.parseInt(userInput.nextLine());
                Color color = new Color(red, green, blue);
                holds.add(color);
            } else if(userResponse.equals("2")){
                System.out.println("What is the hexadecimal value of your color?");
                String hexadecimal = userInput.nextLine();
                Color color = new Color(hexadecimal);
                holds.add(color);
            } else if(userResponse.equals("3")) {
                break;
            } else if(userResponse.equals("4")){
                printListOfHolds();
            } else {
                System.out.println("Please choose a valid response.");
            }
        }
    }

    private void printListOfHolds(){
        for(Color color:holds){
            String rgb=""+color.getRed()+""+color.getGreen()+""+color.getBlue();
            System.out.println(rgb);
        }
    }

    private int redMeanColorDifference(Color one, Color two){
        int r1 = one.getRed();
        int g1 = one.getGreen();
        int b1 = one.getBlue();
        int r2 = two.getRed();
        int g2 = two.getGreen();
        int b2 = two.getBlue();
        double rBar = 0.5 * (r1+r2);
        double deltaC=Math.sqrt((2+rBar/256)*Math.pow((r1-r2),2)+4*Math.pow((g1-g2),2)+(2+(255-rBar)/256)*Math.pow((b1-b2),2));
        return (int)(Math.round(deltaC));
    }

    
}
