import java.net.*;
import java.util.Scanner;
import java.io.*;

public class bt2 {

		   public static void main(String [] args)

		   {

		      try

		      {

		         Scanner input =new Scanner(System.in);

		         String s=input.nextLine();

		         URL url = new URL(s);

		         URLConnection urlConnection = url.openConnection();

		         HttpURLConnection connection = null;

		         if(urlConnection instanceof HttpURLConnection)

		         {

		            connection = (HttpURLConnection) urlConnection;

		         }

		         else

		         {

		            System.out.println("Please enter an HTTP URL.");

		            return;

		         }

		         BufferedReader in = new BufferedReader(

		         new InputStreamReader(connection.getInputStream()));

		         String urlString = "";

		         String current;

		         while((current = in.readLine()) != null)

		         {

		            urlString += current;

		         }

		         System.out.println(urlString);

		      }catch(IOException e)

		      {

		         e.printStackTrace();
		      }
		   }
	}

