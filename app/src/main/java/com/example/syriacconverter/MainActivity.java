package com.example.syriacconverter;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView outText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Input and output text fields
        EditText inText = findViewById(R.id.inputText);
        outText = findViewById(R.id.outputText);

        Typeface sertoFont = Typeface.createFromAsset(
                getAssets(),
                "fonts/SertoAntochBible_2020_Release.ttf"
        );

        outText.setTypeface(sertoFont);

        inText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();
                String outputSyriac;

                // Check whether the input is empty to avoid accessing an invalid character index
                if (input.isEmpty()) {
                    outText.setText("");
                    return;
                }

                // Check the first character
                char firstChar = input.charAt(0);

                if (isArabic(firstChar)) {
                    outputSyriac = ArabicToSyriacConverter.convertArabicToSyriac(input);
                }
                else {
                    outputSyriac = LatinToSyriacConverter.convertLatinToSyriac(input);
                }

                outText.setText(outputSyriac);
            }

                @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    /*
     * Checks whether a character belongs to an Arabic Unicode range.
     * Uses explicit Unicode ranges instead of Character.UnicodeScript.of(),
     * which requires API 24, to maintain compatibility with the app's
     * minimum supported API level of 23.
     */
    private boolean isArabic(char c) {
        return (c >= '\u0600' && c <= '\u06FF')
                || (c >= '\u0750' && c <= '\u077F')
                || (c >= '\u08A0' && c <= '\u08FF')
                || (c >= '\uFB50' && c <= '\uFDFF')
                || (c >= '\uFE70' && c <= '\uFEFF');
    }
}