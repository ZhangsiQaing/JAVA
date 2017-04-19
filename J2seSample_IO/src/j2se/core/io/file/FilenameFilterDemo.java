package j2se.core.io.file;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FilenameFilterDemo {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ���ҵ�Ŀ¼��");
		String path = scanner.nextLine();
		System.out.println("������Ҫ���ҵ��ļ��ĺ�׺��");
		final String suffix = scanner.nextLine();
		
		File file = new File(path);
		String[] files = file.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir,String name){
				if(name.endsWith(suffix))
					return true;
				return false;
			}
		});
		
		for(String s:files){
			System.out.println(s);
		}
	}
}
