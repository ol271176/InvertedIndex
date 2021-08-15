package com.company;
import com.company.IndexEntry;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InvertedIndex {
    HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();

    public InvertedIndex(String dirName) {
        File myFolder = new File(dirName);
        File[] files = myFolder.listFiles();

        try {
            for (File f : files) {
                Scanner scanner = new Scanner(f);
                while (scanner.hasNext()) {
                    String word  = scanner.next();
                    if(!map.containsKey(word)) {
                        HashMap<String, Integer> fileMap = new HashMap<String, Integer>();
                        map.put(word, fileMap);
                    }
                    HashMap a = map.get(word);

                    if(!a.containsKey(f.toString())){
                        a.put(f.toString(), 0);
                    }
                    Integer count = (Integer) a.get(f.toString());
                    count++;
                    a.put(f.toString(), count);
                }
            }
            for (HashMap.Entry<String, HashMap<String, Integer>> pair : map.entrySet())
            {
                String key = pair.getKey();                      //ключ
                HashMap value = pair.getValue();                  //значение
                //System.out.println(key + ":" + value);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //for(File s : files) System.out.println(s.toPath());
    }

    public ArrayList<IndexEntry> find(String word){
        ArrayList<IndexEntry> res = new ArrayList<>();
        if(!map.containsKey(word)) {
            System.out.println("Слово" + word + " не найдено");
            return res;
        }
        HashMap<String, Integer> tempMap = map.get(word);
        for (HashMap.Entry<String, Integer> pair : tempMap.entrySet())
        {
            IndexEntry entry = new IndexEntry(pair.getKey(), pair.getValue());
            res.add(entry);
        }
        return res;
    }
}
