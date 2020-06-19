package com.globomed.learn

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    /** Called when the database is created for the first time
     * Where creation of the tables and the initial population of the tables happen
     */
    override fun onCreate(p0: SQLiteDatabase?) {
        //Execute the SQL Query here
        p0?.execSQL(GloboMedDbContract.EmployeeEntry.SQL_CREATE_ENTRIES)
    }

    /** Called when the database need to be upgraded
     * May write the code to drop the table */
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        //To complete the database write the code here.
        p0?.execSQL(GloboMedDbContract.EmployeeEntry.SQL_DROP_TABLE)
        onCreate(p0)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    /**Called when we want to downgrade the table
     * If we do not override this method any downgrade calls will be rejected and SQL exceptions will be thrown */
    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    /**Is triggered after the SQl schema has been created, upgraded, downgraded as desired
     * Used to make any requests after the schema has been created upgraded or downgraded */
    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

    /**Defining constants to be used in the OpenHelper Class
     * Define in a companion object */
    companion object {
        const val DATABASE_NAME = "globomed.db"
        const val DATABASE_VERSION = 1
    }
}