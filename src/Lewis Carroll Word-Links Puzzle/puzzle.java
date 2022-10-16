/*1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: yes
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: yes

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: yes

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: yes
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: yes
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: yes

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: yes
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: yes

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: 5
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: 10

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: yes

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: 10
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: 5

 Total Mark out of 100 (Add all the previous marks): 100
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class puzzle {
public static Object[] dictionary;
	public static void main(String[] args) {
		readDictionary();
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a comma separated list of words (or an empty list to quit): ");
		String inputList = userInput.nextLine();
		while(!inputList.isEmpty())
		{

			inputList = inputList.replaceAll(" ", "");
		    ArrayList<String> list = readWordList(inputList);
		  if(isUniqueList(list))
		  {
			  if(isWordChain(list))
			  {
				  System.out.print("Valid chain of words from Lewis Carroll's word-links game. \nEnter a comma separated list of words (or an empty list to quit): ");
				  inputList = userInput.nextLine();
			  }
			  else
			  {	  
				  System.out.print("Not a valid chain of words from Lewis Carroll's word-links game. \nEnter a comma separated list of words (or an empty list to quit): ");
				  inputList = userInput.nextLine();
			  }
		  }
		}
		
			System.out.print("You have entered an empty list.");		
		userInput.close();
	}
	
	public static void readDictionary()
	{  
		ArrayList<String> dict = new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("words.txt"));
			String line = null;
			while ((line = br.readLine()) != null) 
			{
				dict.add(line);
			}
	        br.close(); 
	        dictionary =dict.toArray();
		}
		catch(Exception e)
		{
		} 
	}
	
	public static ArrayList<String> readWordList(String userInput)
	{
		ArrayList<String> listOfWords = new ArrayList<>(Arrays.asList(userInput.split(",")));
		return listOfWords;
	}
	
	public static boolean isUniqueList(ArrayList<String> words)
	{
		Set<String> set = new HashSet<String>(words);
		if(set.size() < words.size())
		{
			return false;
		}
		else
			return true;
	}

	public static boolean isEnglishWord(String words)
	{
		if(Arrays.binarySearch(dictionary, words) >= 0)
		{
			return true;
		}
		else
			System.out.println("Input contains non-English word.");
	    return false;
	}
	
	public static boolean isDifferentByOne(String StringA, String StringB)
	{
		if(StringA.length() != StringB.length())
		{
			return false;
		}
		else
		{
			int difference = 0;
			char[] A = StringA.toLowerCase().toCharArray();
			char[] B = StringB.toLowerCase().toCharArray();
			for(int count = 0; count<StringB.length(); count++)
			{
				if(A[count]!=B[count])
				{
					difference++;
				}
			}
			if(difference>1)
				return false;
			else
				return true;	
		}
	}
	
	public static boolean isWordChain(ArrayList<String> words)
	{
		boolean isChain = true;
		int count1 = 0;
		int count2 = 1;
		String word1 = words.get(count1);
		String word2 = words.get(count2);
		while(count1<words.size()-1 && isChain)
		{
			if(isDifferentByOne(word1, word2))
			{
				if(isEnglishWord(word1) && isEnglishWord(word2))
				{
					count1++;
					count2++;
					if(count2<words.size())
					{
						word1 = words.get(count1);
						word2 = words.get(count2);
					}
				}
				else
					isChain = false;
			}
			else
				isChain = false;
		}
		if(isChain)
			return true;
		else
			return false;
	}
	
	
	
		
}

	
	
		 

