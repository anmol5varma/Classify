package com.apache.hadoop;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper extends Mapper<LongWritable, Text, IntWritable, Text>{
	int c=1;
	public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException 
	{
		
		System.out.println("*****************Inside mapper.java***************");
		String s=value.toString();
		String str[]=s.split(",");
		for(String s1:str)
		{
			context.write(new IntWritable(c),new Text(s1));
		}
		c++;
	}
}
