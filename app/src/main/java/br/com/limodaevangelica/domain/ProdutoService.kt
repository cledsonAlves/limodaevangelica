package br.com.limodaevangelica.domain

import android.content.Context
import br.com.limodaevangelica.model.Produto

class ProdutoService{
    companion  object{
        fun getProdutos(context: Context): List<Produto>{
            val produtos = mutableListOf<Produto>()
            //
            for (i in 1..20){
                val p = Produto()
                p.descricao = "Produto S${i}"
                p.preco = 0.45
                produtos.add(p)
            }
            return produtos
        }
    }
}