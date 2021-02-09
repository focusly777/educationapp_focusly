package io.focusly.focuslyeduteacher.util

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import io.focusly.focuslyedu.data.remote.source.UserData
import io.focusly.focuslyeduteacher.App.Companion.dLog


class AuthCheck(
    var callback: (FirebaseUser?) -> Unit
) {
    private val db:DatabaseReference = Firebase.database.reference
    private val mUser = FirebaseAuth.getInstance().currentUser

    fun check() {
        if (mUser == null) {
            dLog.e("user null")
            callback(null)
        } else if (mUser.uid.isBlank()) {
            dLog.e("user uid null or blank")
            callback(null)
        } else {
            dLog.e("uid : ${mUser.uid}")
            db.child("USER").child(mUser.uid).addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        dLog.e("DocumentSnapshot exist: ${snapshot.getValue(UserData::class.java)}")
                        callback(mUser)
                    } else {
                        dLog.e("No such document")
                        callback(null)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

}