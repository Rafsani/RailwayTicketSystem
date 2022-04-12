package sample;

import util.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this,"baaal");
		thr.start();
	}
	public static String userName,Password;
	private static List <User> list = new ArrayList();

	public static List<User> getList() {
		return list;
	}

	public void run() {
		try {
			while(true) {
				Object o=nc.read();
				if(o!= null) {
					if(o instanceof User) {
						User obj=(User) o;
						System.out.println(obj);
						//userName = obj.getName();
						//Password = obj.getPassword();
						list.add(obj);

					}
				}	
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



