package br.com.etechoracio.aplicacaoTcc.chatserver;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static PrintWriter out;// envia mensagem pro servidor

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Altere para o IP do servidor se necessário
        try (Socket socket = new Socket(serverAddress, 12345)) {//Cria um socket do cliente que se conecta ao servidor no endereço e na porta especificados (12345).
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);//Cria um scanner para ler a entrada do usuário a partir do console.
            new Thread(() -> {// Uma nova thread é criada para ouvir mensagens do servidor. Dentro dessa thread:
                //Um loop lê mensagens do servidor até que a conexão seja fechada.
                        //Cada mensagem recebida é exibida no console do cliente.
                String message;
                try {
                    while ((message = in.readLine()) != null) {//aguarda a entrada do usuario
                        System.out.println("Mensagem: " + message);
                    }
                } catch (IOException e) {//pega a saida durante a comunicacao
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                String message = scanner.nextLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
