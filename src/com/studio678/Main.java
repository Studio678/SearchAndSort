/*
    В задаче с детектором блатных номеров сделать дополнительно бинарный поиск, поиск с помощью HashSet
     и с помощью TreeSet. Измерить и сравнить длительность 4­х видов поиска и написать результат
     в качестве решения домашнего задания.

     author studio678 26.05.1019
 */

package com.studio678;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

import static com.studio678.GenerationCarNumbers.generationCarNumbers;


public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here

        ArrayList<String> carNumbers = generationCarNumbers();

        long m;

        //direct search
        System.out.println("1. ArrayList direct search");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please type car number:");
        String str = reader.readLine().trim();
        m = System.currentTimeMillis();
        if(carNumbers.contains(str)){
            System.out.println("found number in base");
            System.out.print("direct search time: " + (double) (System.currentTimeMillis() - m));
            System.out.println(" ms");
        }else{
            System.out.println("not found number in base");
            System.out.print("direct search time: " + (double)(System.currentTimeMillis() - m));
            System.out.println(" ms");
        }
        //binary search
        System.out.println("2. ArrayList sorted array binary search");
        m=System.currentTimeMillis();
        //sort copy of carNumbers arraylist
        ArrayList<String> sortedCarNumbers = new ArrayList<>(carNumbers);
        Collections.sort(sortedCarNumbers);
        System.out.print("sort time: " + (System.currentTimeMillis() - m));
        System.out.println(" ms");
        //use binary search

        m = System.currentTimeMillis();
        int result = Collections.binarySearch(sortedCarNumbers, str);
        if(result >= 0){
            System.out.println("found number at base at index: " + result);
        }else{
            System.out.println("not found number at base");
        }
        System.out.print("search time: " + (double)(System.currentTimeMillis() - m));
        System.out.println(" ms");
        //hashset search
        System.out.println("3. HashSet search");
        //save unsorted array at hashset
        m = System.currentTimeMillis();
        HashSet<String> hashedCarNumbers = new HashSet<>(carNumbers);

        System.out.print("time of save arrayList to hashSet is: " + (double)(System.currentTimeMillis() - m));
        System.out.println(" ms");
        //search at hashSet
        m = System.currentTimeMillis();
        if(hashedCarNumbers.contains(str)){
            System.out.println("found number at base");
        }else{
            System.out.println("not found number at base");
        }
        System.out.print("search time: " + (double)(System.currentTimeMillis() - m));
        System.out.println(" ms");

        //treeset search
        System.out.println("4. TreeSet search");
        //save arraylist at treeset
        m = System.currentTimeMillis();
        TreeSet<String> treeSetCarNumbers = new TreeSet<>(carNumbers);

        System.out.print("time of save arrayList to treeSet is: " + (double)(System.currentTimeMillis() - m));
        System.out.println(" ms");
        //search at treeset
        m = System.currentTimeMillis();
        if(treeSetCarNumbers.contains(str)){
            System.out.println("found number at base");
        }else{
            System.out.println("not found number at base");
        }
        System.out.print("search time: " + (double)(System.currentTimeMillis() - m));
        System.out.println(" ms");
    }





}
