package com.example.wave;

import com.example.wave.ComplexWave;
import com.example.wave.SinWave;

import java.util.ArrayList;

public class TriangleWave extends ComplexWave {


    public TriangleWave(float frequency, float amplitude, int harmonicsNumber) {
        super(frequency, amplitude, harmonicsNumber);
    }

    @Override
    void createMainTone(float frequency, float amplitude) {
        mainTone = new SinWave(frequency, amplitude,0);
    }

    @Override
    void createWaveHarmonics(int harmonicsNumber) {

    }
}
