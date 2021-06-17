package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        ArrayList<Socket> clientSockets = new ArrayList<>();    // учитываем кол-во подключений (клиентов)
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаём серверный сокет
            System.out.println("Сервер запущен");
            while (true){   // бесконечный цикл для ожидания подключения клиентов
                System.out.println("Ожидаю подключения клиента");
                // Создав объект типа ServerSocket необходимо выяснить, что с сервером кто-то хочет соединиться.
                // Тут подключается метод accept(). Искомый ждёт пока кто-либо не захочет подсоединится к нему,
                // и когда это происходит возвращает объект типа Socket
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                clientSockets.add(socket);  // добавляем в коллекцию сокет подключившегося клиента
                DataInputStream in = new DataInputStream(socket.getInputStream()); // поток ввода (что-то пришло от клиента)
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // поток вывода
                ArrayList<String> clientNames = new ArrayList<>();    // создаем хранилище для имен клиентов
                String welcomeMsg = "Вы успешно подключились к серверу. Введите ваше имя";  // запрашиваем у подключ клиента его имя
                out.writeUTF(welcomeMsg);  // отправляем сообщ подключ клиенту
                String clientName = in.readUTF();
                clientNames.add(clientName);  // добавляем ответ-имя в хранилище

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        while (true){
                            try{
                                request = in.readUTF(); // Ожидание сообщения от клиента
                                System.out.println("Пришло сообщение от: "+clientName+": "+request);   // фиксирование события на сервере
                                request = clientName+" написал: "+request;
                                for (Socket clientSocket: clientSockets) {  // реализация отправки принятого сообщ ВСЕМ, кроме того, кто отправил
                                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                                    if (clientSocket==socket) { continue;}
                                    out.writeUTF(request.toUpperCase(Locale.ROOT));
                                }
//                                out.writeUTF(request.toUpperCase(Locale.ROOT));
                            }catch(IOException ex){
                                ex.printStackTrace();
                                System.out.println("Клиент "+clientName+" пал. Вычеркиваем.");
                                clientSockets.remove(socket);
                                clientNames.remove(clientName);
                                break;
                            }
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
