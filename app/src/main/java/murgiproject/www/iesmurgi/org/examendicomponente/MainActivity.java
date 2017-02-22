package murgiproject.www.iesmurgi.org.examendicomponente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int porciento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Porcentaje porcentaje = new Porcentaje(this);
        porcentaje.setPorcentaje(75);







    }




}
