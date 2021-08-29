package com.masai.sainath.gpay.TrasactionHistory

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.sainath.gpay.R
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity(),clicklisten {

    private lateinit var tranlist:ArrayList<TransationModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)
        tranlist= arrayListOf<TransationModel>()
        setTransation()
    }
    fun setTransation(){
        val transationAdapter=TransationAdapter(this,tranlist,this)
        val layoutManager=LinearLayoutManager(this)
        historyrecycle.adapter=transationAdapter
        historyrecycle.layoutManager=layoutManager
    }

    override fun onClicked(position: Int, model: TransationModel) {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.transation_menu,menu)
        return true
    }
}