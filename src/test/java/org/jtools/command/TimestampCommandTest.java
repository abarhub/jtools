package org.jtools.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class TimestampCommandTest {

    private StdMockOutput output;

    private TimestampCommand timestampCommand;

    @BeforeEach
    void setUp() {
        output=new StdMockOutput();
        timestampCommand=new TimestampCommand(output);
    }

    @Test
    void runUnix() {
        // ARRANGE
        var param=new TimestampParameters("1681637297");

        // ACT
        timestampCommand.run(param);

        // ASSERT
        var list=output.getList();
        assertEquals(1,list.size());
        assertEquals(Instant.parse("2023-04-16T09:28:17Z"),list.get(0));
    }

    @Test
    void runMilli() {
        // ARRANGE
        var param=new TimestampParameters("1681645927312");

        // ACT
        timestampCommand.run(param);

        // ASSERT
        var list=output.getList();
        assertEquals(1,list.size());
        assertEquals(Instant.parse("2023-04-16T11:52:07.312Z"),list.get(0));
    }
}