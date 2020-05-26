
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

import org.json.simple.JSONObject;


public class mock {
	public static void main (String args[])
	{
		JSONObject object = new JSONObject();

		try
		{
			int line = 0,i=1,j=0;
	        double sum=0,avg;
	        double a[]=new double[1000];
	        DecimalFormat obj = new DecimalFormat("###.##");

	        
		File file =new File("D:\\study material\\NFT_Hackathon\\Memory.txt");
		FileReader reader=new FileReader(file);
		BufferedReader breader= new BufferedReader(reader);
		String output=breader.readLine();
		
		while(output!=null)
		{ 
			if (line % 2 != 0) 
			{
				String str=between(output, ":", "TOTAL SWAP").trim();
				
	        	double num=Double.parseDouble(str);
	        	double mb = num/1000;
	        	obj.setRoundingMode(RoundingMode.DOWN);
	        	String d=obj.format(mb);
	        	double mb1=Double.parseDouble(d);
	        	a[i]=mb1;
	        	System.out.println(mb1);
	            sum =sum + mb1;
	            
	            String str1=i+"s";
                object.values("values",str1+":"+mb1);

                i++;
        	
		}
			line++;
			output=breader.readLine();
		}
		avg=sum/i;
    	String average=obj.format(avg);
    
    	Arrays.sort(a);
    	double max=a[(a.length)-1];
        System.out.println("Average (MB): " + average+",");
        System.out.println("MaxMemory(MB):" + max+",");
        System.out.println("Usecasename"+":"+"HomePage");
        object.avg("AverageMemory(MB)",average);
		object.max("MaxMemory(MB)",max);
		object.heading("Usecasename","HomePage");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
		
		FileWriter fwriter=new FileWriter("D:\\study material\\NFT_Hackathon\\Demo_json.txt");
		fwriter.write(object.toString());
		fwriter.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
}
	static String between(String value, String a, String b) {
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        int posB = value.lastIndexOf(b);
        if (posB == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= posB) {
            return "";
        }
        return value.substring(adjustedPosA, posB);
    }

 
}

