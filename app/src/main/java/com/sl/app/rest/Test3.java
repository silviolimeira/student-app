package com.sl.app.rest;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    static class Client implements Comparable<Test2.Client> {
        int id;
        String name;
        int stock;
        public Client(int id, String name, int stock) {
            this.id = id;
            this.name = name;
            this.stock = stock;
        }
        @Override
        public int compareTo(Test2.Client o) {
            return (this.id - o.id);
        }

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", stock=" + stock +
                    '}';
        }
    };

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(0, new Client(2, "Y client", 2));
        clients.add(0, new Client(1, "Z client", 1));
        clients.add(new Client(4, "W client", 4));
        clients.add(2, new Client(3, "X client", 3));
        System.out.println(clients);
        Client client = clients.stream().filter(c -> c.id == 3).toList().get(0);
        client.stock *= 10;
        System.out.println(clients);

    }
}
