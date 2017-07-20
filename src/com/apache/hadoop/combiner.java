package com.apache.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class combiner extends Reducer<IntWritable,Text,IntWritable,Text>{
	
	public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException,InterruptedException
	{
		
		for(Text value:values)
		{
			//System.out.println(key+" "+value);
			context.write(key, value);
		}
		//System.out.println(key.toString()+"hello");
	}

}
