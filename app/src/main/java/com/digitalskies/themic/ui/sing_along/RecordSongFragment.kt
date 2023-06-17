package com.digitalskies.themic.ui.sing_along

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.digitalskies.themic.databinding.FragmentRecordSongBinding

class RecordSongFragment:Fragment() {

    lateinit var binding: FragmentRecordSongBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentRecordSongBinding.inflate(layoutInflater,container,false)
        val view=binding.root


        return view
    }
}