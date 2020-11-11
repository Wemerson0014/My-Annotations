package com.estudo.my_annotations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AnnotationPreferences annotationPreferences;
    private EditText edit_annotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAnnotation();
    }

    public void createAnnotation() {
        edit_annotation = findViewById(R.id.edit_annotation);
        annotationPreferences = new AnnotationPreferences(getApplicationContext());

        FloatingActionButton fab_add_annotations;
        fab_add_annotations = findViewById(R.id.fab_add_annotations);

        fab_add_annotations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit_annotation.getText().toString();
                if (text.equals("")) {
                    Snackbar.make(v, getString(R.string.snack_massage), Snackbar.LENGTH_LONG).show();
                } else {
                    annotationPreferences.saveAnnotation(text);
                    Snackbar.make(v, getString(R.string.snack_success), Snackbar.LENGTH_LONG).show();
                }
            }
        });

        String annotation = annotationPreferences.getAnnotation();
        if (!annotation.equals("")) {
            edit_annotation.setText(annotation);
        }
    }
}