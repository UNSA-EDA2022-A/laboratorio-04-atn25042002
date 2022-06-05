package com.example.project;
import java.util.ArrayList;

public class SinglyLinkedList<T> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void deleteDuplicates() {
        if(isEmpty()) // Si la lista esta vacia no hace nada
            return;
        ArrayList<Node<T>> lst = new ArrayList<Node<T>>();
        Node<T> aux= first;
        for(int i= 0; i< size; i++){ //Recorre los elementos
            if(lst.contains(aux)) //Si el ArrayList ya contenia el elemento lo borra
                deleteNth(i);
            else //Caso contrario lo anade
                lst.add(aux);
            aux= aux.getNext();
        }
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {
        Node<T> aux = first;
        if(position > size) //Si la posicion es mayor al indice maximo + 1 no hara nada
            return;
        if(position == size){ //Si la posicion es el ultimo elemento, ejectua addLast
            addLast(data);
            return;
        }
        if(position== 0){ //Si la posicion es el primer elemento, ejecuta addFirst
            addFirst(data);
            return;
        }

        for(int i= 0; i< position - 1; i++){ //Selecciona al elemento anterior en donde se va a insertar
            aux= aux.getNext();
        }
        aux.setNext(new Node(data, aux.getNext())); //Modifica el nodo, relacionandolo con el insertado
        size++;//Aumenta el tamano
    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
        Node<T> aux = first;
        if(position > size - 1) //Si la posicion es mayor al indice maximo, no hace nada
            return;
        if(position == size - 1){// Si la posicion es el ultimo elemento ejecuta removeLast
            removeLast();
            return;
        }
        if(position== 0){ // Si la posicion es el primer elemento ejecuta removeFirst
            removeFirst();
            return;
        }
        for(int i= 0; i< position - 1; i++){//Selecciona el elemento anterior al que se va a eliminar
            aux= aux.getNext();
        }
        aux.setNext(aux.getNext().getNext());//Relaciona el elemento anterior con el elemento siguiente
        size--; //Disminuye el tamano
    }

    public static void main(final String[] args) {

        // testExercicio1();
        // testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}
