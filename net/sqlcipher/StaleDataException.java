package net.sqlcipher;

public class StaleDataException extends RuntimeException {
    public StaleDataException(String str) {
        super(str);
    }
}
