package com.example.buffer;

import com.example.wav.RecordParameters;
import com.example.wave.ComplexWave;
import com.example.wave.SinWave;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ComplexWaveBuffer {
    ComplexWave complexWave;
    ReadyBuffers readyBuffers;
    SinWaveBuffer mainToneBuffer;
    SinWaveBuffer harmonicBuffer;
    ArrayList<SinWaveBuffer> harmonicBuffers;

    public ComplexWaveBuffer(ComplexWave complexWave) {
        this.complexWave = complexWave;
        harmonicBuffers = new ArrayList<>();
        //readyBuffers = new ReadyBuffers();
    }

    public float[] createBufferSingleThread(int duration) {
        float[] buffer;
        int harmonicsNumber = complexWave.getWaveHarmonics().size();
        readyBuffers = new ReadyBuffers(harmonicsNumber);
        mainToneBuffer = new SinWaveBuffer(complexWave.getMainTone(), duration, readyBuffers);
        mainToneBuffer.makeSinBuffer();
        for (int i = 0; i < harmonicsNumber; i++) {
            harmonicBuffer = new SinWaveBuffer(complexWave.getWaveHarmonics().get(i), duration, readyBuffers);
            harmonicBuffer.makeSinBuffer();
        }
        for (int i = 0; i < harmonicsNumber; i++) {
            readyBuffers.putBuffer(addBuffer(readyBuffers.getBuffer(), readyBuffers.getBuffer()));
        }
        buffer = readyBuffers.getBuffer();
        return buffer;

    }


    public float[] createBuffer(int duration) {

        float[] buffer;
        int harmonicsNumber = complexWave.getWaveHarmonics().size();
        readyBuffers = new ReadyBuffers(harmonicsNumber);
        ArrayList<Future<float[]>> readyBuffer = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(harmonicsNumber/4);
        readyBuffer.add(executorService.submit(
                new CallableSinWaveBuffer(complexWave.getMainTone(), duration,readyBuffers)));

        for (int i = 0; i < harmonicsNumber; i++) {
            readyBuffer.add(executorService.submit(
                    new CallableSinWaveBuffer(complexWave.getWaveHarmonics().get(i),duration,readyBuffers)));
        }
        for (Future<float[]> fs : readyBuffer) {
            try {
                readyBuffers.putBuffer(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }
        }
        long start = System.nanoTime();
        while (readyBuffers.getNumberOfOperations() != 0){
            tryAddBuffer();
        }
        long finish = System.nanoTime();
        System.out.println(finish - start);
        buffer = readyBuffers.getBuffer();
        executorService.shutdown();
        return correctAmplitude(buffer);
    }

    private float[] correctAmplitude(float[] buffer) {
        float correctionValue = findMaxAmplitude(buffer) + 0.0001f;
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = buffer[i] / correctionValue;
        }
        return buffer;
    }

    private float findMaxAmplitude(float[] buffer) {
        float max;
        max = buffer[0];
        for (int i = 0; i < buffer.length; i++) {
            if (max < buffer[i])
                max = buffer[i];
        }
        return max;
    }


    private float[] addBuffer(float[] buf1, float[] buf2) {
        int duration = buf1.length;
        for (int i = 0; i < duration; i++)
            buf1[i] += buf2[i];
        return buf1;
    }

    private synchronized void tryAddBuffer() {
        if (readyBuffers.getSize() > 1)
            readyBuffers.putBuffer(addBuffer(readyBuffers.getBuffer(), readyBuffers.getBuffer()));
    }
}
