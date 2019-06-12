package com.example.demokotlin.reader.manager

import com.example.demokotlin.reader.interfaces.ReaderInterface
import com.example.demokotlin.reader.manager.RabbitObject.readDataList
import com.example.demokotlin.reader.manager.RabbitObject.traceNumber
import com.example.demokotlin.reader.manager.RabbitObject.writeDataList
import com.example.demokotlin.reader.manager.RabbitObject.writeModel
import com.example.demokotlin.reader.model.BaseResponse
import com.example.demokotlin.reader.model.WriteModel

class ReaderManager(private val readerInterface: ReaderInterface) {

    fun setReaderData(data: WriteModel) {
        writeModel = data
    }

    fun setPayload(payload: MutableList<Byte>) {
        writeModel.txPayload = payload
    }

    fun setTraceNumber(termStan: Int) {
        var number = termStan + 1
        if (number == 0xFFFF) {
            number = 1
        }
        traceNumber = number
        writeModel.txSnPacket = mutableListOf((number and 0xff).toByte(), (number and 0xff00 shr 8).toByte())
    }

    fun setTxPacketList() {
        writeDataList.clear()
        writeDataList.addAll(writeModel.txStart)
        writeDataList.addAll(writeModel.txVersion)
        writeDataList.addAll(writeModel.txSessionId)
        writeDataList.add(writeModel.txMessageType)
        writeDataList.addAll(writeModel.txSnPacket)
        writeDataList.addAll(writeModel.txSnCurrent)
        writeDataList.addAll(writeModel.txSnTotal)
        writeDataList.addAll(writeModel.txCommandId)
        writeDataList.addAll(writeModel.txStatus)
        writeDataList.addAll(writeModel.txPayloadType)
        writeDataList.addAll(writeModel.txPayloadLen)
        writeDataList.addAll(writeModel.txPayload)
        writeDataList.addAll(writeModel.txCheckSum)
        writeDataList.addAll(writeModel.txStop)
    }

    fun sendGetACK(expectACK: Int) {
        if (openSerialPort) {
            if (expectACK == 0) {
                readerInterface.onReaderSuccess(BaseResponse(true, writeDataList, readDataList))
            } else {
                readerInterface.onReaderError(false)
            }
        }
        closeSerialPort
    }

    private val openSerialPort: Boolean
        get() = true

    private val closeSerialPort: Boolean
        get() = true
}