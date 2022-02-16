package com.gts.assignment.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.*
import com.gts.assignment.base.BaseViewModel
import com.gts.assignment.utils.StringUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val stringUtils: StringUtils) : BaseViewModel() {

    val enMsg = MutableLiveData<String>()
    val arMsg = MutableLiveData<String>()
    val isShowBanner = MutableLiveData<Boolean>()


    fun getFirebaseData() {

        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Banner")

        databaseReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    enMsg.value = snapshot.child("en_text").value as String?
                    arMsg.value = snapshot.child("ar_text").value as String?
                    isShowBanner.value = snapshot.child("isSet").value.toString().toBoolean()
                } else {
                    enMsg.value = stringUtils.message()
                    arMsg.value = stringUtils.message()
                    isShowBanner.value = false
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }


        })
    }
}