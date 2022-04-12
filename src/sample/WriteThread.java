package sample;
import java.util.*;
import util.NetworkUtil;

import static sample.Server.users;

public class WriteThread implements Runnable {
	static int i=0;
	private Thread thr;
	private NetworkUtil nc;
	String name;

	public WriteThread(NetworkUtil nc,String name) {
		this.nc = nc;
		this.name=name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			//Scanner input=new Scanner(System.in);

			while(true) {
				//String s=input.nextLine();
				User d = users.get(i);
				nc.write(d);
				i++;
				if(i>users.size())
				{
					i=0;
					break;
				}
				//Data d =new Data(name+":"+s);

			}
		} catch(Exception e) {
			System.out.println (e);
		}			
		nc.closeConnection();
	}
}



