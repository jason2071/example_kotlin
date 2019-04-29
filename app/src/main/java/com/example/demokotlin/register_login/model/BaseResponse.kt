package com.example.demokotlin.register_login.model

import android.os.Parcel
import android.os.Parcelable

data class BaseResponse(
    val message: String?,
    val results: Results?,
    val status: Boolean
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readParcelable<Results>(Results::class.java.classLoader),
        1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(message)
        writeParcelable(results, 0)
        writeInt((if (status) 1 else 0))
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<BaseResponse> = object : Parcelable.Creator<BaseResponse> {
            override fun createFromParcel(source: Parcel): BaseResponse =
                BaseResponse(source)
            override fun newArray(size: Int): Array<BaseResponse?> = arrayOfNulls(size)
        }
    }
}

data class Results(
    val email: String?,
    val id: Int,
    val name: String?,
    val system: String?,
    val user_hash: String?
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(email)
        writeInt(id)
        writeString(name)
        writeString(system)
        writeString(user_hash)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Results> = object : Parcelable.Creator<Results> {
            override fun createFromParcel(source: Parcel): Results =
                Results(source)
            override fun newArray(size: Int): Array<Results?> = arrayOfNulls(size)
        }
    }
}