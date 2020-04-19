public class WaveMaker {
    public static final int SINE = 0;
    public static final int SQUARE = 1;
    public static final int TRIANGLE = 2;
    public static final int SAWTOOTH = 3;

    private static final int sampleRate = 44100;
    private static double startAmplitude = 1;
    private static double amplitude;
    private static int time = 2;           // duration of sound in seconds
    private static double angle;

    /**
     * Form and return proper wave
     *
     * @param waveForm  Integer which describes type of wave (Sine, Square, Triangle or Sawtooth wave)
     * @param frequency Double which is frequency of wave
     * @return return wave (Bytes array)
     */
    public static byte[] getWave(int waveForm, double frequency) {
        amplitude = startAmplitude;
        byte[] wave = new byte[time * sampleRate];

        switch (waveForm) {
            case SINE:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate);
                    wave[i] = (byte) (amplitude * Math.sin(angle) * Byte.MAX_VALUE);
                }
                break;

            case SQUARE:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate);

                    if (Math.sin(angle) >= 0.0)
                        wave[i] = (byte) (amplitude * 0.2 * Byte.MAX_VALUE);
                    else
                        wave[i] = (byte) (amplitude * 0.2 * Byte.MIN_VALUE);
                }
                break;

            case TRIANGLE:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate);
                    wave[i] = (byte) ((amplitude * (1.4 / Math.PI) * Math.asin(Math.sin(angle)) * Byte.MAX_VALUE));
                }
                break;

            case SAWTOOTH:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate);
                    // Adding subsequent sines to create sawtooth wave:
                    for (int j = 1; j < 35; j++) {
                        wave[i] += (byte) (0.7 * amplitude / Math.PI * -Math.sin(j * angle) / j * Byte.MAX_VALUE);
                    }
                }
                break;

        }
        amplitude = startAmplitude;
        return wave;
    }

    /**
     * Form and return proper wave with Vibrato effect
     *
     * @param waveForm            Integer which describes type of wave (Sine, Square, Triangle or Sawtooth wave)
     * @param frequency           Double which is frequency of wave
     * @param modulationFrequency Double which is frequency of Vibrato modulation
     * @return return wave (Bytes array)
     */
    public static byte[] getWave(int waveForm, double frequency, double modulationFrequency) {
        double[] timeArray = new double[time * sampleRate];
        for (int i = 0; i < timeArray.length; i++) {
            timeArray[i] = (double) (i + 1) / sampleRate;
        }

        amplitude = startAmplitude;
        byte[] wave = new byte[time * sampleRate];

        switch (waveForm) {
            case SINE:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate) - 10 * Math.sin(2 * Math.PI * modulationFrequency * timeArray[i]);
                    wave[i] = (byte) (amplitude * Math.sin(angle) * Byte.MAX_VALUE);
                }
                break;

            case SQUARE:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate) - 10 * Math.sin(2 * Math.PI * modulationFrequency * timeArray[i]);
                    if (Math.sin(angle) >= 0.0)
                        wave[i] = (byte) (amplitude * 0.2 * Byte.MAX_VALUE);
                    else
                        wave[i] = (byte) (amplitude * 0.2 * Byte.MIN_VALUE);
                }
                break;

            case TRIANGLE:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate) - 10 * Math.sin(2 * Math.PI * modulationFrequency * timeArray[i]);
                    wave[i] = (byte) ((amplitude * (1.4 / Math.PI) * Math.asin(Math.sin(angle)) * Byte.MAX_VALUE));
                }
                break;

            case SAWTOOTH:
                for (int i = 0; i < wave.length; i++) {
                    amplitude = getAmplitude(i, wave.length);
                    angle = (2.0 * Math.PI * i * frequency / sampleRate) - 10 * Math.sin(2 * Math.PI * modulationFrequency * timeArray[i]);
                    // Adding subsequent sines to create sawtooth wave
                    for (int j = 1; j < 35; j++) {
                        wave[i] += (byte) (0.7 * amplitude / Math.PI * -Math.sin(j * angle) / j * Byte.MAX_VALUE);
                    }
                }
                break;

        }
        amplitude = startAmplitude;
        return wave;
    }

    /**
     * Envelope-like function.
     * Returns proper value of amplitude which depends on the current wave time.
     *
     * @param i          Integer which is index for for
     * @param waveLength Integer which describes length of wave bytes array
     * @return return current value of amplitude
     */
    private static double getAmplitude(int i, int waveLength) {
        if (i >= (0.2 * waveLength) && i < (0.6 * waveLength)) {
            amplitude -= 0.5 * amplitude / waveLength;
        }
        if (i >= 0.8 * waveLength) {
            amplitude -= 150 * amplitude / waveLength;
            if (amplitude <= 0) {
                amplitude = 0;
            }
        }
        return amplitude;
    }

    /**
     * Set amplitude to given value
     *
     * @param amplitude Double value to which amplitude is being set
     */
    public static void setAmplitude(double amplitude) {
        startAmplitude = amplitude;
    }

    /**
     * Set time to given time
     *
     * @param timeToSet Integer value to which time is being set
     */
    public static void setTime(int timeToSet) {
        time = timeToSet;
    }
}
