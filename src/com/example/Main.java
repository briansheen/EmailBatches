package com.example;

// Given a list of emails, write a program that will separate the list of emails into batches of emails where each batch does not contain duplicates
//[{1,2,3,4,5,6},{2,3,4},{2}]


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> emails = new ArrayList<>();
        emails.add("2");
        emails.add("1");
        emails.add("4");
        emails.add("2");
        emails.add("5");
        emails.add("3");
        emails.add("4");
        emails.add("6");
        emails.add("3");
        emails.add("2");
        System.out.println(getBatches(emails));
    }

    public static List<Set<String>> getBatches(List<String> emails){
        List<Set<String>> batches = new ArrayList<>();
        Set<String> firstBatch = new HashSet<>();
        batches.add(firstBatch);
        boolean found = false;
        for(String email : emails){
            for(Set<String> batch : batches){
                if(!batch.contains(email)){
                    batch.add(email);
                    found = true;
                    break;
                }
            }
            if(!found){
                Set<String> newBatch = new HashSet<>();
                newBatch.add(email);
                batches.add(newBatch);
            }
            found = false;
        }
        return batches;
    }
}
