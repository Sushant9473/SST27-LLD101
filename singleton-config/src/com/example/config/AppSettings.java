package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile boolean instanceCreated = false;
    private final Properties props = new Properties();

    private AppSettings() {
        if (instanceCreated) {
            throw new RuntimeException("Reflection is not allowed: Singleton already created");
        }
        instanceCreated = true;
    }

    private static class Holder {
        private static final AppSettings INSTANCE = new AppSettings();
    }

    public static AppSettings getInstance() {
        return Holder.INSTANCE;
    }

    // Preserve singleton on deserialization
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
