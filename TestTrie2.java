import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/*** 
 * This is an additional class created for the purpose of testing the class MyTrie.
 * 
 * Name: Michael Sault
 * Student Number: 8459820
 * Uottawa Email: msaul025@uottawa.ca
 * 
 *
 */
public class TestTrie2 {
    
   public static boolean cmpLexTest1(String a, String[] correct){
        String[] s = a.split("[,]+|[ ]+|[\\r\\n]+", 0);
        
        if(s.length != correct.length)
            return false;
        for(int i = 0; i < correct.length; i++)
            if(!correct[i].equals(s[i]))
                return false;
        return true;
    }  
   
   public static void Test1a(){
       System.out.println("-------------------------------------------");
       System.out.println("My Test1a\n");
       System.out.println("Test Inserting Very Large Valued Node");
       MyTrie tree = new MyTrie();
       
       System.out.println("Populating the trie:");
       boolean result;
       int cnt = 0; //counts insertion mistakes
       int counter = 0; //counts node mistakes
       
       System.out.println("Inserting 00000000000000000000000: " + (result = tree.insert("00000000000000000000000")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       
       if(tree.numNodes() != 24)
       {
           counter++;
           System.out.println("Wrong Answer, Expected 24, Given " + tree.numNodes());
       } else {
    	       System.out.println("Correct Answer:" + tree.numNodes() + " nodes");
       }
       System.out.println("Inserting 00000000000010000000000: " + (result = tree.insert("00000000000010000000000")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       System.out.println("Inserting 00001000000010000010000: " + (result = tree.insert("00001000000010000010000")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       System.out.println("Inserting 11111100000011101111111: " + (result = tree.insert("11111100000011101111111")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       System.out.println("Printing Strings in Lexicographical Order:");
       // Create a stream to hold the output
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       PrintStream ps = new PrintStream(baos);
       // IMPORTANT: Save the old System.out!
       PrintStream old = System.out;
       // Tell Java to use your special stream
       System.setOut(ps);
       // Print some output: goes to your special stream
       tree.printStringsInLexicoOrder();
       // Put things back
       System.out.flush();
       System.setOut(old);
       // Show what happened
       System.out.print(baos.toString());
       int lex = 0; //counts lex mistakes
       String[] correct = new String[]{"00000000000000000000000","00000000000010000000000","00001000000010000010000","11111100000011101111111"};
       if(!cmpLexTest1(baos.toString(), correct))
       {
           lex++;
           System.out.println("Wrong Answer (Lexicographical Order)");
           System.out.println("Expected: 00000000000000000000000,00000000000010000000000,00001000000010000010000,11111100000011101111111");
       }
       System.out.println("\nTest1 results:");
       System.out.println("Correct Answers (Inserting): " + (4-cnt) + "/4");
       System.out.println("Correct Answers (Number of Nodes): " + (1-counter) + "/1");
       System.out.println("Correct Answers (Lexicographical): " + (1-lex) + "/1");
       System.out.println("-------------------------------------------\n");
   }
   public static void Test2a(){
       System.out.println("-------------------------------------------");
       System.out.println("My Test2a\n");
       MyTrie tree = new MyTrie();  
       int counter = 0;
       int nod = 0;
       boolean result;
       int cnt = 0;
       System.out.println("Test Inserting The Same Tree Three Times");
       System.out.println("Inserting 010");
       tree.insert("010");
       System.out.println("Inserting 001");
       tree.insert("001");
       System.out.println("Inserting 0000");
       tree.insert("0000");
       System.out.println("Inserting 1");
       tree.insert("1");
       System.out.println("Inserting 0");
       tree.insert("0");
       
       System.out.println("Trying to insert 010 again: " + (result = tree.insert("010")));
       if(result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected false, Given " + result);
       }
       System.out.println("Trying to insert 001 again: " + (result = tree.insert("001")));
       if(result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected false, Given " + result);
       }
       System.out.println("Trying to insert 0000 again: " + (result = tree.insert("0000")));
       if(result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected false, Given " + result);
       }
       System.out.println("Trying to insert 1 again: " + (result = tree.insert("1")));
       if(result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected false, Given " + result);
       }
       System.out.println("Trying to insert 0 again: " + (result = tree.insert("0")));
       if(result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected false, Given " + result);
       }
       
       nod = 0;
       System.out.println("Number of Nodes: " + (nod = tree.numNodes()));
       if(nod != 9)
       {
           counter++;
           System.out.println("Wrong Answer, Expected 9, Given " + nod);
       }
       System.out.println("\nTest2 results:");
       System.out.println("Correct Answers (Repeated strings): " + (5-cnt) + "/5");
       System.out.println("Correct Answers (Number of nodes): " + (1-counter) + "/1");
       System.out.println("-------------------------------------------\n");
   }
   
   public static void Test3a(){
       System.out.println("-------------------------------------------");
       System.out.println("My Test3a\n");
       System.out.println("Test A Null TreeNode");
       System.out.println("Populating the trie:");
       MyTrie tree = new MyTrie();
       boolean result;
       int cnt = 0; //counts insertion mistakes
       int counter = 0; //counts node mistakes
       
       System.out.println("Inserting 0: " + (result = tree.insert("0")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       System.out.println("Inserting 000: " + (result = tree.insert("000")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       System.out.println("Inserting 01: " + (result = tree.insert("01")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       System.out.println("Inserting null: " + (result = tree.insert(null)));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       System.out.println("Inserting 0100: " + (result = tree.insert("0100")));
       if(!result)
       {
           cnt++;
           System.out.println("Wrong Answer, Expected true, Given " + result);
       }
       if(tree.numNodes() != 6)
       {
           counter++;
           System.out.println("Wrong Answer, Expected 6, Given " + tree.numNodes());
       } else {
    	       System.out.println("Correct Answer:" + tree.numNodes() + " nodes");
       }
       System.out.println("Printing Strings in Lexicographical Order:");
       // Create a stream to hold the output
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       PrintStream ps = new PrintStream(baos);
       // IMPORTANT: Save the old System.out!
       PrintStream old = System.out;
       // Tell Java to use your special stream
       System.setOut(ps);
       // Print some output: goes to your special stream
       tree.printStringsInLexicoOrder();
       // Put things back
       System.out.flush();
       System.setOut(old);
       // Show what happened
       System.out.print(baos.toString());
       int lex = 0; //counts lex mistakes
       String[] correct = new String[]{"0","000","01","0100"};
       if(!cmpLexTest1(baos.toString(), correct))
       {
           lex++;
           System.out.println("Wrong Answer (Lexicographical Order)");
           System.out.println("Expected: 0,000,01,0100");
       }
       System.out.println("\nTest1 results:");
       System.out.println("Correct Answers (Inserting): " + (4-cnt) + "/4");
       System.out.println("Correct Answers (Number of Nodes): " + (1-counter) + "/1");
       System.out.println("Correct Answers (Lexicographical): " + (1-lex) + "/1");
       System.out.println("-------------------------------------------\n");
       
   }
  
   public static void main(String[] args) {
	   
       Test1a();
       Test2a();
       Test3a();
   
   }
}
