class TrieNode{
    TrieNode[] chilNode;
    boolean wordEnd;

    TrieNode(){
        chilNode = new TrieNode[26];
        wordEnd = false;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    void insert(String key){
        TrieNode currentNode = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(currentNode.chilNode[index] == null){
                currentNode.chilNode[index] = new TrieNode();
            }
            currentNode = currentNode.chilNode[index];
        }
        currentNode.wordEnd = true;
    }
    boolean search(String key){
        TrieNode currentNode = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(currentNode.chilNode[index] == null){
                return false;
            }
            currentNode = currentNode.chilNode[index];
        }
        return currentNode.wordEnd;
    }
}

public class Main_Trie {
    public static void main(String...args){
        Trie trie = new Trie();
        String[] inpuStrings = {"and", "ant", "do", "world", "dad", "ball"};
        for(String str: inpuStrings){
            trie.insert(str);
        }
        String[] searchQueryStrings = {"do", "world", "bat"};
        for(String query: searchQueryStrings){
            System.out.println("Query Strings: " + query);
            if(trie.search(query)){
                System.out.println("The query is present in the Trie");
            }else{
                System.out.println("The query is not present in the Trie");
            }
        }
    }
    
}
