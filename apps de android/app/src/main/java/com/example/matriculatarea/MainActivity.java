package com.example.matriculatarea;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;
import java.util.HashMap;

import android.view.View;  // Agrega esta línea de importación
import android.widget.AdapterView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner_escuela;
    private Spinner spinner_carreras;
    private Spinner spinner_cuotas;
    private TextView costo_carrera_respuesta;
    private TextView pension_respuesta;
    private TextView gastos_adicionales_respuesta;
    private TextView total_pagar_respuesta;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Text Views
        costo_carrera_respuesta = (TextView) findViewById(R.id.textViewCostoCarrera);
        pension_respuesta = (TextView) findViewById(R.id.textViewPension);
        gastos_adicionales_respuesta = (TextView) findViewById(R.id.textViewGastosAdicionales);
        total_pagar_respuesta = (TextView) findViewById(R.id.textViewTotal);

        //Spinner
        spinner_escuela = (Spinner) findViewById(R.id.spinnerEscuela);
        spinner_carreras = (Spinner) findViewById(R.id.spinnerCarrera);
        spinner_cuotas = (Spinner) findViewById(R.id.spinnerCuotas);

        String[] EscuelasSpinner = {"FIA", "FACHED", "EDUCA"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, EscuelasSpinner);
        spinner_escuela.setAdapter(adapter);



        spinner_escuela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedEscuela = EscuelasSpinner[position];

                int carrerasArrayId = getResources().getIdentifier("carreras_" + selectedEscuela.toLowerCase(), "array", getPackageName());
                String[] carrerasArray = getResources().getStringArray(carrerasArrayId);

                ArrayAdapter<String> adapterCarrera = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, carrerasArray);
                spinner_carreras.setAdapter(adapterCarrera); // Cambio aquí: usar spinner_carreras en lugar de spinnerCarrera
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acciones a realizar cuando no se selecciona nada en el Spinner de escuela
            }
    });






        String [] CuotasSpinner = {"4","5","6"};
        ArrayAdapter <String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,CuotasSpinner);
        spinner_cuotas.setAdapter(adapter1);

    }
}
