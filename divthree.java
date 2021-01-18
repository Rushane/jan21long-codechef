/* 

  A Division-3 contest should have exactly K problems. 
  Chef wants to plan for the next D days using the problems that they have currently. But Chef cannot host more than one Division-3 contest in a day.
  Given these constraints, can you help Chef find the maximum number of Division-3 contests that can be hosted in these D days?

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


        
    // 	int size = s.nextInt();
       
       
        
        
        		// Read the number of test casese.		
		int T = in.nextInt();
		while (T-- > 0) {
    		int N = in.nextInt(); // number of setters
        	int K = in.nextInt(); // number of problems the contest should have
        	int D = in.nextInt(); // number of days
    	    int myArray[] = new int [N];
    	    int sum = 0;
    	    
			for(int i=0; i<N; i++){  // // number of problems actually created
                 myArray[i] = in.nextInt();
                 sum = sum + myArray[i];
            }
                
            int result = sum / K;
            
            if(result < D) {
                System.out.println(result);
            } else {
                System.out.println(D);
            }
		}
        
		
	}
	
// 	public int getMaxNumofContests()
	
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
