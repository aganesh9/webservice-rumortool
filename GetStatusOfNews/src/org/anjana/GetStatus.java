package org.anjana;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  
import java.util.Arrays;
import java.util.List;

public class GetStatus {

	/**
	 * @param args
	 */
	static Connection connection = null;  
    static ResultSet resultSet = null;  
    static Statement statement = null;  
    
	public void getConnection()
	{
	     try 
	     {  
	         Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection("jdbc:sqlite:/home/anjana/workspace/GetStatusOfNews/src/org/anjana/RumorTool5.db");
	     } 
	     catch (Exception e) 
	     {  
	         e.printStackTrace();  
	     }
	     
	}
	public String getNewsStatus(String content)
	{
		try {
			getConnection();
			Process p = Runtime.getRuntime().exec("python /home/anjana/workspace/GetStatusOfNews/src/org/anjana/GetKeywords.py "+content);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	          
	        StringBuilder  s = new StringBuilder();
	        String s1;
	        String query = "select * from NEWS_ITEMS where ";
				while ((s1  = stdInput.readLine()) != null) {
	                s.append(s1);
	                if (!s1.equals(""))
	                	query+=" Keyword_list like '%"+s1+"%' or ";
	                s.append("\n");
	            }
				query+= "1=0";
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				String this_list;
				String[] keywordlist;
				List input_keywordlist = Arrays.asList(s.toString().split("\n"));
				int count = 0;
				while (resultSet.next()) {
					count = 0;
					this_list = resultSet.getString(3);
					keywordlist = this_list.split("\n");
					for (String keyword : keywordlist) {
						if (input_keywordlist.contains(keyword)) 
							count++;
					}
					if (count > (0.5*input_keywordlist.size())) {
						return resultSet.getString(5);
					}
				}
				return "More analysis to be done on this news item";
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new GetStatus().getNewsStatus("brad pitt says hi"));
	}

}
