package com.stefane.atmconsultoria.ui.about;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stefane.atmconsultoria.R;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Element version = new Element();
        version.setTitle("Versão 1.0");

        String descricao = "A ATM Consultoria tem como missão apoiar organizações que desejam alcançar o sucesso através da excelência em gestão e da busca pela qualidade.";

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://www.google.com/", "Acesse nosso site")
                .addGroup("Redes Sociais")
                .addFacebook("stefane.crisoli", "Facebook")
                .addInstagram("stefane_cris", "Instagram")
                .addTwitter("stefane_cris_", "Twitter")
                .addYoutube("stefanecristina", "YouTube")
                .addGitHub("stefanecristina", "GitHub")
                .addPlayStore("com.facebook.katana", "Download App")
                .addItem(version)
                .create();

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_about, container, false);

    }

}
