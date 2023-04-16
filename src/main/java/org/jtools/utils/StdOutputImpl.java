package org.jtools.utils;

public class StdOutputImpl implements StdOutput{
    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}
