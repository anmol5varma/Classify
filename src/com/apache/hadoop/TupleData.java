package com.apache.hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TupleData implements WritableComparable<TupleData> {

	Text name,reg,contact,cgpa,city,gender;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cgpa == null) ? 0 : cgpa.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reg == null) ? 0 : reg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TupleData other = (TupleData) obj;
		if (cgpa == null) {
			if (other.cgpa != null)
				return false;
		} else if (!cgpa.equals(other.cgpa))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reg == null) {
			if (other.reg != null)
				return false;
		} else if (!reg.equals(other.reg))
			return false;
		return true;
	}

	public TupleData()
	{
		
	}
	
	public TupleData(String name,String reg,String contact,String cgpa,String city,String gender)
	{
		set(name,reg,contact,cgpa,city,gender);
	}
	
	public void show()
	{
		System.out.println(name+" "+reg+" "+contact+" "+city);
	}
	
	public Text getname()
	{
		return name;
	}
	
	void set(String name,String reg,String contact,String cgpa,String city,String gender)
	{
		this.name=new Text(name);
		this.reg=new Text(reg);
		this.contact=new Text(contact);
		this.cgpa=new Text(cgpa);
		this.city=new Text(city);
		this.gender=new Text(gender);
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		name.readFields(in);
		reg.readFields(in);
		contact.readFields(in);
		cgpa.readFields(in);
		city.readFields(in);
		gender.readFields(in);
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		name.write(out);
		reg.write(out);
		//reg.write(out);
		contact.write(out);
		cgpa.write(out);
		city.write(out);
		gender.write(out);
		// TODO Auto-generated method stub
		
	}
	public String toString()
	{
		return name.toString()+"\t"+reg.toString()+"\t"+contact.toString()+"\t"+cgpa.toString()+"\t"+city.toString()+"\t"+gender.toString()	;
	}

	@Override
	public int compareTo(TupleData o) {
		// TODO Auto-generated method stub
		return 1;
	}

}
