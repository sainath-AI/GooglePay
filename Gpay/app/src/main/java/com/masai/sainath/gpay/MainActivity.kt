package com.masai.sainath.gpay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.masai.sainath.gpay.adapter_class.MyAdapter
import com.masai.sainath.gpay.adapter_class.NewAdapter
import com.masai.sainath.gpay.adapter_class.userAdapter
import com.masai.sainath.gpay.model_class.Model
import com.masai.sainath.gpay.model_class.Newmodel
import com.masai.sainath.gpay.model_class.usermodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),OnClickListener {

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


        ivProfile.setOnClickListener {
            val intent = Intent(this,Profile::class.java)
            startActivity(intent)
        }


        tvScan.setOnClickListener {
            val intent= Intent(applicationContext,Scanner::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        getdata()
        getdata1()
        getdata2()
    }

    private fun getdata2() {
        uselist= arrayListOf<usermodel>()
        recycler3=findViewById(R.id.recycle3)
        recycler3.layoutManager=GridLayoutManager(this,4)
        recycler3.setHasFixedSize(false)
        dref2=FirebaseDatabase.getInstance().getReference("data3")
        dref2.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user2=usersnapshot.getValue(usermodel::class.java)
                        uselist.add(user2!!)
                    }
                    recycler3.adapter= userAdapter(this@MainActivity,uselist)
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
        dref1=FirebaseDatabase.getInstance().getReference("main_database/Business_and_bills")
        dref1.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user1=usersnapshot.getValue(Newmodel::class.java)
                        userlist.add(user1!!)

                    }
                    recycler2.adapter= NewAdapter(this@MainActivity,userlist)
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
        dref=FirebaseDatabase.getInstance().getReference("main_database/Peoples")
        dref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user=usersnapshot.getValue(Model::class.java)
                        datalist.add(user!!)
                    }


                    recycler1.adapter= MyAdapter(this@MainActivity,datalist,this@MainActivity)

                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        }

    override fun onClick(position: Int, model: Model) {
        val intent = Intent(applicationContext,ChatActivity::class.java)
        intent.putExtra("name",model.naam1)
        intent.putExtra("image",model.Image)
        startActivity(intent)
    }

}





