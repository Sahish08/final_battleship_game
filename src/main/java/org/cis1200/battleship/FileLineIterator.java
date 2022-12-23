package org.cis1200.battleship;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class FileLineIterator implements Iterator<String> {

    // Add the fields needed to implement your FileLineIterator
    private BufferedReader reader;
    private String curr;
    private boolean done = false;

    public FileLineIterator(BufferedReader reader) {
        // Complete this constructor.
        if (reader == null) {
            throw new IllegalArgumentException("Reader cannot be null.");
        } else {
            this.reader = reader;
        }
    }

    public static BufferedReader fileToReader(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("File path is null.");
        }
        BufferedReader r;
        try {
            r = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File path does not exist.");
        }
        return r;
    }

    @Override
    public boolean hasNext() {
        if (this.curr != null) {
            return true;
        } else {
            if (this.done) {
                return false;
            } else {
                try {
                    this.curr = reader.readLine();
                    if (this.curr == null) {
                        reader.close();
                        this.done = true;
                        return false;
                    } else {
                        return true;
                    }
                } catch (IOException io) {
                    try {
                        this.curr = null;
                        this.done = true;
                        reader.close();
                        return false;
                    } catch (IOException i) {

                    }
                }
            }
        }
        return false;
    }

    @Override
    public String next() {
        if (hasNext()) {
            String nxt = this.curr;
            this.curr = null;
            return nxt;
        } else {
            throw new NoSuchElementException("No more data.");
        }
    }
}
