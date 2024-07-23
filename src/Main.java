import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
        Preloader loader = new Preloader();
        Tester tests = new Tester();
        Scanner reader = new Scanner(System.in);
        loader.load();
        
        System.out.println("\n\nHi, Welcome to Generic Library System (GLS)!");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("In this code we did a test focus application, so since you are here let's get a roll!");
        TimeUnit.SECONDS.sleep(6);
        Integer i = 0;

        while(i != 9){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("\n1-User Test\n2-Loan Test");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("3-Search Book Test\n4-Search User Test");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("5-Book Category Test\n9-Exit :(\n\nChoose a option:");
            i = reader.nextInt();

            if(i == 1){
                tests.userTest();
            }
            else if(i == 2){
                tests.loanTest();
            }
            else if (i == 3){
                tests.searchBookTest();
            }
            else if (i == 4){
                tests.searchUserTest();
            }
            else if (i == 5){
                tests.categoryTest();
            }

        }
        reader.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("See you soon! :D");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Goodbye!");
        TimeUnit.SECONDS.sleep(1);

    }

}
