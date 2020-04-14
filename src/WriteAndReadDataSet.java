import java.io.*;
import java.text.SimpleDateFormat;

public class WriteAndReadDataSet {
        public static void main(String[] args) {
            // three example data sets
            String sensorName = "MyGoodOldSensor"; // does not change

            long timeStamps[] = new long[3];
            timeStamps[0] = System.currentTimeMillis();
            timeStamps[1] = timeStamps[0] + 1; // milli sec later
            timeStamps[2] = timeStamps[1] + 1000; // second later

            float[][] values = new float[3][];
            // 1st measure .. just one value
            float[] valueSet = new float[1];
            values[0] = valueSet;
            valueSet[0] = (float) 1.5; // example value 1.5 degrees

            // 2nd measure .. just three values
            valueSet = new float[3];
            values[1] = valueSet;
            valueSet[0] = (float) 0.7;
            valueSet[1] = (float) 1.2;
            valueSet[2] = (float) 2.1;

            // 3rd measure .. two values
            valueSet = new float[2];
            values[2] = valueSet;
            valueSet[0] = (float) 0.7;
            valueSet[1] = (float) 1.2;

            // write three data set into a file
                String dataset = "";
                for(int i=0; i< timeStamps.length ; i++){
                    dataset += sensorName + " " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timeStamps[i]) +"\r\n";
                    for (int j = 0; j< values[i].length; j++){
                        dataset += "Value " + j + ": " + values[i][j] + " ";
                    }
                    dataset += "\r\n";
                }

            String filename = "logFile.txt";
            try{

                OutputStream os = new FileOutputStream(filename);
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeBytes(dataset);
            }catch (Exception e){
                System.out.println("Logging Datasets failed");
            }




            // read data from file and print to System.out




            try {
                FileInputStream is = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                while(br.ready()){
                    System.out.println(br.readLine());
                }





            }catch(Exception e){
                System.out.println(e);
            }
        }
}


