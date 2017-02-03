import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class TextReader {
    public static void main(String[] args) throws Exception {

        //Text file source: the same as your Java file directory
        Path path = Paths.get(System.getProperty("user.dir")).resolve("myText.txt");

        BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
        //Store all the words
        Map<String, Integer> frequency = new HashMap<>();
        //Store all different words
        Set<String> wordOfText = new HashSet<>();
        //Reading lines from the text
        String line = reader.readLine();
        int totalWords = 0;
        while (line != null) {
            if (!line.trim().equals("")) {
                //Testing if it actually read lines
                //System.out.println("Processing line: " + line);
                //Split all the words
                String[] words = line.split(" ");
                //Counting total words
                totalWords += words.length;

                for (String word : words) {
                    if (word == null || word.trim().equals("")) {
                        continue;
                    }
                    //Set all the words to lower case, and read only alphabet from a to z
                    String cleanedUpWord = word.toLowerCase()
                            .replaceAll("[^a-z]", "");
                    if (cleanedUpWord.length() != 0) {
                        //Add all the different words to HashSet
                        wordOfText.add(cleanedUpWord);
                        if (frequency.containsKey(cleanedUpWord)) {
                            //Add cleaned up word to HashMap, and increment each word if
                            frequency.put(cleanedUpWord, frequency.get(cleanedUpWord) + 1);
                        } else {
                            frequency.put(cleanedUpWord, 1);
                        }
                    }

                }
            }
            //Continue reading line
            line = reader.readLine();
        }

        //Print out the data
        System.out.println("The count for each word: \n" + frequency + "\n");
        System.out.println("Total words: " + totalWords + "\n");
        System.out.println("Total number of different words: " + wordOfText.size() + ", and they are: \n" + wordOfText + "\n");

    }
}