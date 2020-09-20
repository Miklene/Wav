package com.example.wave;

import com.example.wav.Type;

import static com.example.wav.RecordParameters.dt;

public class SinWave {
    private float frequency;
    private float amplitude;
    private double initialPhase;
    private float phase;
    private Type type;


    public SinWave(float frequency, float amplitude, double initialPhase) {
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.type = Type.SIN;
        this.initialPhase = initialPhase;
        phase = 0;
    }

    public float getFrequency() {
        return frequency;
    }

    public float getAmplitude() {
        return amplitude;
    }

    public float getPhase() {
        return phase;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setAmplitude(float amplitude) {
        this.amplitude = amplitude;
    }

    public void setPhase(float phase) {
        this.phase = phase;
    }


    protected void countPhase(float d) {
        float T = 1 / frequency;
        phase = phase + d / T;
        phase -= (int) phase;
    }








   /* public float[] makeBuffer(int duration) {
        float[] buffer = new float[duration];
        for (int i = 0; i < duration; i++) {
            buffer[i] = (float) (amplitude * Math.sin(twoPI * (frequency * i * dt + phase)));// * (wave.getWaveVolume()) * systemVolume);
        }
        countPhase(duration*dt);
        return buffer;
    }*/
}
