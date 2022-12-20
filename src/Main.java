import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        System.out.println(calc(line));
    }

    public static String calc(String line) throws IOException {
        String r="";
        try {

            boolean rim[] = new boolean[2];
            line = line.replaceAll(" ", "");
            String line2 = line;
            line2 = line2.replaceAll("[+]", " ");
            line2 = line2.replaceAll("-", " ");
            line2 = line2.replaceAll("[*]", " ");
            line2 = line2.replaceAll("/", " ");
            String[] numbers = line2.split(" ");
            String[] signs = (line.replaceAll("[0-9,I,II,III,IV,V,VI,VII,VIII,IX,X]", "")).split("");

            for (int i = 0; i < 2; i++) {
                switch (numbers[i]) {
                    case "I":
                        numbers[i] = "1";
                        rim[i] = true;
                        break;
                    case "II":
                        numbers[i] = "2";
                        rim[i] = true;
                        break;
                    case "III":
                        numbers[i] = "3";
                        rim[i] = true;
                        break;
                    case "IV":
                        numbers[i] = "4";
                        rim[i] = true;
                        break;
                    case "V":
                        numbers[i] = "5";
                        rim[i] = true;
                        break;
                    case "VI":
                        numbers[i] = "6";
                        rim[i] = true;
                        break;
                    case "VII":
                        numbers[i] = "7";
                        rim[i] = true;
                        break;
                    case "VIII":
                        numbers[i] = "8";
                        rim[i] = true;
                        break;
                    case "IX":
                        numbers[i] = "9";
                        rim[i] = true;
                        break;
                    case "X":
                        numbers[i] = "10";
                        rim[i] = true;


                }
            }
            if(!rim[0]){
            if((Integer.parseInt(numbers[0])>10)||(Integer.parseInt(numbers[1])>10)){
                throw new Exception();
            }
            }
            int result = calculation((Integer.parseInt(numbers[0])), (Integer.parseInt(numbers[1])), signs[0]);
            if ((numbers.length > 2) || (signs.length > 1)) {
                throw new Exception();
            }

            if (rim[0] ^ rim[1]) {
                throw new Exception();

            }
            if (rim[0]) {
                if (result < 1) {
                    throw new Exception();
                }
            }

            if (rim[1]) {
                r= (rim(result));
            } else {
                r= Integer.toString(result);
            }

        }
        catch (Exception e){
            System.out.println("Ошибка");
        }
        return r;

    }
    public static int calculation(int num1, int num2, String signs) {
        int result = 0;

        switch (signs) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;

    }


    public static String rim(int num){
        int i;
        String result="";
        if (num/100==1){
            result="C";
            num%=100;

        }
        if ((i=num/10)>0){
            if (i==9){
                result+="XC";
            }
            else
            if(i>=5){
                result+="L";
                for(int j=0;j<i-5;j++){
                    result+="X";
                }
            }
            else if (i==4) {
                result+="XL";
            }
            else if (i<5) {
                for(int j=0;j<i;j++){
                    result+="X";
                }
            }
            num%=10;
        }
        if ((i=num/1)>0){
            if(i==9){
                result+="IX";
            }
            else
            if(i>5){
                result+="V";
                for(int j=0;j<i-5;j++){
                    result+="I";
                }
            }
            else if (i==4) {
                result+="IV";
            }
            else if (i<5) {
                for(int j=0;j<i;j++){
                    result+="I";
                }
            }
        }
        return result;
    }


}