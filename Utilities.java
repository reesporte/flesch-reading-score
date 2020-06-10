import java.util.ArrayList;
import java.lang.Math;

public class Utilities{
  /*
  Consider a String to be a word, and an ArrayList<String> as a sentence
  */

  public static Double FleschKincaidScore(String text){
    ArrayList<ArrayList<String>> sentences= Utilities.Sentencify(text);
    return Math.floor(((0.39 * AverageSentenceLength(sentences)) + (11.8 * AverageSyllables(sentences)) - 15.59)*100)/100;
  }
  public static Double FleschReadingEaseScore(String text){
    ArrayList<ArrayList<String>> sentences= Utilities.Sentencify(text);
    return Math.floor((206.835 - (1.015 * AverageSentenceLength(sentences)) - (84.6 * AverageSyllables(sentences))) * 100)/100;
  }

  public static void Debug(ArrayList<ArrayList<String>> sentences){
    /* useful for debugging */
    int num_sentences = sentences.size();
    double avg_sentence_len = AverageSentenceLength(sentences);
    double avg_syllables = AverageSyllables(sentences);
    double num_words = (avg_sentence_len * num_sentences);

    System.out.println("Avg Sentence length: " + avg_sentence_len);
    System.out.println("Number of Sentences: " + num_sentences);
    System.out.println("Number of Words: " + num_words);
    System.out.println("Number of Syllables:" + (num_words * avg_syllables));
  }

  private static ArrayList<ArrayList<String>> Sentencify(String text){
    /* takes in a string and returns an ArrayList of "sentences" */
    ArrayList<ArrayList<String>> sentences = new ArrayList<ArrayList<String>>();
    ArrayList<String> split = SpaceChunk(text);

    ArrayList<String> sentence = new ArrayList<String>();
    boolean first = true;
    for (String word : split){
      if (!EndsSentence(word) && first) {
        // first word
        sentence.add(word);
        first = false;
      }
      else if(!EndsSentence(word)) {
        // middle word
        sentence.add(" " + word);
      }
      else if(EndsSentence(word) && first){
        // one word sentence
        sentence.add(word);
        sentences.add(sentence);
        sentence = new ArrayList<String>();
      }
      else{
        // last word in sentence
        sentence.add(" " + word);
        sentences.add(sentence);
        sentence = new ArrayList<String>();
        first = true;
      }
    }

    return sentences;
  }

  private static Double AverageSentenceLength(ArrayList<ArrayList<String>> sentences){
    /* get the average sentence length for a given text */
    double num_words = 0.0;
    for (ArrayList<String> sentence : sentences ) {
      num_words += sentence.size();
    }
    return (num_words/sentences.size());
  }

  private static Double AverageSyllables(ArrayList<ArrayList<String>> sentences){
    /* get the average syllables per word for a given text */
    double num_words = 0.0;
    double num_syllables = 0.0;
    for (ArrayList<String> sentence : sentences ) {
      num_words += sentence.size();
      for (String word : sentence ) {
        num_syllables += SyllableCount(word);
      }
    }

    return (num_syllables/num_words);
  }

  private static Integer SyllableCount(String word){
    /* counts syllables in an English word */
    int syllable_count = 0;
    boolean was_vowel = false; // don't count vowels that are next to each other twice
    for (char letter : word.toCharArray() ) {
      if (isVowel(letter) && !was_vowel) {
        syllable_count += 1;
        was_vowel = true;
      }
      else{
        was_vowel = false;
      }
    }
    return syllable_count;
  }

  private static Boolean isVowel(char letter){
    // if Character.compare finds that they are equivalent, will return 0, so if result == 0, return true
    letter = Character.toUpperCase(letter);
    if (   (Character.compare(letter, 'A') == 0)
        || (Character.compare(letter, 'E') == 0)
        || (Character.compare(letter, 'I') == 0)
        || (Character.compare(letter, 'O') == 0)
        || (Character.compare(letter, 'U') == 0)
        || (Character.compare(letter, 'Y') == 0)){
      return true;
    }
    return false;
  }

  private static Boolean EndsSentence(String word){
    /* if word is a sentence ender, return True; */
    if (word.length() == 0) {
      return false;
    }
    char lastElement = word.charAt(word.length() - 1);
    return (((Character.compare(lastElement, '.')) == 0) || (Character.compare(lastElement, '!') == 0) || (Character.compare(lastElement, '?') == 0));
  }

  private static ArrayList<String> SpaceChunk(String text){
    /* split a string by spaces and put into a list */
    ArrayList<String> split = new ArrayList<String>();
    String[] chunks = text.split("[ \t\n]");

    for (String chunk : chunks ) {
      split.add(chunk);
    }

    return split;
  }

}
