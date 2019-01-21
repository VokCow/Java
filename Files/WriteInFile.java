
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
This scripts allow the user to write several senteces in a Java file.
*/

public class WriteInFile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("name of file: ");
		String filename = sc.nextLine();
		String adress = "C:\\Users\\Ángel\\Desktop\\" + filename +".txt";
		System.out.println("file will be saved on desktop");
		File file = new File(adress);
		try {
		file.createNewFile(); 
		if(file.exists()) {
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("write your content here and type finish when you're done: "); //REMAINING TASK, ALLOW USER TO WRITE AS LINES AS HE WANTS
			while(sc.hasNext()) {
				String line = sc.nextLine();
				if(line.equals("exit")) break;
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		}
		} catch(IOException e) { 
			e.printStackTrace();
		}
		
	}
	
}
