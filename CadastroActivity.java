package Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wordpress.vamosconversar2018.vamosconversar.R;
import com.wordpress.vamosconversar2018.vamosconversar.TelaLogin;

public class CadastroActivity extends AppCompatActivity {
    private Button btnabriractivitycadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        btnabriractivitycadastro = (Button)findViewById(R.id.btnenviarcadastro);

        btnabriractivitycadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentenviardadoscadastro = new Intent(CadastroActivity.this, TelaLogin.class);
                startActivity(intentenviardadoscadastro);
            }
        });
    }
}