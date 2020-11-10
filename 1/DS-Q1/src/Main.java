import java.io.*;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        App app = new App();
        try {
            app.startApp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class App {
    private LinkedList<Number> numbers = new LinkedList<Number>();


    public void addNumber(int numberToAdd , int times){
//        for (int i = 0 ; i<times ; i++){
//            numbers.add(numberToAdd);
//        }
        numbers.add(new Number(times,numberToAdd));
    }

    public void removeNumber(int times){
        for (int i = 0 ; i<numbers.size() ; i++){

            if(numbers.get(i).times > times){
                numbers.get(i).times -= times;
                break;

            } else if(numbers.get(i).times == times){
                numbers.remove(i);
                break;

            } else if(numbers.get(i).times < times){
                int newTimes =  times - numbers.get(i).times;
                numbers.remove(i);
                removeNumber(newTimes);
                break;
            }
        }
    }

    public void startApp() throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.valueOf(scanner.readLine());

        for (int i=0 ; i < c ; i++){
            //if(i==0)scanner.readLine();
            String[] inputLine = scanner.readLine().split(" ");

            if(inputLine[0].equals("+")){
                addNumber(Integer.valueOf(inputLine[1]),Integer.valueOf(inputLine[2]));
            }
            else if(inputLine[0].equals("-")){
                removeNumber(Integer.valueOf(inputLine[1]));
            }
            else if (inputLine[0].equals("?")){
                if(numbers.size()!=0)
                System.out.println(numbers.get(0).number);
                else System.out.println("empty");
            }

        }
    }
    class Number{
        private int times;
        private int number;

        public Number(int times, int number) {
            this.times = times;
            this.number = number;
        }

    }

}
