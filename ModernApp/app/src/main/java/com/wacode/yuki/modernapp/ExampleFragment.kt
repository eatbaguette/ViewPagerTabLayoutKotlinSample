package com.wacode.yuki.modernapp

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * Created by yuki on 2016/09/28.
 */

class ExampleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, null)
        val linearLayout = view.findViewById(R.id.fragment_main_linearlayout) as LinearLayout
        linearLayout.setBackgroundResource(arguments.getInt(BACKGROUND_COLOR))

        return view
    }

    companion object {
        private val BACKGROUND_COLOR = "background_color"

        fun newInstance(@ColorRes IdRes: Int): ExampleFragment {
            val frag = ExampleFragment()
            val b = Bundle()
            b.putInt(BACKGROUND_COLOR, IdRes)
            frag.arguments = b
            return frag
        }
    }
}
