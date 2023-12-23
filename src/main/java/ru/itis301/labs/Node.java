package ru.itis301.labs;

public class Node {
    public Stage stage;
    public Node next;
    public Node prev;
    public Node(Stage stage) {
        this.stage = stage;
    }
}
