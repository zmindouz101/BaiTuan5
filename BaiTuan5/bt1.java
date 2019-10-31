import java.net.*;
import java.io.*;
public class  bt1

{
	public static void main(String[] args)   {

		URL u;
		String thisLine;
		if(args.length>0){
			try{
				u =new URL(args[0]);
				try{
DataInputStream  dis  =  new DataInputStream(u.openStream());

		while((thisLine=dis.readLine())!=null)
			System.out.println(thisLine);
				}catch(IOException e) {
					System.err.println(e);
				}
			} catch(MalformedURLException e){
				System.err.println(e);
			}
		}
	}
}

