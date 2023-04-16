package org.jtools.command;

import org.jtools.utils.StdOutput;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

public class TimestampCommand {

    private final StdOutput stdOutput;

    public TimestampCommand(StdOutput stdOutput) {
        this.stdOutput = Objects.requireNonNull(stdOutput);
    }

    public Optional<String> run(TimestampParameters parameters) {
        long value;
        if (parameters.value().length() <= 10) {
            value = Long.parseLong(parameters.value()) * 1000L;
        } else {
            value = Long.parseLong(parameters.value());
        }
        var instant = Instant.ofEpochMilli(value);
        stdOutput.println(instant);
        return Optional.empty();
    }
}
