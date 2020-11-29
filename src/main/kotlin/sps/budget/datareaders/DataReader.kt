package sps.budget.datareaders

import sps.budget.Staff

/** Reads data source and returns list of data */
interface DataReader<T> {
    fun readData(): List<T>

}