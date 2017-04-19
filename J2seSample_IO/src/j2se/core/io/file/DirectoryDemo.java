package j2se.core.io.file;
import java.io.File;
import java.io.IOException;

public class DirectoryDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		File dir = new File("src/j2se/core/io/file");
//		if(dir.isDirectory()){
//			System.out.println(dir + " 是个目录");
//		}
//		
//		for(String s:dir.list()){
//			System.out.println(s);
//		}
//		createSingleDir("src/j2se/core/io/file/test1");   //创建单一目录
//		deleteSingleDir("src/j2se/core/io/file/test1");   //删除单一目录
		
//		createMultiDir("test1/1/2/1");   //创建多重目录
//		deleteMultiDir("test1/1/2");     //删除多重目录
		
		createFileWithDir("test2/ric/dir.txt");   //创建文件的同时，创建目录
//		deleteMultiDir("test3");         
	
	}
	
	
	/** 创建成功 
	 * @throws IOException **/
	private static void createFileWithDir(String string) throws IOException{
		File file = new File(string);
		if(file.exists()){
			return;
		}
		File dir = file.getParentFile();
		if(!dir.exists())
			dir.mkdirs();
		
		if(!file.exists()){
			file.createNewFile();
		}
		
//		createMultiDir(file.getParent());
//		if(file.createNewFile()){
//			System.out.println("创建成功");
//		}else{
//			System.out.println("创建失败");
//		}
	}
	
	/**创建单一目录**/
	private static void createSingleDir(String string){
		File file = new File(string);
		if(file.exists()){
			System.out.println("文件已存在！");
			return;
		}
		if(file.mkdir()){
			System.out.println("创建成功");
		}else{
			System.out.println("创建失败");
		}
	}
	
	/**删除单一目录**/
	private static void deleteSingleDir(String string){
		File file = new File(string);
		if(!file.exists()){
			return;
		}
		if(file.delete()){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
	}
	
	/** 创建多重目录   **/
	private static void createMultiDir(String string){
		File file = new File(string);
		if(file.exists()){
			System.out.println("文件已存在！");
			return;
		}
		if(file.mkdirs()){
			System.out.println("创建成功！");
		}else{
			System.out.println("创建失败！");
		}
	}
	
	/**  **/
	
	
	
	/** 删除目录树  **/
	private static void deleteMultiDir(String string){
		File dir = new File(string);
		if(!dir.exists())
			return;
		if(delete(dir))
			System.out.println("删除成功！");
		else
			System.out.println("删除失败！");
	}
	
	/***递归删除目录和文件***/
	private static boolean delete(File current){
		boolean flag = true;
		if(current.isDirectory())
			for(File file:current.listFiles())
				flag = flag && delete(file);
		return flag && current.delete();
	}
	
	

	
	

}
