package org.jtools.command;

import org.jtools.utils.StdOutput;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StdMockOutput implements StdOutput {

    private final List<Object> list = new CopyOnWriteArrayList<>();


    @Override
    public void println(String message) {
        list.add(message);
    }

    @Override
    public void println(Object object) {
        list.add(object);
    }

    public List<Object> getList() {
        return list;
    }
}
