package com.digitalskies.themic.ui.home


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.digitalskies.themic.databinding.FragmentHomeBinding
import com.digitalskies.themic.toast

class HomeFragment:Fragment() {

    lateinit var binding: FragmentHomeBinding

    private lateinit var openFile:ActivityResultLauncher<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)
        val view=binding.root


        openFile=registerForActivityResult(ActivityResultContracts.GetContent()){

        }



        val requestPermissionLauncher=registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->


            for(entry in map){

                if(entry.key==Manifest.permission.READ_EXTERNAL_STORAGE||entry.key==Manifest.permission.WRITE_EXTERNAL_STORAGE){
                    if(!entry.value){
                        toast("Storage permissions required")
                        return@registerForActivityResult
                    }
                }
            }

            openFile()



        }



        binding.btnBegin.setOnClickListener {

            when{
                ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE)
                        ==PackageManager.PERMISSION_GRANTED
                        &&ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        ==PackageManager.PERMISSION_GRANTED-> {openFile()}

                ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE)
                        !=PackageManager.PERMISSION_GRANTED
                        ||ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        !=PackageManager.PERMISSION_GRANTED-> requestPermissionLauncher.launch(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE))



            }




        }


        return view
    }

    private fun openFile(){


        openFile.launch("audio/*")
    }


}