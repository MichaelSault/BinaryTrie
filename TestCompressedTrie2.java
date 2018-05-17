import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*** 
 * This is an additional class created for the purpose of testing the class MyCompressedTrie.
 * 
 * Name: Michael Sault
 * Student Number: 8459820
 * Uottawa Email: msaul025@uottawa.ca
 * 
 *
 */


public class TestCompressedTrie2 {
    
    public static boolean cmpLexTest1(String a, String[] correct)
    {
        String[] s = a.split("[,]+|[ ]+|[\\r\\n]+", 0);
        
        if(s.length != correct.length)
            return false;
        for(int i = 0; i < correct.length; i++)
            if(!correct[i].equals(s[i]))
                return false;
        return true;
    }
    
    public static void Test1()
    {
        System.out.println("-------------------------------------------");
        System.out.println("Test1b\n");
        MyTrie tree = new MyTrie();
        System.out.println("Populating the trie with: 111, 01, 0, null, 000, 011, 0101");
        tree.insert("111");
        tree.insert("01");
        tree.insert("0");
        tree.insert(null);
        tree.insert("000");
        tree.insert("011");
        tree.insert("0101");
        System.out.println("Number of Nodes in the Trie: " + tree.numNodes());
        System.out.println("\nTest1b results:");
        MyCompressedTrie compTree= new MyCompressedTrie(tree);
        int nod = 0;
        int counter = 0;
        System.out.println("Number of Nodes in the compressed Trie: " + (nod = compTree.numNodes()));
        if(nod != 6)
        {
            counter++;
            System.out.println("Wrong Answer, Expected 6, Given " + nod);
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
        compTree.printStringsInLexicoOrder();
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Show what happened
        System.out.print(baos.toString());
        int lex = 0;
        String[] correct = new String[]{"0","000","01","0100","0101","011","111"};
        if(!cmpLexTest1(baos.toString(), correct))
        {
            lex++;
            System.out.println("Wrong Answer (Lexicographical Order)");
            System.out.println("Expected: 0,000,01,0100,0101,011,111");
        }
        System.out.println(compTree.numNodes());
        System.out.println("Correct Answers (Number of Nodes): " + (1-counter) + "/1");
        System.out.println("Correct Answers (Lexicographical): " + (1-lex) + "/1");
        System.out.println("-------------------------------------------\n");
    }
    
    public static void Test2()
    {
        System.out.println("-------------------------------------------");
        System.out.println("Test2b\n");
        MyTrie tree =new MyTrie();
        System.out.println("Populating the trie with: 0001, 00010101, 1101, 1");
        tree.insert("00001");
        tree.insert("00010101");
        tree.insert("1101");
        tree.insert("1");
        System.out.println("Number of Nodes in the Trie: " + tree.numNodes());

        System.out.println("\nTest2b results:");
        MyCompressedTrie compTree= new MyCompressedTrie(tree);//should compress like this: (0001)->(0101)
        int nod = 0;
        int counter = 0;
        System.out.println("Number of Nodes in the compressed Trie: " + (nod = compTree.numNodes()));
        if(nod != 6)
        {
            counter++;
            System.out.println("Wrong Answer, Expected 6, Given " + nod);
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
        compTree.printStringsInLexicoOrder();
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Show what happened
        System.out.print(baos.toString());
        int lex = 0;
        String[] correct = new String[]{"00001", "00010101", "1", "1101"};
        System.out.println(baos.toString());
        if(!cmpLexTest1(baos.toString(), correct))
        {
            lex++;
            System.out.println("Wrong Answer (Lexicographical Order)");
            System.out.println("Expected: 00001, 00010101, 1, 1101");
        }
        
        System.out.println("Correct Answers (Number of Nodes): " + (1-counter) + "/1");
        System.out.println("Correct Answers (Lexicographical): " + (1-lex) + "/1");
        System.out.println("-------------------------------------------\n");
    }
    
    public static void main(String[] args) {
    
        Test1();
        Test2();
    }
    
    
}
