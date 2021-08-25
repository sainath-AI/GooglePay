package com.masai.sainath.gpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class MainActivity : AppCompatActivity() {

    private lateinit var dref:DatabaseReference
    private lateinit var recycler1: RecyclerView
    private lateinit var datalist:ArrayList<Model>

    private lateinit var dref1:DatabaseReference
    private lateinit var recycler2: RecyclerView
    private lateinit var userlist:ArrayList<Newmodel>

    private lateinit var dref2:DatabaseReference
    private lateinit var recycler3: RecyclerView
    private lateinit var uselist:ArrayList<usermodel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdata()
        getdata1()
        getdata2()
    }

    private fun getdata2() {
        uselist= arrayListOf<usermodel>()
        recycler3=findViewById(R.id.recycle3)
        recycler3.layoutManager=GridLayoutManager(this,4)
        recycler3.setHasFixedSize(true)
        dref2=FirebaseDatabase.getInstance().getReference("data3")
        dref2.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user2=usersnapshot.getValue(usermodel::class.java)
                        uselist.add(user2!!)
                    }
                    recycler3.adapter=userAdapter(this@MainActivity,uselist)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun getdata1() {
        userlist= arrayListOf<Newmodel>()
        recycler2=findViewById(R.id.recycle2)
        recycler2.layoutManager=GridLayoutManager(this,4)
        recycler2.setHasFixedSize(true)
        dref1=FirebaseDatabase.getInstance().getReference("data2")
        dref1.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user1=usersnapshot.getValue(Newmodel::class.java)
                        userlist.add(user1!!)
                    }
                    recycler2.adapter=NewAdapter(this@MainActivity,userlist)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun getdata() {
        datalist= arrayListOf<Model>()
        recycler1=findViewById(R.id.recycle1)
        recycler1.layoutManager=GridLayoutManager(this,4)
        recycler1.setHasFixedSize(true)
        dref=FirebaseDatabase.getInstance().getReference("data")
        dref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user=usersnapshot.getValue(Model::class.java)
                        datalist.add(user!!)
                    }
                    recycler1.adapter=MyAdapter(this@MainActivity,datalist)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}