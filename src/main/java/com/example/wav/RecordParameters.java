package com.example.wav;

public interface RecordParameters {
    int sampleRate = 44100;
    float dt = 1f / sampleRate;
    float twoPI = (float) (2 *Math.PI);
}
