import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class file_io {

    public int num_sides_txt;
    public int num_dice_txt;
    public int num_rolls_txt;

    public int read_sides () throws FileNotFoundException{

        File file = new File("N:/storage/HW2(224_Yahtzee)/hw2-yahtzee-nathanBashant/yahtzeeConfig.txt");
        Scanner scan = new Scanner(file);

        num_sides_txt = scan.nextInt();
        num_dice_txt = scan.nextInt();
        num_rolls_txt = scan.nextInt();

        System.out.println("You are playing with " + num_dice_txt + " " + num_sides_txt + "-sided dice"); 
        System.out.println("You get " + num_rolls_txt + " rolls per hand"); 

        return num_sides_txt;
    }

    public int read_dice () throws FileNotFoundException{

        File file = new File("N:/storage/HW2(224_Yahtzee)/hw2-yahtzee-nathanBashant/yahtzeeConfig.txt");
        Scanner scan = new Scanner(file);

        num_sides_txt = scan.nextInt();
        num_dice_txt = scan.nextInt();
        num_rolls_txt = scan.nextInt();

        System.out.println(num_dice_txt);

        return num_dice_txt;
    }

    public int read_rolls () throws FileNotFoundException{

        File file = new File("N:/storage/HW2(224_Yahtzee)/hw2-yahtzee-nathanBashant/yahtzeeConfig.txt");
        Scanner scan = new Scanner(file);

        num_sides_txt = scan.nextInt();
        num_dice_txt = scan.nextInt();
        num_rolls_txt = scan.nextInt();

        System.out.println(num_rolls_txt);

        return num_rolls_txt;
    }
    



}


