/* 
	An encoder encodes the first 16 lowercase English letters using 4 bits each. 
	The first bit (from the left) of the code is 0 if the letter lies among the first 8 letters, else it is 1, signifying that it lies among the last 8 letters. 
	The second bit of the code is 0 if the letter lies among the first 4 letters of those 8 letters found in the previous step, else it's 1, signifying that it 
	lies among the last 4 letters of those 8 letters. Similarly, the third and the fourth bit each signify the half in which the letter lies.

	Source:https://www.codechef.com/JAN21C/problems/DECODEIT
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		InputStream inputStream = System.in;

		InputReader in = new InputReader(inputStream);
		
		String encoderArray = "abcdefghijklmnop";
		
		// Get the List of Character 
        List<Character> encodedArray = convertStringToCharList(encoderArray); 

		 		// Read the number of test casese.		
		int T = in.nextInt();
		while (T-- > 0) {
    		int N = in.nextInt(); // length of encoded string
        	String S = in.next(); // encoded string
        	
            List<Character> encodedString = convertStringToCharList(S);
            List<Character> encodedStringOne = encodedString.subList(0, encodedString.size()/2);
            List<Character> encodedStringTwo = encodedString.subList(encodedString.size()/2, encodedString.size());

            String result = "";
            String resultOne = "";
            String resultTwo = "";
            if(N>4) {
                 for(int v = 0;  v < N/2; v +=4) {
                    resultOne += encodeTheString(encodedStringOne.subList(v, v + 4), encodedArray);
                }
            
                for(int m = 0;  m <N/2; m +=4) {
                    resultTwo += encodeTheString(encodedStringTwo.subList(m, m + 4), encodedArray);
                }

        	    System.out.println(resultOne + resultTwo);
            } else {
                for(int v = 0;  v < N; v +=4) {
                    result += encodeTheString(encodedString.subList(v, v + 4), encodedArray);
                }
                
                System.out.println(result);
            }
           
 	
		}
	}
	
	public static Character encodeTheString(List<Character> oneEncoderString, List<Character> firstSixteenLetters) {
	    if(firstSixteenLetters.size() == 1) {
	        return firstSixteenLetters.get(0);
	    }

	    if(Integer.parseInt(String.valueOf(oneEncoderString.get(0))) == 0) {
	       List<Character> newArray = oneEncoderString.subList(1, oneEncoderString.size());

	       return encodeTheString(newArray, firstSixteenLetters.subList(0, firstSixteenLetters.size()/2));
	    } else {
	        List<Character> newArray = oneEncoderString.subList(1, oneEncoderString.size());
	        return encodeTheString(newArray, firstSixteenLetters.subList(firstSixteenLetters.size()/2, 
	        firstSixteenLetters.size()));
	    }
	    
	    
	    
	}
	
	// Function to convert String 
    // to List of Characters 
    public static List<Character> 
    convertStringToCharList(String str) 
    { 
  
        // Create an empty List of character 
        List<Character> chars = new ArrayList<>(); 
  
        // For each character in the String 
        // add it to the List 
        for (char ch : str.toCharArray()) { 
  
            chars.add(ch); 
        } 
  
        // return the List 
        return chars; 
    } 
	
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
				    tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
				    throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
 

		

	}
}
