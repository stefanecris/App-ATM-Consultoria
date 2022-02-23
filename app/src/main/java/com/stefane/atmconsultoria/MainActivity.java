package com.stefane.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.stefane.atmconsultoria.R;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_services, R.id.nav_clients, R.id.nav_contacts, R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    public void enviarEmail(){
        // Abre o aplicativo de ligações no Android e já exibe o número passado como parâmetro. Para de fato fazer a ligação, basta o usuário pressionar o botão.
        // Já o ACTION_CALL já abre a tela do aplicativo ligando. Como se o usuário já tivesse pressionado o botão.
        String celular = "tel:35954494777";
        String imagem = "https://store-images.s-microsoft.com/image/apps.51232.14176082463109974.f84fc39e-bc64-44f3-9851-edbbe1a9d810.d3b66324-8c44-4ac1-8df3-fc47485eb9f0?mode=scale&q=90&h=1080&w=1920";
        String endereco = "https://www.google.com.br/maps/place/R.+Vespasiano,+526+-+COHAB+II,+Passos+-+MG,+37903-200/@-20.7150489,-46.6321282,17z/data=!3m1!4b1!4m5!3m4!1s0x94b6c3a0d00a0ea9:0xb919371d96055c96!8m2!3d-20.7150539!4d-46.6299395?hl=pt-BR";
        // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        // Abre a imagem do link no broswer
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem Automática");

        intent.setType("message/rfc822");
        // intent.setType("text/plain");
        // intent.setType("image/*");
        // intent.setType("application/pdf");

        startActivity(Intent.createChooser(intent, "Compartilhar"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
