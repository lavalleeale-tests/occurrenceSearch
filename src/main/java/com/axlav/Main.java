package com.axlav;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
    	if (args.length<1) {
    		System.out.println("Error: Requires 1 argument to determine what to search for");
    		System.exit(1);
		}

		File file = new File("search.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");
		String textFile = sc.next();
		String text=textFile.replaceAll("[^a-zA-Z]∑", "").toLowerCase();
		char[] chars = text.toCharArray();

		int letterMatches = 0;
		int skipMatches;
		int totalMatches = 0;
		String target = args[0].toLowerCase().replaceAll("\\W", "");
	    char[] targetChars = target.toCharArray();
		System.out.println("Searching For: " + target);

	    for (int i = 1; i < (chars.length/targetChars.length);i++) {
	    	skipMatches = 0;
	        for (int x=1; x<(chars.length/i); x++) {
	            if (chars[i * x] == targetChars[letterMatches]) {
	                if (letterMatches == targetChars.length-1) {
	                    skipMatches++;
	                    letterMatches=0;
                    } else {
	                    letterMatches++;
                    }
                } else if (letterMatches!=0) {
	                letterMatches=0;
	                x--;
                }
            }
	        if (skipMatches!=0) {
				totalMatches+=skipMatches;
			}
			System.out.print("\rSkip: "+i+" | Total Matches: "+totalMatches);
	        Thread.sleep(0,0);
		}
	    if (totalMatches==0) {
	    	System.out.println("\nFinished: Zero Matches Found");
		} else if (totalMatches>1){
	    	System.out.println("\nFinished: " + totalMatches + " Matches Found");
		} else {
			System.out.println("\nFinished: " + totalMatches + " Match Found");
		}
    }
}
