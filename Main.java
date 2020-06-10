import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main{

  public static void main(String[] args) {
    String text = new String();
    if (args.length == 0) {
      text = ReadFile("txt/test.txt"); // FleschReadingEaseScore: 66.4
                                       // FleschKincaidScore: 5.24
    }
    else{
      text = ReadFile(args[0]);
    }
    BothScores(text);
  }

  public static void BothScores(String text){
    double FleschReadingEaseScore = Utilities.FleschReadingEaseScore(text);
    System.out.println("Flesch Reading Ease Score is " + FleschReadingEaseScore);
    double FleschKincaidScore = Utilities.FleschKincaidScore(text);
    System.out.println("Flesch-Kincaid Score is " + FleschKincaidScore);
  }

  public static String ReadFile(String filename){
    String file = new String();
    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        file += myReader.nextLine() + " ";
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return file;
  }
}
