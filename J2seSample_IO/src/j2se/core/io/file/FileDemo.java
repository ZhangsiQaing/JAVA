package j2se.core.io.file;
import java.io.File;
import java.io.IOException;

public class FileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        File file = new File("bin");
//        System.out.println(file.getCanonicalPath());
//        System.out.println(file.getCanonicalFile());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getParentFile());
        String[] str = file.list();
        
        for(String s:str){
        	System.out.println(s);
        }
//        System.out.println("isDirectory:" + file.isDirectory());
//		System.out.println("isFile:" + file.isFile());
//		System.out.println("exists:" + file.exists());
//		System.out.println("canRead:" + file.canRead());
//		System.out.println("canWrite:" + file.canWrite());
//		System.out.println("isHidden:" + file.isHidden());
        
	}
	
	private static void deleteFile(String string){
		File file = new File(string);
		if(file.exists())
			System.out.println("文件存在的！");
		else
			System.out.println("文件不存在的！");
	}

}
