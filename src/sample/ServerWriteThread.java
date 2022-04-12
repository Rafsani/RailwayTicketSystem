package sample;
import java.io.FileWriter;
import java.io.IOException;
import util.NetworkUtil;
import static sample.Server.getTraindata;
import static sample.Server.getTrains;
import static sample.Server.users;

public class ServerWriteThread implements Runnable {
	int i = 0;
	private Thread thr;
	private NetworkUtil nc;
	String name;

	public ServerWriteThread(NetworkUtil nc, String name) {
		this.nc = nc;
		this.name = name;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			while (true) {
				User d = users.get(i);
				nc.write(d);
				i++;
				if (i > users.size() - 1) {
					i = 0;
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			i = 0;
			while (true) {
				Train t = getTrains().get(i);
				nc.write(t);
				i++;
				if (i > getTrains().size() - 1) {
					i = 0;
					getTrains().removeAll(getTrains());
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		while (true) {
			Object o = nc.read();
			if (o != null) {
				if(o instanceof User){
					User user = (User) o;
					System.out.println(user);
					users.add(user);
					try {
						FileWriter fw = new FileWriter("User.txt",true); //true adds without re-writing
							fw.write(user.str());
							fw.write("\n");
							fw.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}

				}
				if (o instanceof TrainRequest) {
					TrainRequest obj = (TrainRequest) o;
					System.out.println(obj);

					/*
					 * For each class we check individually if there is any seat available
					 * if available we send a message to client that is SeatAvailable
					 * client checks the message and goes to next scene if no seat is available he cannot go to next scene for booking
					 * */

					for(i = 0; i<getTraindata().size(); i++)
					{
						if(obj.getTrainID().equals(getTraindata().get(i).getTrainId()) && obj.getDate().equalDate(getTraindata().get(i).getTrainDate()))
						{
							System.out.println("Train found" + getTraindata().get(i));
							if(obj.getSeatClass().equals("First") && ( 100-getTraindata().get(i).getFirstClassSeat() - obj.getRequiredSeat()) > 0){
								nc.write("SeatAvailable");
								break;
							}

							else if(obj.getSeatClass().equals("Second") && 200-getTraindata().get(i).getSecondClassSeat() - obj.getRequiredSeat() > 0){
								nc.write("SeatAvailable");
								break;
							}

							else if(obj.getSeatClass().equals("Third") && 500-getTraindata().get(i).getThirdClassSeat() - obj.getRequiredSeat() > 0){
								nc.write("SeatAvailable");
								break;
							}
							else
							{
								nc.write("NoSeatAvailable");
								break;
							}
						}
					}

				}
				System.out.println(i);
				if(o instanceof ConfirmationRequest){
					ConfirmationRequest f= (ConfirmationRequest) o;
					for(i = 0; i<getTraindata().size(); i++) {
						if (f.getTrainId().equals(getTraindata().get(i).getTrainId()) && f.getTrainDate().equalDate(getTraindata().get(i).getTrainDate())) {
							break;
						}
					}
					System.out.println(i);
					String cls = f.getSeatClass();
					System.out.println(cls);

					if(cls.equals("First")){
						System.out.println(getTraindata().get(i));
						getTraindata().get(i).setFirstClassSeat(f.getSeatReq() + getTraindata().get(i).getFirstClassSeat());

						System.out.println(getTraindata().get(i));
						if(f.seatReq>1){
							String t = String.valueOf(getTraindata().get(i).getFirstClassSeat()+1-f.seatReq) + "-" + String.valueOf(getTraindata().get(i).getFirstClassSeat());
							nc.write(t);	//writes ticket number to ticketPage
						}
						else
						{
							String t = String.valueOf(getTraindata().get(i).getFirstClassSeat());
							nc.write(t);	//writes ticket number to ticketPage
						}

					}

					if(cls.equals("Second")){
						System.out.println(getTraindata().get(i));
						getTraindata().get(i).setSecondClassSeat(f.getSeatReq() + getTraindata().get(i).getSecondClassSeat());
						System.out.println(getTraindata().get(i));
						if(f.seatReq>1){
							String t = String.valueOf(getTraindata().get(i).getSecondClassSeat()+1-f.seatReq) + "-" + String.valueOf(getTraindata().get(i).getSecondClassSeat());
							nc.write(t);			//writes ticket number to ticketPage
						}
						else
						{
							String t = String.valueOf(getTraindata().get(i).getSecondClassSeat());
							nc.write(t);		//writes ticket number to ticketPage
						}
					}

					if(cls.equals("Third")){
						System.out.println(getTraindata().get(i));
						getTraindata().get(i).setThirdClassSeat(f.getSeatReq() + getTraindata().get(i).getThirdClassSeat());
						System.out.println(getTraindata().get(i));
						if(f.seatReq>1){
							String t = String.valueOf(getTraindata().get(i).getThirdClassSeat()+1-f.seatReq) + "-" + String.valueOf(getTraindata().get(i).getThirdClassSeat());
							nc.write(t);			//writes ticket number to ticketPage
							System.out.println(i);
						}
						else
						{
							String t = String.valueOf(getTraindata().get(i).getThirdClassSeat());
							nc.write(t);		//writes ticket number to ticketPage
						}
					}


					try {
						FileWriter fileWriter = new FileWriter("TrainData.txt",true);
						for(int g = 0; g<Server.getTraindata().size(); g++){
							fileWriter.write(Server.getTraindata().get(g).str());
							fileWriter.write("\n");
							System.out.println(Server.getTraindata().get(g).str());
						}
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if(o instanceof String){
					String obj = (String) o;
					if(obj.equals("ClearFile")){
						try {
							FileWriter Fw = new FileWriter("User.txt",false);
							users.removeAll(users);
							Fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(obj.equals("ConfirmSeat")){
						try {
							FileWriter Fw = new FileWriter("TrainData.txt",false);
							Fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}


		}
		//nc.closeConnection();
	}

}