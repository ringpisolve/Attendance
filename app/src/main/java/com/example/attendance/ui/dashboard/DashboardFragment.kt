package com.example.attendance.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.attendance.R
import com.google.firebase.firestore.FirebaseFirestore

class DashboardFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_dashboard, container, false)
        val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        val class_s=view.findViewById<Spinner>(R.id.spinner_class)

        val sec_s=view.findViewById<Spinner>(R.id.section)
        val abse=view.findViewById<EditText>(R.id.absentees)
        val submit=view.findViewById<Button>(R.id.button)

        submit?.setOnClickListener {
           val sss= class_s.selectedItem.toString()
            val sss1= sec_s.selectedItem.toString()
            val absmap= HashMap<String,Any>()
            absmap.put("absent",abse.text.toString())
             absmap.put("class",sss)
            absmap.put("section",sss1)

            mFirestore.collection("Attendance").add(absmap).addOnSuccessListener {
                Toast.makeText(view.context, "Attendance Submitted", Toast.LENGTH_LONG).show()

            }.addOnFailureListener {
                Toast.makeText(view.context, "error while sending", Toast.LENGTH_LONG).show()
            }

        }
        return view
        return root
        }

    }

