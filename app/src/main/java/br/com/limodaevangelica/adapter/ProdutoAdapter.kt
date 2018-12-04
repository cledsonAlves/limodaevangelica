package br.com.limodaevangelica.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.limodaevangelica.R
import br.com.limodaevangelica.model.Produto
import kotlinx.android.synthetic.main.adapter_produto.view.*


class ProdutoAdapter(

    val produto: List<Produto>,
    val onClick: (Produto) -> Unit
) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

    // viewHolder com as views
    class ProdutosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // views do layout
        var tcodigo = view.findViewById<TextView>(R.id.codigo)
        var tdescricao = view.findViewById<TextView>(R.id.descricao)
        var tpreco = view.findViewById<TextView>(R.id.preco)
        var cardView = view.findViewById<View>(R.id.card_view)

    }

    override fun getItemCount() = this.produto.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)
        val holder = ProdutosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produto = produto[position]
        val view = holder.itemView

         holder.tcodigo.text = ""
         holder.tdescricao.text = produto.descricao
         holder.tpreco.text =  Integer.toString(produto.codigo)



        holder.itemView.setOnClickListener { onClick(produto) }
    }

}



