package org.smartinrub.prefixtree;

/**
 Problem: Given a list of key strings and an input string,
 determine if any of the keys are a prefix of the input string.
 Notes: The list of key strings is long, e.g. 100,000 of them.
 Key strings vary in length. All characters are lower-case
 letters.
 We want to perform the lookup operation frequently, for lots of
 different input strings.
 **/
public class Main {

    public static void main(String[] args) {
        PrefixTree prefixTree = new PrefixTree();

        prefixTree.addEntry("co");
        prefixTree.addEntry("eng");
        prefixTree.addEntry("ro");
        prefixTree.addEntry("trad");
        prefixTree.addEntry("ch");
        prefixTree.addEntry("ru");

        System.out.println("Lookup (engineering): " + prefixTree.lookup("engineering")); //should return true
        System.out.println("Lookup (en): " + prefixTree.lookup("en")); //should return false
        System.out.println("Lookup (school): " + prefixTree.lookup("school")); //should return false
        System.out.println("Lookup (school): " + prefixTree.lookup("traditional")); //should return false
        System.out.println("Lookup (school): " + prefixTree.lookup("fetch")); //should return false
    }
}
