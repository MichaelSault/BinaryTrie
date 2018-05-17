/*** 
 * This is an additional class created for the purpose of testing the class MyCompressedTrie.
 * 
 * Name: Michael Sault
 * Student Number: 8459820
 * Uottawa Email: msaul025@uottawa.ca
 *
 */

 Information regarding the TestTrie2.java file:
 Test 3a attempts to insert a Trie with a value of null, this causes the value for numNodes to iterate once more than intended.  My program does not handle a null value perfectly, however it doesn't cause an error and the tree will still be returned lexicographically when called.

 Information regarding the TestCompressedTrie2.java file:
 Test1b:
 Again testing a null node, this causes an extra node to be generated, like in Test3a method of the TestTrie2 class.  It also seems to cause an error in the lexicographical printing method.

 Test2b:
 The CompressedTrie has the correct number of nodes, however there is an error in the lexicographical printing method.