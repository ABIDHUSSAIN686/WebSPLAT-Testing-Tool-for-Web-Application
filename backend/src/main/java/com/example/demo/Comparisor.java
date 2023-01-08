package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/****
 * Comparisor class used difflib python library and generate 
 * html dom level difference of two html files
 * ****/
  public class Comparisor {
	String s;
	/****
	 * codeExecutor function used difflib python library and generate 
	 * html dom level side by side colored differences of two html files
	 * ****/
	public void codeExecutor(String filename1,String filename2) throws IOException {
		String pathPython = "delta.py";
		String [] cmd = new String[4];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = filename1;
		cmd[3] = filename2;
		Runtime r = Runtime.getRuntime();  
		Process p = r.exec(cmd);
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((s=in.readLine()) != null){
			System.out.println(s);
		}
	}
	
	/****
	 * codeExecutor1 function used difflib python library and generate 
	 * html dom level character wise differences of two html files
	 * ****/
	public void codeExecutor1(String filename1,String filename2) throws IOException {
		String pathPython = "delta2.py";
		String [] cmd = new String[4];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = filename1;
		cmd[3] = filename2;
		Runtime r = Runtime.getRuntime();
		Process p = r.exec(cmd);
	}
	
}