package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.NetworkUtil;

public class Server {
    private static final String Filename = "User.txt";
    private ServerSocket ServSock;
    public static List <User> users = new ArrayList();

    private static List <Train> trains = new ArrayList<>();

    private static List<ReserveFileData> traindata = new ArrayList<>();

    public static List<ReserveFileData> getTraindata() {
        return traindata;
    }

    public static List<Train> getTrains() {
        return trains;
    }

    Server() throws FileNotFoundException {
        try {
            ServSock = new ServerSocket(33333);
            while (true) {
                Socket clientSock = ServSock.accept();
                NetworkUtil nc=new NetworkUtil(clientSock);

                //reading from train file and creating arraylist

                int i;
                int[] search;
                int searchIdx=0;
                try {
                    String line;
                    BufferedReader br1 = new BufferedReader(new FileReader("TrainInfo.txt"));

                    while (true) {

                        line = br1.readLine();
                        if (line == null) break;
                        System.out.println(line);
                        String[] temp = line.split(",");
                        trains.add(new Train(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], Integer.parseInt(temp[7]), Integer.parseInt(temp[8]), Integer.parseInt(temp[9]), temp[10]));


                    }
                    br1.close();

                    System.out.println(line);
                }
                catch (Exception e)
                {
                    System.out.println("problem in train file reading"+ e.toString());
                }
                //new ReadThread(nc);
                new ServerWriteThread(nc,"Server");
            }

        }catch(Exception e) {
            System.out.println("Server starts:"+e);
        }

    }



      //  static BufferedReader br2 = new BufferedReader(new FileReader("TrainData.txt"));


    public static void main(String args[]) throws IOException {

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(Filename));

            while (true) {
                line = br.readLine();
                String[] temp = line.split(",");
                users.add(new User(temp[0], temp[1],temp[2],temp[3],temp[4]));
                if (line == null) break;
            }
            br.close();

        }
        catch (Exception e)
        {

        }

        try {
            String line;
            BufferedReader br2 = new BufferedReader(new FileReader("TrainData.txt"));

            while (true) {
                line = br2.readLine();
                if (line == null) break;
                String[] temp = line.split(",");
                String[] TempDate = temp[0].split("-");
                DateClass obj = new DateClass(Integer.parseInt(TempDate[0]),Integer.parseInt(TempDate[1]),Integer.parseInt(TempDate[2]));
                traindata.add(new ReserveFileData(obj,Integer.parseInt( temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),temp[4]));

               // System.out.println(k);


            }
            br2.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        Server objServer = new Server();
        System.out.println(traindata.size());

    }
}
