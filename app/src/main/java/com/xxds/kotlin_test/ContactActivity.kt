package com.xxds.kotlin_test

import android.content.ContentResolver
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_contact.*
import java.util.jar.Manifest

class ContactActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        if (checkSelfPermission(android.Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED) {

            requestPermission()
        }

//        if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
////
//            requestPermission()
//        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_contact, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0x123 && grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            getContact()

        }
    }

    fun requestPermission() {

        requestPermissions(permissons,0x123)
    }
    fun getContact(){

//   access your contacts
        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null)
        while (cursor.moveToNext()) {

            val  contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
            val  name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))


            println(contactId)
        }

    }

    companion object {

        val permissons = arrayOf(
//            android.Manifest.permission.READ_CONTACTS
            android.Manifest.permission.WRITE_CONTACTS

        )

    }
}
