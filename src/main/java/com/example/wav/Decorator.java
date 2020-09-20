package com.example.wav;

import com.example.wave.SinWave;
import com.example.wave.ViolinCoefficients;
import com.example.wave.WaveHarmonic;

public class Decorator implements ViolinCoefficients {
    private static final int[] amplitudeRatios = {  825, 896, 360, 522, 309, 20, 388, 191,
            612, 610, 255, 168, 131, 46,  56,  56,
            74, 132,  30,  80,  30, 68,  22,  43,
            16,  20,  16,   7,   6,  6,   5};
    private static final int[] amplitudeRatios2 = {1203, 833, 488, 771, 315, 392, 633, 263,
            759, 1348, 549, 355, 143, 56, 69, 114,
            98, 173, 109, 44, 39, 51, 13, 54,
            13, 13, 13, 12, 10, 15, 3};

    private static final int[] amplitudeRatios3 = {2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 25,
            26, 27, 28, 29, 30, 31, 32};

  /*  public static void addWaveHarmonic(SinWave wave, int number) {
        int harmonicsNumber;
        float frequency;
        int frequencyRatio;
        double [] degrees = ViolinCoefficients.getDegrees();
        for(int i =0;i<number; i++) {
            harmonicsNumber = wave.getHarmonicsNumber();
            frequencyRatio = harmonicsNumber + 2;
            frequency = wave.getFrequency() * frequencyRatio;
            WaveHarmonic waveHarmonic = new WaveHarmonic(frequency, amplitudeRatios[harmonicsNumber],degrees[i+1]);
            wave.addHarmonic(waveHarmonic);
        }
    }*/

    public static SinWave createWaveHarmonics(SinWave mainTone, int number){
        //ArrayList<SinWave> waveHarmonics = new ArrayList<SinWave>();
        // int harmonicsNumber;
        float mainFrequency =  mainTone.getFrequency();
        float frequency;
        int frequencyRatio;
        double [] degrees = ViolinCoefficients.initialPhase;
        for(int i =0;i<number; i++) {
            frequencyRatio = i + 2;
            frequency = mainFrequency * frequencyRatio;
            mainTone = new WaveHarmonic(frequency, amplitudeRatios[i],degrees[i+1],mainTone);
            //waveHarmonics.add(waveHarmonic);
        }
        return mainTone;
    }
}
