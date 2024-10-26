package com.sl.app.rest;

import java.util.Arrays;

public class Test2 {

    static class Client implements Comparable<Client> {
        int id;
        String name;
        int stock;
        public Client(int id, String name, int stock) {
            this.id = id;
            this.name = name;
            this.stock = stock;
        }
        @Override
        public int compareTo(Client o) {
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
        Client[] clients = new Client[4];
        clients[0] = new Client(1, "Z client", 1);
        clients[1] = new Client(2, "Y client", 2);
        clients[2] = new Client(3, "X client", 3);
        clients[3] = new Client(4, "W client", 4);
        Arrays.sort(clients);
        System.out.println(Arrays.toString(clients));
        int index = Arrays.binarySearch(clients, new Client(3,null, 0));
        clients[index].stock *= 10;
        System.out.println(Arrays.toString(clients));
    }


}
