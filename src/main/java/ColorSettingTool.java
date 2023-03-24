import java.text.DecimalFormat;
import java.util.*;

public class ColorSettingTool {
    //I guess im doing a CLI for now.
    private Console console = new Console();
    private List<Color> holds=new ArrayList<>();

    public static void main(String[] args) {
        ColorSettingTool colorSettingTool = new ColorSettingTool();
        colorSettingTool.run();
    }

    public void run(){
        askUserForHolds();
    }

    //main workflow
    public void askUserForHolds(){
        while(true){
            console.chooseColorType();
            String userResponse = console.promptForResponse("");
            if(userResponse.equals("1")){
                holds.add(enterRGBColor());
            } else if(userResponse.equals("2")){
                holds.add(enterHexaColor());
            } else if(userResponse.equals("3")) {
                printListOfHolds(holds);
            } else if (userResponse.equals("4")){
                sortColorMenu();
            } else if(userResponse.equals("5")){
                System.out.println("");
                System.out.println("Color one:");
                Color a = enterRGBColor();
                System.out.println("");
                System.out.println("Color two:");
                Color b = enterRGBColor();
                System.out.println("difference between colors:");
                System.out.println(redMeanColorDifference(a,b));
            }else if(userResponse.equals("9")){
                createTestData();
            }else if(userResponse.equals("0")){
                break;
            } else {
                System.out.println("Please choose a valid response.");
            }
        }
    }

    //choose which way to sort holds. should result in a list of colors in the correct order
    private void sortColorMenu(){
        console.colorSortingOptions();
        String userResponse = console.promptForResponse("");
        if(userResponse.equals("1")){
            List<Color> sortedList = sortByMinValue(Integer.parseInt(console.promptForResponse("What is the minimum difference between colors that you want?")));
            printListOfHolds(sortedList);
        } else if(userResponse.equals("2")){

        } else {
            System.out.println("Please choose a valid response.");
        }
    }

    //algorithm to sort list of colors and stores in main list
    private List<Color> sortByMinValue(int minValue){
        List<Color> sortedListOfColors = new ArrayList<>();
        sortedListOfColors.add(holds.get(0));
        for(int i=1; i<holds.size(); i++){
            int colorDifference = redMeanColorDifference(sortedListOfColors.get(0), holds.get(i));;
            if(colorDifference>minValue){
                sortedListOfColors.add(holds.get(i));
                break;
            }
        }
        return sortedListOfColors;
    }

    private List<Color> sortToMaximizeDifferenceBetweenColors(){
        List<Color> sortedListOfColors = new ArrayList<>();
        

        return sortedListOfColors;
    }

    //add new color using RGB values
    private Color enterRGBColor(){
        int red = Integer.parseInt(console.promptForResponse("What is the red value?"));
        int green = Integer.parseInt(console.promptForResponse("What is the green value?"));
        int blue = Integer.parseInt(console.promptForResponse("What is the blue value?"));
        Color color = new Color(red, green, blue);
        return color;
    }

    //add new color using hexadecimal value
    private Color enterHexaColor(){
        String hexadecimal = console.promptForResponse("What is the hexadecimal value of your color?");
        Color color = new Color(hexadecimal);
        return color;
    }

    //this prints a list of holds. may want to store in a database later but not sure
    private void printListOfHolds(List<Color> colorList){
        for(Color color: colorList){
            System.out.println(color.printRGB());
        }
    }

    //this seems to be the most accurate way to compare two colors using just RGB - consider using L*a*b* later
    private int redMeanColorDifference(Color one, Color two){
        int r1 = one.getRed();
        int g1 = one.getGreen();
        int b1 = one.getBlue();
        int r2 = two.getRed();
        int g2 = two.getGreen();
        int b2 = two.getBlue();
        double rBar = 0.5 * (r1+r2);
        double deltaC=Math.sqrt((2+(rBar/256))*Math.pow((r1-r2),2)+4*Math.pow((g1-g2),2)+(2+((255-rBar)/256))*Math.pow((b1-b2),2));
        return (int)(Math.round(deltaC));
    }

    private void createTestData(){
//        for(int i=0; i<=5; i++){
//            int random = (int)(Math.round(Math.random()*255));
//            Color color = new Color(random, random, random);
//            this.holds.add(color);
//        }

        Color color1 = new Color(0,0,0);
        Color color2 = new Color(10,10,10);
        Color color3 = new Color(20,20,20);
        Color color4 = new Color(30,30,30);
        Color color5 = new Color(40,40,40);

        holds.add(color1);
        holds.add(color2);
        holds.add(color3);
        holds.add(color4);
        holds.add(color5);

    }
}
