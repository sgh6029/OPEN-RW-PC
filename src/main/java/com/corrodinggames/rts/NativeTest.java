package com.corrodinggames.rts;

public class NativeTest {
    public static void main(String[] args) {
        System.out.println("Java Library Path: " + System.getProperty("java.library.path"));
        try {
            System.loadLibrary("lwjgl64");
            System.out.println("LWJGL loaded successfully");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Failed to load LWJGL: " + e.getMessage());
        }
    }
}
