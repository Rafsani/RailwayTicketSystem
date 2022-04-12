package sample;

import util.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ClientReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this,"baaal");
		thr.start();
	}
	public static String userName,Password;
	private static List <User> list = new ArrayList();

	public static List<User> getList() {
		return list;
	}
	private static List<Train> trainList = new ArrayList();

	public static List<Train> getTrainList() {
		return trainList;
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
				else	if (o instanceof Train)
					{
						Train trainObj=(Train) o;
						System.out.println(trainObj);
						//userName = obj.getName();
						//Password = obj.getPassword();
						trainList.add(trainObj);
					}

				else	if (o instanceof ReserveFileData)
					{
						ReserveFileData Obj=(ReserveFileData) o;
						System.out.println(Obj);

					}

				}
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}

		//nc.closeConnection();
	}
}



