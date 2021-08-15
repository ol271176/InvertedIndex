package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InvertedIndex index = new InvertedIndex("F:\\JavaProjects\\invertedIndex\\dataset");
        ArrayList<IndexEntry> result = index.find("movie");
        for(IndexEntry entry : result){
            System.out.println(entry.fileName + " " +entry.count);
        }
    }
}
