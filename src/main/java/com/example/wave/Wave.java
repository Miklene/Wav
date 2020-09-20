package com.example.wave;

import com.example.wav.Type;

import java.util.ArrayList;

public abstract class Wave {
    protected float frequency;
    protected float amplitude;
    protected int harmonicsNumber;
    protected int channelsNumber;
    protected Type type;
    protected double phase;

    protected ArrayList<WaveHarmonic> waveHarmonics = new ArrayList<WaveHarmonic>();

    public void addHarmonic(WaveHarmonic waveHarmonic) {
        waveHarmonics.add(waveHarmonic);
        harmonicsNumber = waveHarmonics.size();
    }

    public ArrayList<WaveHarmonic> getWaveHarmonics() {
        return waveHarmonics;
    }

   /*public float[] makeBuffer(){
        return bufferable.makeBuffer();
    }*/

    public float getFrequency() {
        return frequency;
    }

    public float getAmplitude() {
        return amplitude;
    }

    public int getHarmonicsNumber() {
        return harmonicsNumber;
    }
}
