package com.example.skypals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class   HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val landBirdsButton: Button = view.findViewById(R.id.landBirdsButton)
        val waterBirdsButton: Button = view.findViewById(R.id.waterBirdsButton)
        val skyBirdsButton: Button = view.findViewById(R.id.skyBirdsButton)
        val forestBirdsButton: Button = view.findViewById(R.id.forestBirdsButton)
        val desertBirdsButton: Button = view.findViewById(R.id.desertBirdsButton)

        landBirdsButton.setOnClickListener {
            showBirdGroupInfo("Land Birds", "Examples of land birds:\n1. Sparrow\n2. Robin\n3. Eagle\n4. Pigeon\n5. Blue Jay\n6. Cardinal\n7. Finch\n8. Wren\n9. Starling\n10. Magpie")
        }

        waterBirdsButton.setOnClickListener {
            showBirdGroupInfo("Water Birds", "Examples of water birds:\n1. Duck\n2. Swan\n3. Pelican\n4. Heron\n5. Flamingo\n6. Kingfisher\n7. Cormorant\n8. Gannet\n9. Grebe\n10. Osprey")
        }

        skyBirdsButton.setOnClickListener {
            showBirdGroupInfo("Sky Birds", "Examples of sky birds:\n1. Hawk\n2. Seagull\n3. Albatross\n4. Falcon\n5. Kite\n6. Harrier\n7. Swift\n8. Vulture\n9. Buzzard\n10. Condor")
        }

        forestBirdsButton.setOnClickListener {
            showBirdGroupInfo("Forest Birds", "Examples of forest birds:\n1. Nightingale\n2. Woodpecker\n3. Owl\n4. Blue Tit\n5. Cuckoo\n6. Thrush\n7. Warbler\n8. Nuthatch\n9. Jay\n10. Blackbird")
        }

        desertBirdsButton.setOnClickListener {
            showBirdGroupInfo("Desert Birds", "Examples of desert birds:\n1. Roadrunner\n2. Lark\n3. Sandgrouse\n4. Desert Sparrow\n5. Egyptian Vulture\n6. Desert Wheatear\n7. Sand Martin\n8. Hoopoe\n9. Desert Finch\n10. Barbary Falcon")
        }


        return view
    }

    private fun showBirdGroupInfo(groupName: String, groupInfo: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(groupName)
        builder.setMessage(groupInfo)
        builder.setPositiveButton("Close") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}