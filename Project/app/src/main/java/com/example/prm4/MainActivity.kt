package com.example.prm4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prm4.fragments.EditFragment
import com.example.prm4.fragments.InfoFragment
import com.example.prm4.fragments.ListFragment

class MainActivity : AppCompatActivity(), Navigable {
    private lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actyvity_main)

        listFragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, listFragment, listFragment.javaClass.name)
            .commit()
    }

    override fun navigate(to: Navigable.Destination) {
        supportFragmentManager.beginTransaction().apply {
            when (to) {
                Navigable.Destination.List -> replace(R.id.container, listFragment, listFragment.javaClass.name)
                Navigable.Destination.Add -> {
                    replace(R.id.container, EditFragment(), EditFragment::class.java.name)
                    addToBackStack(EditFragment::class.java.name)
                }
                Navigable.Destination.Edit -> {
                    replace(R.id.container, EditFragment(), EditFragment::class.java.name)
                    addToBackStack(EditFragment::class.java.name)
                }
                Navigable.Destination.Info -> {
                    replace(R.id.container, InfoFragment(), InfoFragment::class.java.name)
                    addToBackStack(EditFragment::class.java.name)
                }

            }
        }.commit()
    }

}

