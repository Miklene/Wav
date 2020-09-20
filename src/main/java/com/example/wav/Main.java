package com.example.wav;

import com.example.buffer.ComplexWaveBuffer;
import com.example.wave.*;

import java.util.ArrayList;

public class Main {
    static ComplexWave wave;
    static ComplexWaveBuffer complexWaveBuffer;

    public static void main(String[] args) {
        long start = System.nanoTime();
       /* SinWave mainTone = new SinWave(200,100, ViolinCoefficients.degrees[0]);
        waveHarmonics = WaveHarmonicCreator.createWaveHarmonics(mainTone, 31 );*/
        wave = new ViolinWave(200, 100, 31);
        complexWaveBuffer = new ComplexWaveBuffer(wave);
        float[] buffer = complexWaveBuffer.createBuffer(1000);
        buffer[0]++;
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        long result=0;

        int attempts =1000;
        for (int i = 0; i < attempts; i++) {
            System.out.println(i);
            result += countAlgorithmSpeed();
        }
        System.out.println(result/attempts);
    }

    private static long countAlgorithmSpeed() {
        long start = System.nanoTime();
        wave = new ViolinWave(200, 100, 31);
        complexWaveBuffer = new ComplexWaveBuffer(wave);
        float[] buffer = complexWaveBuffer.createBuffer(1000);
        long finish = System.nanoTime();
        return finish - start;
    }
}
