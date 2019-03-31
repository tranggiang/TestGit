package streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountLongWords
{
   public static void main(String[] args) throws IOException
   {
      String contents = new String(Files.readAllBytes(
            Paths.get("resource/alice30.txt")), StandardCharsets.UTF_8);
      List<String> words = Arrays.asList(contents.split("\\PL+"));

      System.out.println("Number of words: " + words.size());
      long count = 0;
      for (String w : words)
      {
         if (w.length() > 12) count++;
      }
      System.out.println(count);

      count = words.stream().filter(w -> w.length() > 12).count();
      System.out.println(count);

      count = words.parallelStream().filter(w -> w.length() > 12).count();
      System.out.println(count);
      
      
      
      List<String> colectors = words.stream().filter(w -> w.length() > 12).collect(Collectors.toList());
      System.out.println("word leng > 12 "  +  colectors.toString());
       System.out.println("word leng > 12 "  +  colectors.toString());
	    System.out.println("this word form user2 " );
   }
}
