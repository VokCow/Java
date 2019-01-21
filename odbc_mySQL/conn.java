package northwind2;
/*Este programa va a acceder a la base de datos, permitir al usuario hacer una busqueda, y grabar los
 * resultados de la busqueda en un archivo de texto .text */

//staff for DB 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//staff for files
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
//lists
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conn {
	
	public static void main(String[] args) {
		//connection parameters
		String user = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/northwind?autoReconnect=true&useSSL=false";
		Scanner sc = new Scanner(System.in);
		
		//I create the connection
		System.out.println("Connecting..");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		List items = new ArrayList<Item>();
		PreparedStatement query = null;
		ResultSet results = null;
		System.out.println("Please, type here the name of the item you are looking for");
		String item = sc.nextLine();
		
		try {
			String sqlquery = "SELECT product_name, standard_cost FROM products WHERE product_name LIKE '%" + item +"%'";
			query = con.prepareStatement(sqlquery);
			results = query.executeQuery();
			while(results.next()) {
				//we save data base data into our item object parameters, namely name and price
				String name = results.getString("product_name");
				Float price = results.getFloat("standard_cost"); //F is uppercase here not sure why, I guess cuz is Float class not float primary data type
				items.add(new Item(name,price));
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally //close resultset and query
		{
			if(results!=null) {
					try {
						results.close();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			if(query!=null) {
					try {
						query.close();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
			}
		}
		System.out.println(items.size() + " items have been found");
		for(Object i:items) {
			System.out.println(i.toString());
		}
		String fileadress = "C:\\Users\\Ángel\\Desktop\\Search.txt";
		File file = new File(fileadress);
		try {
			file.createNewFile();
			if (file.exists()) {
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Search results: ");
				bw.newLine();
				for(Object i:items) {
					bw.write(i.toString());
					bw.newLine();
				}
				bw.close();
				fw.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//now close connection
		if(con!=null) {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}		
}
