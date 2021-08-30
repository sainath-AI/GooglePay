package com.masai.sainath.gpay.TrasactionHistory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.masai.sainath.gpay.R
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity(),clicklisten {

    private  var tranlist:ArrayList<TransationModel> = ArrayList()
    private lateinit var databaseReferenc:DatabaseReference

    private lateinit var transationAdapter:TransationAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)
        tranlist= arrayListOf<TransationModel>()
        setTransation()
        buildlist()
    }

    private fun buildlist() {

        tranlist.clear()
        var reverseList:ArrayList<TransationModel> = ArrayList()
        databaseReferenc = FirebaseDatabase.getInstance().getReference("Transactions")
        databaseReferenc.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                reverseList.clear()
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user2=usersnapshot.getValue(TransationModel::class.java)
                        reverseList.add(user2!!)
                    }
                    tranlist= ArrayList(reverseList.reversed())
                    historyrecycle.adapter= TransationAdapter(tranlist,this@TransactionActivity)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    fun setTransation(){
//        val transationAdapter=TransationAdapter(this,tranlist,this)
        val layoutManager=LinearLayoutManager(this)
//        historyrecycle.adapter=transationAdapter
        historyrecycle.layoutManager=layoutManager
    }

    override fun onClicked(position: Int, model: TransationModel) {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.transation_menu,menu)
        return true
    }
}