package org.jtools.cli;

import org.jtools.command.TimestampCommand;
import org.jtools.command.TimestampParameters;
import org.jtools.utils.NumberUtils;
import org.jtools.utils.StdOutputImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParseCliService {

    public Optional<String> parse(String[] args) throws InvalidCliParametersException {
        if (args != null && args.length > 0) {
            var command = args[0];
            Optional<CommandEnum> commandSelected = Optional.empty();
            for (var cmd : CommandEnum.values()) {
                if (command.equalsIgnoreCase(cmd.name())) {
                    commandSelected = Optional.of(cmd);
                }
            }
            if (commandSelected.isEmpty()) {
                throw new InvalidCliParametersException("invalid command : " + command);
            } else {
                List<String> listParameters = new ArrayList<>();
                if (args.length > 1) {
                    listParameters = Arrays.stream(args).skip(1).toList();
                }
                switch (commandSelected.get()) {
                    case TIMESTAMP -> {
                        if (listParameters.size() == 1) {
                            var s = listParameters.get(0);
                            if (NumberUtils.isNumber(s)) {
                                TimestampParameters parameters = new TimestampParameters(s);
                                var timestamp = new TimestampCommand(new StdOutputImpl());
                                return timestamp.run(parameters);
                            } else {
                                throw new InvalidCliParametersException("Parameter must be a number");
                            }
                        } else {
                            throw new InvalidCliParametersException("One parameter needed");
                        }
                    }
                    default -> throw new InvalidCliParametersException("invalide command : " + commandSelected.get());
                }
            }
        } else {
            throw new InvalidCliParametersException("No parameters");
        }
    }
}
