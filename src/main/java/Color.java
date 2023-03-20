public class Color {
    //this class defines a color as RGB
    //might want to add method to go from english color names to RGB but would be tedious.

    private int red;
    private int green;
    private int blue;

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    //can instantiate color using RGB
    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    //can instantiate color using hexadecimal
    public Color(String color){
        int[] rgb = hexToRGB(color);
        this.red = rgb[0];
        this.green=rgb[1];
        this.blue=rgb[2];
    }

    //converts from hexadecimal color to RGB
    private int[] hexToRGB(String hexadecimal){
        int red = hexToDecimal(hexadecimal.substring(0,2));
        int green = hexToDecimal(hexadecimal.substring(2,4));
        int blue = hexToDecimal(hexadecimal.substring(4,6));
        int[] rgb = {red, green, blue};
        return rgb;
    }

    //takes two character string that represents hexadecimal number and puts it into decimal
    private int hexToDecimal(String hexadecimal){
        int number = 0;
        int output = 0;
        for(int i=0; i<hexadecimal.length(); i++) {
            switch (hexadecimal.substring(i, i + 1)) {
                case "0":
                    number = 0;
                    break;
                case "1":
                    number = 1;
                    break;
                case "2":
                    number = 2;
                    break;
                case "3":
                    number = 3;
                    break;
                case "4":
                    number = 4;
                    break;
                case "5":
                    number = 5;
                    break;
                case "6":
                    number = 6;
                    break;
                case "7":
                    number = 7;
                    break;
                case "8":
                    number = 8;
                    break;
                case "9":
                    number = 9;
                    break;
                case "A":
                    number = 10;
                    break;
                case "B":
                    number = 11;
                    break;
                case "C":
                    number = 12;
                    break;
                case "D":
                    number = 13;
                    break;
                case "E":
                    number = 14;
                    break;
                case "F":
                    number = 15;
                    break;
            }
            number = (int)(number * (Math.pow(16,(1-i))));
            output+=number;
        }
        return output;
    }
}
