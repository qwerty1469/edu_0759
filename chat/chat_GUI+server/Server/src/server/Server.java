package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<User> users = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаём серверный сокет
            System.out.println("Сервер запущен");
            while (true){ // бесконечный цикл для ожидания подключения клиентов
                System.out.println("Ожидаю подключения клиентов...");
                // Создав объект типа ServerSocket необходимо выяснить, что с сервером кто-то хочет соединиться.
                // Тут подключается метод accept(). Искомый ждёт пока кто-либо не захочет подсоединится к нему,
                // и когда это происходит возвращает объект типа Socket
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                User currentUser = new User(socket);
                users.add(currentUser);
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода (что-то пришло от клиента)
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); // Поток вывода
                currentUser.setOos(oos);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        try {
                            currentUser.getOos().writeObject("Добро пожаловать на сервер, "+currentUser.getUserName()+". Введите ваше имя: ");  // запрашиваем у подключ клиента его имя
                            String userName = in.readUTF();
                            currentUser.setUserName(userName);
                            sendUserList(); //Отправляем обновление списка пользователей
                            currentUser.getOos().writeObject(currentUser.getUserName()+" добро пожаловать на сервер!");
                            while (true){
                                    request = in.readUTF(); // Ожидание сообщения от клиента
                                    System.out.println("Клиент прислал: "+request); // фиксирование события на сервере
                                    for (User user: users) { // Перебираем клиентов которые подключенны в настоящий момент
                                        if(currentUser != user){
                                            user.getOos().writeObject(currentUser.getUserName()+": "+request); // реализация отправки принятого сообщ ВСЕМ, кроме того, кто отправил
                                        }
                                    }
                            }
                        } catch (IOException e) {
                            System.out.println("Клиент "+currentUser.getUserName()+" пал. Вычеркиваем.");
                            try {
                                currentUser.getSocket().close();
                                System.out.println("Сокет клиента закрыт? "+currentUser.getSocket().isClosed());
                            } catch (IOException ioException) {
                                System.out.println("Не удалось закрыть сокет");
                            }
                            users.remove(currentUser);
                            for (User user: users) { // Перебираем клиентов которые подключенны в настоящий момент
                                try {
                                    user.getOos().writeObject("Пользователь "+currentUser.getUserName()+" покинул чат"); // Рассылает принятое сообщение всем клиентам
                                } catch (IOException ioException) {
                                    System.out.println("Не удалось отправить в ЧАТ сообщ. о выходе пользователя");
                                }
                            }

                            sendUserList(); //Отправляем обновление списка пользователей
                        }
                    }
                });
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendUserList() {
        String usersName = "**userList**";
        for (User user:users) {
            usersName += "//"+user.getUserName(); // **userList**//user1//user2//user3
        }
        for(User user : users) {
            try {
                user.getOos().writeObject(usersName);
            } catch (IOException ex) {
                System.out.println("Не удалось отправить список пользователей");;
            }
        }
    }
}

