package com.axlav;

import java.util.Random;
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
	    String alphabetString = "abcdefghijklmnopqrstuvwxyz";
	    char[] alphabetChars = alphabetString.toCharArray();
		String target = args[0].toLowerCase().replaceAll("\\W", "");
	    char[] targetChars = target.toCharArray();
		System.out.println(target);

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
				if (skipMatches>1) {
					System.out.println(skipMatches+ " Matches Found!");
				} else {
					System.out.println("1 Match Found!");
				}
				System.out.println("Skip: "+i);
				System.out.println("Total Matches: "+totalMatches);
			}
        }
	    if (totalMatches==0) {
	    	System.out.println("Zero Matches Found");
		}
    }
}
