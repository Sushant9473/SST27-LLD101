package com.example.video;

public class SharpenAdapter {
    private LegacySharpen legacySharpen;

    public SharpenAdapter() {
        this.legacySharpen = new LegacySharpen();
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        String framesHandle = "FRAMES_" + frames.length;
        legacySharpen.applySharpen(framesHandle, strength);
        return frames;
    }
}
