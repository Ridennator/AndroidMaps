package com.ridennator.androidmaps

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.infowindow.InfoWindow
import org.w3c.dom.Text

class MarkerWindow:InfoWindow {
    private var parent:MainActivity
    private var text:String

    constructor(mapView: MapView, parent:MainActivity, text: String):super(R.layout.info_window,mapView)
    {
        this.parent=parent
        this.text=text
    }

    override fun onOpen(item: Any?) {
        closeAllInfoWindowsOn(mapView)
        val myHelloButton = mView.findViewById<Button>(R.id.HelloBt)
        val myTextView = mView.findViewById<TextView>(R.id.textView)

        myTextView.text = text

        myHelloButton.setOnClickListener{
            Toast.makeText(parent,"Hello $text", Toast.LENGTH_SHORT ).show()
        }
        mView.setOnClickListener{
            close()
        }
    }

    override fun onClose() {
        TODO("Not yet implemented")
    }

}