package com.digitalskies.themic.ui.extract_instrumentals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.digitalskies.themic.databinding.FragmentExtractInstrumentalsBinding

class ExtractedSongFragment :Fragment() {


    lateinit var binding: FragmentExtractInstrumentalsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentExtractInstrumentalsBinding.inflate(layoutInflater,container,false)
        val view=binding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}