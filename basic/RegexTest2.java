import java.util.regex.*;
import java.util.*;

public class RegexTest2{

	
	private static String expression = "(?:(SSN:|SSN).{0,5}(\\d{3}-\\d{2}-\\d{4}))|(?:(\\d{3}-\\d{2}-\\d{4}).{0,5}(SS#|SSN))";
	private static String expression2 = "((SSN:|SSN)(?:.{0,5})(\\d{3}-\\d{2}-\\d{4}))|((\\d{3}-\\d{2}-\\d{4})(?:.{0,5})(SS#|SSN))";
	private static String expression3 = "((?<name1>SSN:|SSN)(?:.{0,5})(?<name1>\\d{3}-\\d{2}-\\d{4}))|((\\d{3}-\\d{2}-\\d{4})(?:.{0,5})(SS#|SSN))";

	private static String text = "SSN: is 333-22-4444";
	private static String text2 = "333-22-4444 is SSN:";
	
	public static void main(String[] args) {

        List<String> list;
        
        System.out.println("");
        System.out.println(text);
	    list = getMatches(expression, text);
	    System.out.println("-----------------------");
	    System.out.println("Complete Match");
	    printMatches(list, false);
	    System.out.println("Capturing Groups");
	    printMatches(list, true);

	    System.out.println("");
        System.out.println(text);
	    list = getMatches(expression, text2);
	    System.out.println("-----------------------");
	    System.out.println("Complete Match");
	    printMatches(list, false);
	    System.out.println("Capturing Groups");
	    printMatches(list, true);
	    
	    System.out.println("");
        System.out.println(text);
	    list = getMatches(expression2, text);
	    System.out.println("-----------------------");
	    System.out.println("Complete Match");	    
	    printMatches(list, false);
	    System.out.println("Capturing Groups");
	    printMatches(list, true);
	    
	    System.out.println("");
        System.out.println(text);
	    list = getMatches(expression2, text2);
	    System.out.println("-----------------------");
	    System.out.println("Complete Match");	    
	    printMatches(list, false);
	    System.out.println("Capturing Groups");
	    printMatches(list, true);
	    
	    System.out.println("");
	    System.out.println("Exception Examples");
	    getMatches(expression3, text);
	    getMatches(expression3, text2);
	}

	public static List<String> getMatches(String expression, String text)
	{
	    
	    List<String> allMatches = new ArrayList<String>();
	    Pattern p = null;
		Matcher m = null;
		
		try {
		    p = Pattern.compile(expression);
		    m = p.matcher(text);
		    
		    String result = "";
		    while (m.find()){

    			int i = 0;
    			
    			while (i <= m.groupCount()) 
    			{
    			      String subsequence = m.group(i);
    			      if (subsequence != null)
    			      {
    			        allMatches.add(i + " " + m.group(i));
    			      }
    			      
    			      i++;
    			}
		    }
		}
		catch (PatternSyntaxException e) {
		    System.out.println(e);
		}

		return allMatches;
	}
	
	public static void printMatches(List<String> list, Boolean useCapturingGroups) {
	    
	    if (list.size() > 0) {
    	    if (useCapturingGroups == false){
    	        System.out.println(list.get(0));
    	    }
    	    else {
    	        list.remove(0);
    	        String s = String.join("; ",list);
    	        System.out.println(s);
    	    }
	    }
	    else
	    {
	        System.out.println("");
	    }
	}
}
