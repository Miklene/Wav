package com.example.wav;

public class WavHeader32Bit extends WavHeader {

    public WavHeader32Bit(short numChannels, int dataSize) {
        super(numChannels,dataSize);
        blockAlign = 4;
        bitsPerSample = 32;
        calculateSubChunk2Size();
        calculateByteRate();
    }
}
