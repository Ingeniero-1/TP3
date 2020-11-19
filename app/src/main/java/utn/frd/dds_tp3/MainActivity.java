package utn.frd.dds_tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnEjecutar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MiAsyncTask().execute();
            }
        });

    }           //No aparece el Toast ni ningun boton (Solo en linea 34/5)

    private class MiAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {                // ...?
            return RESTService.makeGetRequest(
                    "https://jsonplaceholder.typicode.com/posts/1"); //Usa con MI servicio REST
        }                    //reemplazar localhost con mi IP               // IP1: 181.4xx.xxx.xx (Desde ipconfig en cmd)
                                                                            // IP2: 192.xxx.x.xxx (desde pagina web que me dice mi ip)
        @Override
        protected void onPostExecute(String result) {
            Toast notificacion = Toast.makeText(
                    getApplicationContext(), result, Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}
