package com.example.demokotlin.settle

import com.example.demokotlin.manager.Contextor
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

object SettleData {

    fun getJsonData(): ArrayList<SettleModel> {
        try {
            val file = Contextor.getInstance().context.assets.open("settle_data.json")
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()

            val myJson = String(buffer, Charset.forName("UTF-8"))

            return jsonStringToArray(myJson)

        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
        return arrayListOf()
    }

    @Throws(JSONException::class)
    private fun jsonStringToArray(jsonString: String): ArrayList<SettleModel> {
        val stringArray = ArrayList<String>()
        val jsonArray = JSONArray(jsonString)
        for (i in 0 until jsonArray.length()) {
            stringArray.add(jsonArray.getString(i))
        }
        val items = arrayListOf<SettleModel>()
        for (i in 0 until stringArray.size) {
            var rows = stringArray[i]
            rows = rows.replace("{", "", true)
            rows = rows.replace("}", "", true)
            val rowsList = rows.split(",")
            val resList = arrayListOf<String>()
            for (j in 0 until rowsList.size) {
                val array = rowsList[j].split(":")
                resList.add(array[1])
            }
            items.add(
                SettleModel(
                    resList[0].replace("\"", "")
                    , resList[1].replace("\"", "")
                    , resList[2].replace("\"", "")
                    , resList[3].replace("\"", "")
                    , resList[4].replace("\"", "")
                    , resList[5].replace("\"", "")
                    , resList[6].replace("\"", "")
                    , resList[7].replace("\"", "")
                    , resList[8].replace("\"", "")
                    , resList[9].replace("\"", "")
                    , resList[10].replace("\"", "")
                    , resList[11].toInt()
                    , resList[12] == "true"
                    , resList[13] == "true"
                    , resList[14].replace("\"", "")
                    , resList[15].replace("\"", "")
                    , resList[16].replace("\"", "")
                    , resList[17].toInt()
                    , resList[18].toInt()
                    , resList[19].toInt()
                    , resList[20].toInt()
                    , resList[21].toInt()
                    , resList[22].toInt()
                    , resList[23].toInt()
                    , resList[24].toInt()
                    , resList[25].toInt()
                    , resList[26].toInt()
                    , resList[27].toInt()
                    , resList[28].toInt()
                )
            )
        }
        return items
    }
}