package org.jtools;


import org.jtools.cli.ParseCliService;
import org.jtools.command.AllCommand;
import org.jtools.command.CheckSum;
import picocli.CommandLine;


public class Main {

    public static void main(String[] args) {
        try {
            if(false) {
                var parse = new ParseCliService();
                parse.parse(args);
            }else {
                int exitCode = new CommandLine(new AllCommand()).execute(args);
                System.exit(exitCode);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
