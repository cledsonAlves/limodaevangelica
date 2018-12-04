package br.com.limodaevangelica

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import br.com.limodaevangelica.activity.BaseActivity
import br.com.limodaevangelica.adapter.ProdutoAdapter
import br.com.limodaevangelica.domain.ProdutoService
import br.com.limodaevangelica.extensions.toast
import br.com.limodaevangelica.model.Produto
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : BaseActivity() {
    private var produtos = listOf<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // recyclerview
        recylerView.layoutManager = LinearLayoutManager(context)
        recylerView.itemAnimator = DefaultItemAnimator()
        recylerView.setHasFixedSize(true)


    }

    override fun onResume() {
        super.onResume()
        taskProduto()
    }

    private fun taskProduto() {
        //busca os produtos
        this.produtos = ProdutoService.getProdutos(context)
        recylerView.adapter = ProdutoAdapter(produtos,
            { produto: Produto ->
                toast("@clicou no produto ${produto.descricao}")
            })
    }

}
