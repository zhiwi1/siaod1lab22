package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Из круга удаляем каждого k-го. Введите k");
        int k;
        do {
            while (!in.hasNextInt()) {
                System.out.println("Неверный ввод");
                in.next();
            }

            k = in.nextInt();
        }
        while (k >= 64 || k <= 0);
        List list = new List();
        for (int N = 1; N <= 64; N++) {
            System.out.printf("| Оставшееся ребята из%3d |\t",N);
            List l = generateList(N);
            l.delStep(k);
            l.vyvod();
            System.out.println("\n");


        }

    }



    static List generateList(int N) {
        List list = new List();
        for (int i = 0; i < N; i++) {
            list.addEl(i);
        }
        return list;
    }
}


class Link {
    public Link next;
    int n;


    Link(int n) {
        this.n = n;


    }


    public int getN() {
        return n;
    }


    public void setN(int n) {
        this.n = n;
    }
}

class List {
    Link first;
    int size;

    List() {

    }

    public void delete(int key)
    {
        Link current = first;
        Link previous = first;
        while (current.n != key) {

            previous = current;
            current = current.next;
        }

        if (current == first)
            first = first.next;
        else
            previous.next = current.next;

    }

    public void delStep(int step) {
        Link current = first;
        Link previous = first;
        while (size >= step) {
            for (int i = 1; i < step; i++) {

                previous = current; // Перейти к следующему элементу
                current = current.next;
            }
            if (current == first)
            {
                first = first.next;
                previous.next = current.next;
                current=current.next;
                size--;
            }
            else {

                previous.next = current.next;
                current=current.next;
                size--;
            }
        }
    }

    public void addEl(int n) {
        if (first == null) {
            first = new Link(n);
            first.next = first;
            size++;
        } else {
            Link current = first;
            while (current.next != first) {
                current = current.next;
            }
            current.next = new Link(n);
            current = current.next;
            current.next = first;
            size++;
        }


    }

    public Link getEl(int index) {
        Link current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void vyvod() {
        Link current = first;
        for (int i = 0; i < size; i++) {

            if (current.next != first) {

                System.out.printf("%d\t", current.n);
                current = current.next;
                System.out.print("|");
            } else {

                System.out.printf("%d\t", current.n);
                System.out.print("|");
                break;
            }
        }

    }
}
