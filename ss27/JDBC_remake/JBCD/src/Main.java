package src;

import src.presentation.StudentUI;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentUI studentUI = new StudentUI();
        studentUI.displayListStudents();
    }
}