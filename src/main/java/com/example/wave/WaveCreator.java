package com.example.wave;

import com.example.wav.Type;

import java.util.ArrayList;

public class WaveCreator {

    public static ComplexWave createWave(Type type, float frequency, float amplitude, int harmonicsNumber) {
        SinWave mainTone;
        ArrayList<SinWave> waveHarmonics;
        if (type.equals(Type.SAW)) {

          //  wave = new SinWave(frequency, amplitude, channelsNumber, harmonicsNumber);
            //return wave;
        } else
            if(type.equals(Type.VIOLIN)){
                mainTone = new SinWave(frequency,amplitude, ViolinCoefficients.initialPhase[0]);
                waveHarmonics = WaveHarmonicCreator.createWaveHarmonics(mainTone,harmonicsNumber);
            }
        return null;

       /* if(num ==2) {
            wave = new SinWave2(frequency, amplitude, channelsNumber, harmonicsNumber);
            return wave;
        }
        wave = new SawWave(frequency, amplitude, channelsNumber, harmonicsNumber);
        return wave;
    }*/
    }
}
