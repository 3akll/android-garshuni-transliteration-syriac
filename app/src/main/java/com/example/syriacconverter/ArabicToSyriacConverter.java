package com.example.syriacconverter;

public class ArabicToSyriacConverter {

    public static String convertArabicToSyriac(String inputArabic) {
        StringBuilder outputSyriac = new StringBuilder();

        /*
         * No need to call .toLowerCase() in inputArabic.toLowerCase().toCharArray()
         * Because Arabic letters have no uppercase or lowercase forms
         */
        for (char c : inputArabic.toCharArray()) {
            switch (c) {
                case 'ا': outputSyriac.append("ܐ"); break;
                case 'ب': outputSyriac.append("ܒ"); break;
                case 'ت':
                case 'ث':
                    outputSyriac.append("ܬ"); break;
                case 'ج':
                case 'غ':
                    outputSyriac.append("ܓ"); break;
                case 'ح': outputSyriac.append("ܚ"); break;
                case 'خ':
                case 'ك':
                    outputSyriac.append("ܟ"); break;
                case 'د':
                case 'ذ':
                    outputSyriac.append("ܕ"); break;
                case 'ر': outputSyriac.append("ܪ"); break;
                case 'ز': outputSyriac.append("ܙ"); break;
                case 'س': outputSyriac.append("ܣ"); break;
                case 'ش': outputSyriac.append("ܫ"); break;
                case 'ص': outputSyriac.append("ܨ"); break;
                //case 'ض': outputSyriac.append("ܢ"); break;
                case 'ط': outputSyriac.append("ܛ"); break;
                //case 'ظ': outputSyriac.append("ܥ"); break;
                case 'ع': outputSyriac.append("ܥ"); break;
                case 'ف': outputSyriac.append("ܦ"); break;
                case 'ق': outputSyriac.append("ܩ"); break;
                case 'ل': outputSyriac.append("ܠ"); break;
                case 'م': outputSyriac.append("ܡ"); break;
                case 'ن': outputSyriac.append("ܢ"); break;
                case 'ه': outputSyriac.append("ܗ"); break;
                case 'و': outputSyriac.append("ܘ"); break;
                case 'ي': outputSyriac.append("ܝ"); break;

                case '3':outputSyriac.append("\u0651"); break; // Shadda

                default: outputSyriac.append(c);
            }
        }

        return outputSyriac.toString();
    }
}
