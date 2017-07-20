package com.apache.hadoop;

import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer extends Reducer<IntWritable,Text,IntWritable,TupleData>{
	//private valuemeantuple result=new valuemeantuple();
	String clean(String s)
	{
		String a="";
		for(char a1:s.toCharArray())
		{
			if((a1>=65&&a1<=90)||(a1>=97&&a1<=122)||a1=='.'||(a1>=48&&a1<=57)||a1==' ')
			{
				a+=a1;
			}
		}
		return a;
	}
	public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException,InterruptedException
	{
		String name="",reg="",contact="",cgpa="",city="",gender="";
		TupleData td=new TupleData();
		for (Text val : values) {
			String s=val.toString().trim();
			String str=this.clean(s);
			
	        if(Pattern.matches("[0-9]{2}[a-zA-Z]{3}[0-9]{4}", str))
	        {
	        	reg=str;
	        }
	        else if(Pattern.matches("[0-9]{10}", str))
	        {
	        	contact=str;
	        }
	        else if(str.toLowerCase().equals("male")||val.toString().toLowerCase().equals("female"))
	        {
	        	gender=str;
	        }
	        else if(Pattern.matches("[a-zA-z]+", str))
	        {
	        	city=str;
	        }
	        else if(Pattern.matches("[a-zA-Z]+[ ]+[a-zA-Z]+",str))
	        {
	        	String c1[]=str.split(" ");
	        	String s1="";
	    		for(String s2:c1)
	    		{
	    			if(!s2.equals(""))
	    			{s1+=s2+" ";}
	    		}
	    		s1=s1.trim();
	        	name=s1;
	        }
	        else if(Pattern.matches("[0-9]{1,2}[.]{1}[0-9]{1,2}", str))
	        {
	        	cgpa=str;
	        }
	      }
		td=new TupleData(name,reg,contact,cgpa,city,gender);
		td.toString();
		context.write(key, td);
	}
	}	
