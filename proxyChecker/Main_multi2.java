import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://project/edu_0759/proxyChecker/ip.txt");
            int i;
            String proxy = "";
            while((i=fis.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port= proxy.split(":")[1];
                    Thread myRunnableThread = new Thread(new MyRunnableThread(ip, Integer.parseInt(port)));
                    myRunnableThread.start();
                    proxy = "";
                }else if(i!=9){
                    proxy += (char) i;
                }else{
                    proxy += ":";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnableThread implements Runnable { // 2-й
    private String ip;
    private int port;

    public MyRunnableThread(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection urlConnection = url.openConnection(proxy);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int i;
            StringBuilder result = new StringBuilder();
            while ((i = reader.read()) != -1){
                result.append((char) i);
            }
            System.out.println(result);
            FileOutputStream fos = new FileOutputStream("C://project/edu_0759/proxyChecker/good_ip_multi2.txt", true); // для 2-го способа назв. файлов *_multi2.txt
            String text = ip+":"+port+"\n";
            byte[] buffer = text.getBytes();
            fos.write(buffer);

        } catch (IOException exception) {
            System.out.println(ip+" - не работает!");
        }
    }
}
