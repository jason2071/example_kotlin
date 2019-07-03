package com.example.demokotlin.settle

import android.os.Parcel
import android.os.Parcelable

data class SettleModel(
    val address1: String?,
    val address2: String?,
    val address3: String?,
    val address4: String?,
    val address5: String?,
    val batchNumber: String?,
    val cardSchemeName: String?,
    val cardSchemeTableId: String?,
    val hostName: String?,
    val hostTableId: String?,
    val hostType: String?,
    val id: Int,
    val isCountFlag: Boolean,
    val isLastBatch: Boolean,
    val merchantId: String?,
    val merchantTableId: String?,
    val terminalId: String?,
    val totalForeignAmount: Int,
    val totalForeignCount: Int,
    val totalForeignRefundAmount: Int,
    val totalForeignRefundCount: Int,
    val totalForeignTipAmount: Int,
    val totalForeignTipCount: Int,
    val totalRefundAmount: Int,
    val totalRefundCount: Int,
    val totalSaleAmount: Int,
    val totalSaleCount: Int,
    val totalTipAmount: Int,
    val totalTipCount: Int
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        1 == source.readInt(),
        1 == source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(address1)
        writeString(address2)
        writeString(address3)
        writeString(address4)
        writeString(address5)
        writeString(batchNumber)
        writeString(cardSchemeName)
        writeString(cardSchemeTableId)
        writeString(hostName)
        writeString(hostTableId)
        writeString(hostType)
        writeInt(id)
        writeInt((if (isCountFlag) 1 else 0))
        writeInt((if (isLastBatch) 1 else 0))
        writeString(merchantId)
        writeString(merchantTableId)
        writeString(terminalId)
        writeInt(totalForeignAmount)
        writeInt(totalForeignCount)
        writeInt(totalForeignRefundAmount)
        writeInt(totalForeignRefundCount)
        writeInt(totalForeignTipAmount)
        writeInt(totalForeignTipCount)
        writeInt(totalRefundAmount)
        writeInt(totalRefundCount)
        writeInt(totalSaleAmount)
        writeInt(totalSaleCount)
        writeInt(totalTipAmount)
        writeInt(totalTipCount)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SettleModel> = object : Parcelable.Creator<SettleModel> {
            override fun createFromParcel(source: Parcel): SettleModel = SettleModel(source)
            override fun newArray(size: Int): Array<SettleModel?> = arrayOfNulls(size)
        }
    }
}