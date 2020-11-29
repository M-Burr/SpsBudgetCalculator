package sps.budget.datareaders

import sps.budget.School
import kotlin.test.Test
import kotlin.test.assertEquals

class SchoolNCESHTMLReaderTest {
    @Test
    fun `readData returns the expected schools`() {
        val schoolList = SchoolNCESHTMLReader(TEST_FILE).readData()
        assertEquals(3, schoolList.size)
        assertSchoolEquals(ADAMS, schoolList[0])
        assertSchoolEquals(AKI_KUROSE, schoolList[1])
        assertSchoolEquals(ALKI, schoolList[2])
    }

    private fun assertSchoolEquals(expected: School, actual: School) {
        assertEquals(expected.name, actual.name)
        assertEquals(expected.districtNum, actual.districtNum)
        assertEquals(expected.buildingNum, actual.buildingNum)
        assertEquals(expected.titleOneStatus, actual.titleOneStatus)
        assertEquals(expected.studentCount, actual.studentCount)
        assertEquals(expected.teacherCount, actual.teacherCount)
        assertEquals(expected.freeLunch, actual.freeLunch)
        assertEquals(expected.reducedLunch, actual.reducedLunch)
    }

    companion object {
        const val TEST_FILE = "school-nces-test-data.html"
        val ADAMS = School().apply {
            name = "Adams Elementary School"
            districtNum = "17001"
            buildingNum = "2138"
            titleOneStatus = false
            studentCount = 534.0
            teacherCount = 32.34
            freeLunch = 61.0
            reducedLunch = 9.0
        }
        val AKI_KUROSE = School().apply {
            name = "Aki Kurose Middle School"
            districtNum = "17001"
            buildingNum = "3774"
            titleOneStatus = true
            studentCount = 664.0
            teacherCount = 41.82
            freeLunch = 391.0
            reducedLunch = 104.0
        }
        val ALKI = School().apply {
            name = "Alki Elementary School"
            districtNum = "17001"
            buildingNum = "2181"
            titleOneStatus = false
            studentCount = 368.0
            teacherCount = 20.54
            freeLunch = 38.0
            reducedLunch = 13.0
        }
    }
}