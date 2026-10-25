package com.example.syriacconverter;

public class LatinToSyriacConverter {

    public static String convertLatinToSyriac(String inputLatin) {
        StringBuilder outputSyriac = new StringBuilder();

        for (char c : inputLatin.toLowerCase().toCharArray()) {
            switch (c) {
                case 'a': outputSyriac.append("ܐ"); break;
                case 'b': outputSyriac.append("ܒ"); break;
                case 'g': outputSyriac.append("ܓ"); break;
                case 'd': outputSyriac.append("ܕ"); break;
                case 'h': outputSyriac.append("ܗ"); break;
                case 'w': outputSyriac.append("ܘ"); break;
                case 'z': outputSyriac.append("ܙ"); break;
                case '7': outputSyriac.append("ܚ"); break;
                case 'ṭ': outputSyriac.append("ܛ"); break;
                case 'y': outputSyriac.append("ܝ"); break;
                case 'k': outputSyriac.append("ܟ"); break;
                case 'l': outputSyriac.append("ܠ"); break;
                case 'm': outputSyriac.append("ܡ"); break;
                case 'n': outputSyriac.append("ܢ"); break;
                case 's': outputSyriac.append("ܣ"); break;
                case '3': outputSyriac.append("ܥ"); break;
                case 'f': outputSyriac.append("ܦ"); break;
                case 'ṣ': outputSyriac.append("ܨ"); break;
                case 'q': outputSyriac.append("ܩ"); break;
                case 'r': outputSyriac.append("ܪ"); break;
                case 'š': outputSyriac.append("ܫ"); break;
                case 't': outputSyriac.append("ܬ"); break;

                case 'é':outputSyriac.append("ܶ"); break;
                case 'à':outputSyriac.append("ܰ"); break;
                case 'o':outputSyriac.append("ܳ"); break;
                case 'ū':outputSyriac.append("ܽ"); break;
                case 'ì':outputSyriac.append("ܺ"); break;

                default: outputSyriac.append(c);
            }
        }

        return outputSyriac.toString();
    }
}
