package com.example.demokotlin.reader

import com.example.demokotlin.reader.interfaces.ReaderInterface
import com.example.demokotlin.reader.interfaces.ResponseInterface
import com.example.demokotlin.reader.manager.RabbitObject.traceNumber
import com.example.demokotlin.reader.manager.ReaderManager
import com.example.demokotlin.reader.model.BaseResponse
import com.example.demokotlin.reader.model.WriteModel

class ReaderCancel(private val responseInterface: ResponseInterface) : ReaderInterface {

    private var readerInterface: ReaderInterface = this
    private lateinit var readerManager: ReaderManager

    private val payload = byteArrayOf(0x01, 0x00, 0x04, 0x00)

    fun cancel() {
        readerManager = ReaderManager(readerInterface)
        readerManager.setReaderData(
            WriteModel(
                txVersion = mutableListOf(0x01, 0)
                , txSessionId = mutableListOf(0x01, 0, 0, 0)
                , txSnPacket = mutableListOf(0x01, 0)
                , txSnCurrent = mutableListOf(0x01, 0)
                , txSnTotal = mutableListOf(0x01, 0)
                , txCommandId = mutableListOf(0xAA.toByte(), 0)
                , txPayloadType = mutableListOf(payload[0], payload[1])
                , txPayloadLen = mutableListOf(payload[2], payload[3])
            )
        )
        readerManager.setTraceNumber(traceNumber)
        readerManager.setPayload(mutableListOf(0x00, 0x01, 0x00, 0x00))
        readerManager.setTxPacketList()
        readerManager.sendGetACK(0x00)
    }

    override fun onReaderSuccess(response: BaseResponse) {
        responseInterface.onResponseSuccess(response)
    }

    override fun onReaderError(status: Boolean) {

    }
}