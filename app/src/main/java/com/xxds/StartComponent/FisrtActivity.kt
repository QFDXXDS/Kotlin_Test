package com.xxds.StartComponent

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.xxds.kotlin_test.R
import com.xxds.kotlin_test.R.id.*

import kotlinx.android.synthetic.main.activity_fisrt.*

import kotlinx.android.synthetic.main.activity_fisrt.*
import kotlinx.android.synthetic.main.content_fisrt.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.net.URI

class FisrtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fisrt)
        setSupportActionBar(toolbar)

        println("currentThread is " + Thread.currentThread().name)

        val job = SupervisorJob()

        val scope = CoroutineScope(Dispatchers.Unconfined)

        scope.launch {

            println("scope launch currentThread is " + Thread.currentThread().name)
            delay(1000)
//            kotlinx.coroutines.DefaultExecutor

            delay(1000)
            println("delay currentThread is " + Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.Unconfined){


            println("first launch currentThread is " + Thread.currentThread().name)


//            delay(2000)

            fooo()
        }
        runBlocking(){

            println("runBlocking currentThread is " + Thread.currentThread().name)

            delay(1000)

//            delay(2000)

            println("delay runBlocking currentThread is " + Thread.currentThread().name)

        }



        GlobalScope.async(Dispatchers.Unconfined){

            println("async currentThread is " + Thread.currentThread().name)


            delay(2000)
            println("delay async currentThread is " + Thread.currentThread().name)

        }

        GlobalScope.async(){

            println("async1 currentThread is " + Thread.currentThread().name)

//            delay(2000)

        }





        println("second  currentThread is " + Thread.currentThread().name)




        runOnUiThread {

            println("Third  currentThread is " + Thread.currentThread().name)

        }
        GlobalScope.async(Dispatchers.Unconfined){

            println("Five currentThread is " + Thread.currentThread().name)

//            delay(2000)

        }

        println("four  currentThread is " + Thread.currentThread().name)

        foo()

        foo()


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        secondBt.setOnClickListener {

//            startActivity(Intent(this,SecondActivity::class.java))
//            startActivity(Intent(secondAc))

//            val intent = Intent(secondAc)
//            intent.addCategory("aaaaa")
//            startActivity(intent)


            var  intent = Intent()
            intent.action = Intent.ACTION_VIEW
//            intent.data = Uri.parse("content://contacts/people/")
//            intent.data = Uri.parse("tel:123")
            intent.data = Uri.parse("http://www.baidu.com/")

//            startActivity(intent)




            this::class.qualifiedName


            val a: Array<Any> = arrayOf(1,2,"234")  //Array类型
            val l = listOf(1,2,3,"2312")  //返回不可变列表,列表成员不能修改
            val m = mutableListOf<Int>(1,2,3)  //返回arraylist
//            l = {Arrays$ArrayList@5691}  size = 3   不可变
//            m = {ArrayList@5692}  size = 4   可变
            m.add(4)
            m[0] = 4
            a[0] =  4

//            l[1] = 4

            print(a)
            println(l)
        }



    }

    fun foo(){


        GlobalScope.async(){

            println("foo async1 currentThread is " + Thread.currentThread().name)

//            delay(2000)

        }
    }


    suspend fun fooo() {


        Thread.sleep(2000)
        println("fooo async1 currentThread is " + Thread.currentThread().name)


    }

    companion object {

        val secondAc = "second.ac"
    }



}
