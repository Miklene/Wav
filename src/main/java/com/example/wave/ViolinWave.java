package com.example.wave;

public class ViolinWave extends ComplexWave implements ViolinCoefficients {

    public ViolinWave(float frequency, float amplitude, int harmonicsNumber) {
        super(frequency, amplitude, harmonicsNumber);
    }

    @Override
    void createMainTone(float frequency, float amplitude) {
        mainTone = new SinWave(frequency, amplitude,0);
    }

    @Override
    void createWaveHarmonics(int harmonicsNumber) {
        float frequency =  mainTone.getFrequency();
        double[] initialPhase = ViolinCoefficients.initialPhase;
        for(int i =0;i<harmonicsNumber; i++)
            waveHarmonics.add(new SinWave(frequency*(i+2), amplitudeRatios[i], initialPhase[i+1]));
    }
}
