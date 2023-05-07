package org.jtools.command;

import picocli.CommandLine;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import static picocli.CommandLine.*;

@Command(name = "allcmd", mixinStandardHelpOptions = true, version = "4.0",
        description = "all command",
subcommands = {
        CheckSum.class,
        Timestamp.class
})
public class AllCommand {
}
