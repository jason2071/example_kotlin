package com.example.demokotlin.register_login.model

import android.os.Parcel
import android.os.Parcelable

data class AllMember(
    val results: ArrayList<Results>?,
    val status: Boolean
) : Parcelable {
    constructor(source: Parcel) : this(
        source.createTypedArrayList(Results.CREATOR),
        1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(results)
        writeInt((if (status) 1 else 0))
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<AllMember> = object : Parcelable.Creator<AllMember> {
            override fun createFromParcel(source: Parcel): AllMember = AllMember(source)
            override fun newArray(size: Int): Array<AllMember?> = arrayOfNulls(size)
        }
    }
}