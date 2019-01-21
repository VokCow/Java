import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
This script takes a sentence that can contain repeated words and returns the sentcence containing only the non different words.
This could be achieved by spliting the input String and turning the resulting Array into a set to avoid repetition. Instead here an
approach based on regular expression is used, that can be less expensive when working with very big files.
*/

public class RepeatedWord {
	
    public static void main(String[] args) {

       String regex = "(\\b\\w+\\b)(\\s+\\1)+";
       String regex2 = "\\b(\\w+)(\\s+\\1\\b)+";
       Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
       String input1 = "Goodbye bye bye world world world";
       String input2 = "Bob went to to to his job";

            Matcher m1 = p.matcher(input1);   
          // Check for subsequences of input that match the compiled pattern
            while (m1.find()) {
                //System.out.println(m1.group(0));
                //System.out.println(m1.group(1));
            	input1 = input1.replaceAll(m1.group(0),m1.group(1));
            }
            // Prints the modified sentence.
            System.out.println("final input: " + input1);
            Matcher m2 = p.matcher(input2);   
            while (m2.find()) {
            	 //System.out.println(m2.group(0));
                 //System.out.println(m2.group(1));
            	 input2 = input2.replaceAll(m2.group(0),m2.group(1));
            }         
            System.out.println("final input: " + input2);
    }
	
}
