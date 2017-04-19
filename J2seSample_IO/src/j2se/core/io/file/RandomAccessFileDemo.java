package j2se.core.io.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class RandomAccessFileDemo {
     
	private static ArrayList<Long> pointer = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person[] persons = new Person[] {
				new Person("one",32,true),
				new Person("two",31,false),
				new Person("three",30,true),
				new Person("four",29,false)
		};
		try{
		   write(persons);
		}catch(IOException ex){
		   System.out.println("–¥»Î ß∞‹£°");
		}
		
		try{
			Person p = read(2);
			System.out.println(p);
		}catch(IOException e){
			System.out.println("∂¡»° ß∞‹£°");
		}
		
	}
	
	private static void write(Person[] persons) throws IOException{
		File _file = new File("data/store.dat");
		if(!_file.exists()){
			File dir = _file.getParentFile();
			dir.mkdir();
		}
		RandomAccessFile file = new RandomAccessFile("data/store.dat","rw");
		pointer = new ArrayList<Long>();
		for(Person p : persons){
			pointer.add(file.getFilePointer());
			file.writeUTF(p.name);
			System.out.println("name:"+file.getFilePointer());
			file.writeInt(p.age);
			System.out.println("age:"+file.getFilePointer());
			file.writeBoolean(p.sex);
			System.out.println("sex:"+file.getFilePointer());
		}
		file.close();
	}
	
	public static Person read(int i) throws IOException{
		RandomAccessFile file = new RandomAccessFile("data/store.dat","rw");
		long l = pointer.get(i);
		file.skipBytes((int)l);
		
		Person p = new Person();
		p.name = file.readUTF();
		p.age = file.readInt();
		p.sex = file.readBoolean();
		file.close();
		return p;
	}
	
	
}

class Person{
	String name;
	int age;
	boolean sex;
	
	public Person(){}
	
	public Person(String name,int age,boolean sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	@Override
	public String toString(){
		return "Person [age="+age+",name="+name+",sex="+sex+"]";
	}
}