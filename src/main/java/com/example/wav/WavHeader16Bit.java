package com.example.wav;

public class WavHeader16Bit extends WavHeader {

    public WavHeader16Bit(short numChannels, int dataSize) {
        super(numChannels, dataSize);
        blockAlign = 2;
        bitsPerSample = 16;
        calculateSubChunk2Size();
        calculateByteRate();
    }
}
