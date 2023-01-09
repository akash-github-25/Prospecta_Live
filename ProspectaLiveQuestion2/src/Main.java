
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void Output(String[] ans) {
	       Map<String,Integer> map=new HashMap<>(); 
    try { 
	        for(String s:ans) {
	        	String[] s1=s.split(": ");

	        	 if(s1[1].charAt(0)!='=') {
	        		 map.put(s1[0],Integer.parseInt(s1[1]));
	        	 }    
	        	if(s1[1].charAt(0)=='=') {
	        	    String h1=s1[1].substring(1,s1[1].length());
	        		String[] h=h1.split("");

	            String z1,z2,z3;
	        		if(h.length==3) {
	            	 z1=h[0];
	            	 z3=h[1];
	            	 z2=h[2];
	             }else if(h.length==4) {
	            	 z1=h[0];
	            	 z3=h[1];
	            	 z2=h[2]+h[3];
	             }else {
	            	 z1=h[0]+h[1];
	            	 z3=h[2];
	            	 z2=h[3]+h[4];
	            	 }

	        		Integer x1=0;
	        		Integer y1=0;
	        		
	        		if(z1.equals("A1") || z1.equals("A2") || z1.equals("A3")
	        				|| z1.equals("B1")|| z1.equals("B2")|| z1.equals("B3")
	        				|| z1.equals("C1")|| z1.equals("C2")|| z1.equals("C3")) {
	        			
	        			 x1=map.get(z1);
	        		}else {
	        			 x1=Integer.parseInt(z1);
	        		}
	        	if(z2.equals("A1") || z2.equals("A2") || z2.equals("A3")
	    				|| z2.equals("B1")|| z2.equals("B2")|| z2.equals("B3")
	    				|| z2.equals("C1")|| z2.equals("C2")|| z2.equals("C3")) {
	        		
	        		y1=map.get(z2);
	        	}else {
	        	 y1=Integer.parseInt(z2);
	        	}
	        		if(z3.equals("+")) {					
	        		map.put(s1[0],x1+y1);
	        		}else if(z3.equals("-")) {
	        			map.put(s1[0], Math.abs(x1-y1));
	        		}else if(z3.equals("*")) {
	        			map.put(s1[0], x1*y1);
	        		}else {
	        			if(x1>y1) {
	        			map.put(s1[0],x1/y1);
	        		}else {
	        			map.put(s1[0],y1/x1);
	        		}
	        	}
	        		
	        	}
	        }
	        
    }catch(NumberFormatException e) {
    	
	e.printStackTrace();
	
}
	        for(Map.Entry<String,Integer> b:map.entrySet()) {
	        	System.out.println(b.getKey()+" = "+b.getValue());
	        }
			
	}

	public static void main(String[] args) throws IOException {

		String line = "";  
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ASUS\\Desktop\\prActice_interview\\Practise\\src\\com\\one\\prospect.csv"));  
		while ((line = reader.readLine()) != null)   //It will return a boolean value
		{  
		String[] ans = line.split(", ");// I am splitting it as comma
		Output(ans);
	}
		
	
		
	}

}
