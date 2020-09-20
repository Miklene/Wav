package com.example.wave;

import com.example.wave.SinWave;

public class WaveHarmonic extends SinWave {
    /* private float frequency;
     private float amplitude;
     private double phase;*/
    //private short[] buffer;
    SinWave mainTone;

    public WaveHarmonic(float frequency, float amplitude, double degrees, SinWave mainTone) {
        super(frequency, amplitude, degrees);
        this.mainTone = mainTone;
    }


   /* public short[] getBuffer() {
        return buffer;
    }
    public void setBuffer(short[] buffer) {
        this.buffer = buffer;
    }*/


    private static float[] addFloatWave(float[] buff, float[] waveHarmonicsBuffer) {
        int size = buff.length;
        for (int i = 0; i < size; i++)
            buff[i] = buff[i] + waveHarmonicsBuffer[i];
        return buff;
    }
}
