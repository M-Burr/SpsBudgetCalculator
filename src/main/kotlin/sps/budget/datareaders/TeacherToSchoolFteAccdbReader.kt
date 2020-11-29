package sps.budget.datareaders

import com.healthmarketscience.jackcess.DatabaseBuilder
import sps.budget.Staff
import java.io.File

// teacher --> school based on FTE
class TeacherToSchoolFteAccdbReader(private val resourcePath: String) : DataReader<Staff> {
    override fun readData(): List<Staff> {

        val fileURI = this::class.java.classLoader.getResource(resourcePath).toURI()
        val file = File(fileURI)
        val db = DatabaseBuilder.open(file)

        //return db.getTable(tableName).columns.elementAt(3).name

        val staff = Staff().apply {

        }
        return emptyList()
    }

    companion object {
        private const val TABLE_NAME = "2019-2020S-275PreliminaryForPublic"
        private const val LAST_NAME_COL = "LastName"
        private const val FIRST_NAME_COL = "FirstName"
        private const val STAFF_RACE_COL = "race"
        private const val HISPANIC_COL = "hispanic"
        private const val HIGHEST_DEGREE_COL = "hdeg"
        private const val CERT_COL = "certflag"
        private const val CLASS_COL = "clasflag"
        private const val BUILDING_NUM_COL = "bldgn"
        private const val REC_COL = "recno"
        // associated fte --> rec, not --> teacher
        private const val ASSOC_FTE_COL = "assfte"
        // associated salary --> rec, not --> teacher
        private const val ASSOC_SALARY_COL = "asssal"
        private const val DISTRIC_COL = "dis"
    }
}