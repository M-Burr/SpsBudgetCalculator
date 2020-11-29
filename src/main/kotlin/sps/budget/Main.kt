package sps.budget

import com.healthmarketscience.jackcess.DatabaseBuilder
import it.skrape.core.htmlDocument
import it.skrape.selects.html5.table
import it.skrape.selects.html5.td
import it.skrape.selects.html5.tr
import org.apache.poi.ss.usermodel.WorkbookFactory
import sps.budget.datareaders.SchoolNCESHTMLReader
import sps.budget.datareaders.StaffSalaryXlsxReader
import java.io.File

object Main {

}


fun main(args: Array<String>) {
    //println(Main.readFormatXLSX("Washington_State_School_Personnel_-_School_Year_2019-2020.xlsx"))
    //println(Main.readFormatHTML("ncesdata_C6F81ECB.html").joinToString("\n"))
    //println(Main.readAccessDB("2019-2020_Preliminary_S-275_Personnel_Database.accdb"))
    var schoolList = SchoolNCESHTMLReader("ncesdata_C6F81ECB.html").readData()
    schoolList.take(4).forEach {
        println("schoolName: ${it.name}, building: ${it.buildingNum}, title one: ${it.titleOneStatus}, teacher: ${it.teacherCount}, student: ${it.studentCount}, free: ${it.freeLunch}, reduced: ${it.reducedLunch}")
    }
}