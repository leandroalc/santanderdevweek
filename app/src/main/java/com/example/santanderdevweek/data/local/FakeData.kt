package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {

    fun getLocalData() : Conta {

        val cliente = Cliente("Leandro")

        val cartao = Cartao("411111111111")

        return Conta("445655-4",
                "6552-4",
                "R$ 2.450,60",
                "R$ 4.120,00",
                cliente,
                cartao)

    }

}