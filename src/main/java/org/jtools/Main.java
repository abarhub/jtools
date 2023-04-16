package org.jtools;


import org.jtools.cli.ParseCliService;


public class Main {

    public static void main(String[] args) {
        try {
            var parse = new ParseCliService();
            parse.parse(args);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
