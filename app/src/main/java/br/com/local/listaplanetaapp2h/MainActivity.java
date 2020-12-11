package br.com.local.listaplanetaapp2h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar a variável que irá receber a ListView do XML
    ListView listView;
    //Criar os arrays que serão inseridos na listView

    String nomePlanetas[] = {"Eu sou o Homem de Ferro", "Homem de ferro Especial", "Homem de Ferro - Extremis",
            "Homem de Ferro - Rapto", "Homem de Ferro - A queda", "Homem de Ferro e o Thor nº39", "Homem de Ferro e o Thor nº40",
            "Homem de Ferro e o Thor nº41", "Homem de Ferro e o Thor nº42", "Homem de Ferro nº12", "Homem de Ferro nº13",
            "Homem de Ferro nº14", "Homem de Ferro nº3", "Homem de Ferro nº5", "Homem de Ferro nº5",
            "Homem de Ferro nº6", "Homem de Ferro nº7", "Homem de Ferro nº8", "Homem de Ferro nº9",
            "Homem de Ferro - O mais procurado do Mundo", "O invencivel Homem de Ferro - Síndrome de Frankenstein"};

    int imgPlanetas[] = {R.drawable.eu_sou_o_homem_de_Ferro, R.drawable.homem_de_ferro_Especial,
            R.drawable.homem_de_ferro_Extremis, R.drawable.homem_de_ferro_Rapto, R.drawable.homem_de_ferro_a_queda,
            R.drawable.homem_de_ferro_e_o_Thor_nº_39, R.drawable.homem_de_ferro_e_o_Thor_nº_40,
            R.drawable.homem_de_ferro_e_o_Thor_nº_41, R.drawable.homem_de_ferro_e_o_Thor_nº_42,
            R.drawable.homem_de_ferro_nº_12, R.drawable.homem_de_ferro_nº_13, R.drawable.homem_de_ferro_nº_14, R.drawable.homem_de_ferro_nº_3,
            R.drawable.homem_de_ferro_nº_5, R.drawable.homem_de_ferro_nº_6,
            R.drawable.homem_de_ferro_nº_7, R.drawable.homem_de_ferro_nº_8, R.drawable.homem_de_ferro_nº_9,
            R.drawable.homem_de_ferro_o_mais_procurado_do_mundo, R.drawable.o_invencivel_homem_de_ferro_síndrome_de_Frankenstein};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //a variavel listview está recebendo a listView XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter customAdapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter(customAdapter);

        //Criando evento de click na listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),VisualizaPlaneta_MainActivity.class);
                //Passando valores de uma janela para outra
                intent.putExtra("nomePlaneta",nomePlanetas[i]);
                intent.putExtra("imagemPlaneta",imgPlanetas[i]);

                startActivity(intent);

            }
        });


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgPlanetas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView txtNomePlaneta;
            ImageView imagemPlaneta;

            //instanciando o modelo com os componentes para inserir na Lista
            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_planetas, null);

            txtNomePlaneta = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemPlaneta = carregaView.findViewById(R.id.imgListaPlaneta);

            //Carregando os valores nos componentes

            txtNomePlaneta.setText(nomePlanetas[i]);
            imagemPlaneta.setImageResource(imgPlanetas[i]);

            return carregaView;
        }
    }
}