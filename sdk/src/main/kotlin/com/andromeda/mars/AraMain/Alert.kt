package com.andromeda.mars.AraMain


import java.net.URI
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.ResultSet
import java.lang.reflect.Array.setDouble
import java.sql.PreparedStatement







class Alert {
    var conn: Connection? = null
    val ANDROID_DEVICE = 1
    protected var Mainuri:URI = URI.create("")
    val DESKTOP_DEVICE = 2
    val SERVER_DEVICE = 3
    fun connect(mode:Int): Connection? {
        if (mode == ANDROID_DEVICE){
            val url = "content://AraNotification/not"
            // create a connection to the database
            conn = DriverManager.getConnection(url)





        }
        return conn

    }
    fun Alert(type:Int, title: String, info: String, image: String,link: String, bubble: Boolean) {
        val sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?,?)"

        try {
            this.connect(type).use { conn ->
                conn?.prepareStatement(sql).use { pstmt ->
                    pstmt?.setString(1, title)
                    pstmt?.setString(2, info)
                    pstmt?.setString(3, image)
                    pstmt?.executeUpdate()
                }
            }
        } catch (e: SQLException) {
            println(e.message)
        }

    }

    }

