package com.example.buffer;

public class Buffer implements Comparable{
    float[] buffer;

    public Buffer(float[] buffer) {
        this.buffer = buffer;
    }

    public float[] getBuffer() {
        return buffer;
    }

    public void setBuffer(float[] buffer) {
        this.buffer = buffer;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
