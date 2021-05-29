package com.example.santanderdevweek.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log
import android.view.Menu;
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //definindo para que a toolbar seja exibida
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        buscarContaCliente()

    }

    private fun buscarContaCliente(){

        mainViewModel.busdarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })

    }

    private fun bindOnView(result : Conta){

        findViewById<TextView>(R.id.tv_usuario).text = result.cliente.nome
        findViewById<TextView>(R.id.tv_agencia).text = result.agencia
        findViewById<TextView>(R.id.tv_conta_corrente).text = result.numero
        findViewById<TextView>(R.id.tv_saldo).text = result.saldo
        findViewById<TextView>(R.id.tv_limite_disponivel).text = result.limite
        findViewById<TextView>(R.id.tv_final_value).text = result.cartao.numeroCartao

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
            }else -> super.onOptionsItemSelected(item)
        }
    }
}