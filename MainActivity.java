package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.wordpress.vamosconversar2018.vamosconversar.R;
import com.wordpress.vamosconversar2018.vamosconversar.TelaLogin;
import com.wordpress.vamosconversar2018.vamosconversar.TelaPrincipal;

public class MainActivity extends AppCompatActivity {


          public void IrParaTela2(View view){
              Intent intent1= new Intent(getApplicationContext(),TelaLogin.class);
              startActivity(intent1);

      };


    }





