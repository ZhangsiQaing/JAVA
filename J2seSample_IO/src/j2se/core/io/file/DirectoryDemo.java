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
//			System.out.println(dir + " �Ǹ�Ŀ¼");
//		}
//		
//		for(String s:dir.list()){
//			System.out.println(s);
//		}
//		createSingleDir("src/j2se/core/io/file/test1");   //������һĿ¼
//		deleteSingleDir("src/j2se/core/io/file/test1");   //ɾ����һĿ¼
		
//		createMultiDir("test1/1/2/1");   //��������Ŀ¼
//		deleteMultiDir("test1/1/2");     //ɾ������Ŀ¼
		
		createFileWithDir("test2/ric/dir.txt");   //�����ļ���ͬʱ������Ŀ¼
//		deleteMultiDir("test3");         
	
	}
	
	
	/** �����ɹ� 
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
//			System.out.println("�����ɹ�");
//		}else{
//			System.out.println("����ʧ��");
//		}
	}
	
	/**������һĿ¼**/
	private static void createSingleDir(String string){
		File file = new File(string);
		if(file.exists()){
			System.out.println("�ļ��Ѵ��ڣ�");
			return;
		}
		if(file.mkdir()){
			System.out.println("�����ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
	}
	
	/**ɾ����һĿ¼**/
	private static void deleteSingleDir(String string){
		File file = new File(string);
		if(!file.exists()){
			return;
		}
		if(file.delete()){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}
	
	/** ��������Ŀ¼   **/
	private static void createMultiDir(String string){
		File file = new File(string);
		if(file.exists()){
			System.out.println("�ļ��Ѵ��ڣ�");
			return;
		}
		if(file.mkdirs()){
			System.out.println("�����ɹ���");
		}else{
			System.out.println("����ʧ�ܣ�");
		}
	}
	
	/**  **/
	
	
	
	/** ɾ��Ŀ¼��  **/
	private static void deleteMultiDir(String string){
		File dir = new File(string);
		if(!dir.exists())
			return;
		if(delete(dir))
			System.out.println("ɾ���ɹ���");
		else
			System.out.println("ɾ��ʧ�ܣ�");
	}
	
	/***�ݹ�ɾ��Ŀ¼���ļ�***/
	private static boolean delete(File current){
		boolean flag = true;
		if(current.isDirectory())
			for(File file:current.listFiles())
				flag = flag && delete(file);
		return flag && current.delete();
	}
	
	

	
	

}
