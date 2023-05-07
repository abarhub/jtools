package org.jtools.command;


import org.jtools.utils.StdOutputImpl;
import picocli.CommandLine;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "timestamp",
        description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
public class Timestamp implements Callable<Integer> {

    @Parameters(index = "0", description = "The file whose checksum to calculate.")
    private long timestamp;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
//        byte[] fileContents = Files.readAllBytes(file.toPath());
//        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
//        System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        TimestampParameters parameters = new TimestampParameters(""+timestamp);
        var timestampCmd=new TimestampCommand(new StdOutputImpl());
        timestampCmd.run(parameters);
        return 0;
    }

}
