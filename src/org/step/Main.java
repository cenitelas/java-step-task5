package org.step;

public class Main {

    public static void main(String[] args) throws InterruptedException {
            System.out.println(ReadProperties.readProperties("src/org/step/task.properties", "name"));
    }
}
