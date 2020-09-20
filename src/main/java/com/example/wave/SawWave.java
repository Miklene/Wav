package com.example.wave;

import java.util.ArrayList;

public class SawWave extends ComplexWave {


    public SawWave(float frequency, float amplitude, int harmonicsNumber) {
        super(frequency, amplitude, harmonicsNumber);
    }

    @Override
    void createMainTone(float frequency, float amplitude) {
        mainTone = new SinWave(frequency, amplitude,0);
    }

    @Override
    void createWaveHarmonics(int harmonicsNumber) {
        float frequency = mainTone.getFrequency();
        float amplitude  = mainTone.getAmplitude();
        for(int i = 0; i<harmonicsNumber; i++) {
            waveHarmonics.add(new SinWave(frequency*(i+2), amplitude/(i+2), 0 ));
        }
    }
}
