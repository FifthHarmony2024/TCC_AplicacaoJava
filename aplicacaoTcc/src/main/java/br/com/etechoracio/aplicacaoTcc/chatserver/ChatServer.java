package br.com.etechoracio.aplicacaoTcc.chatserver;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clientWriters = new HashSet<>();//permite o envio de mensagens aos clientes

    public static void main(String[] args) {
        System.out.println("Chat Server iniciado...");
        try (ServerSocket serverSocket = new ServerSocket(12345)) {// poque permitem as conexões entre clientes
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();// caso de errado
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        //PrintWriter envia mensagem
        //BufferedReader le mensagem

        public ClientHandler(Socket socket) {
            this.socket = socket;// construtor pro socket
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);// ligam a entrada e saida
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {//conexão fechada
                    System.out.println("Recebido: " + message);
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {// conexão de cliente
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {// comunicação
                e.printStackTrace();
            } finally {//final da comunicação
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }
    }
}
