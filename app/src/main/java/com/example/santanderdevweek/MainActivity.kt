package com.example.santanderdevweek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log
import android.view.Menu;
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //definindo para que a toolbar seja exibida
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    //metodo para interacao com o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //variavel para importacao da caracteristica menuInflater
        val inflate = menuInflater

        //inflando o menu e chamando o pelo parametro da funcao
        inflate.inflate(R.menu.main_menu, menu)

        //retornando true para que o menu seja visualizado
        return true
    }

    //interagindo com os itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.option_1 -> {
                Log.d("Tap", "Opção 1 selecionada!")
                true
            }
            R.id.option_2 -> {
                Log.d("Tap", "Opção 2 selecionada!")
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }
}