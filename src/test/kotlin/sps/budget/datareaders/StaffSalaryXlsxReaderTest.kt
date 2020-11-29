package sps.budget.datareaders

import sps.budget.FTEType
import sps.budget.Staff
import kotlin.test.Test
import kotlin.test.assertEquals

class StaffSalaryXlsxReaderTest {
    @Test
    fun `reads teacher data from the xlsx file`() {
        val staffList = StaffSalaryXlsxReader(TEST_FILE).readData()
        assertEquals(3, staffList.size)
        assertStaffEquals(TOMMY, staffList[0])
        assertStaffEquals(DOCTOR, staffList[1])
        assertStaffEquals(MICHELLE, staffList[2])
    }

    private fun assertStaffEquals(expected: Staff, actual: Staff) {
        assertEquals(expected.firstName, actual.firstName)
        assertEquals(expected.lastName, actual.lastName)
        assertEquals(expected.position, actual.position)
        assertEquals(expected.totalSalary, actual.totalSalary)
        // TODO: school allocations
        assertEquals(expected.benefits, actual.benefits)
        assertEquals(expected.fteType, actual.fteType)
        assertEquals(expected.fteAmount, actual.fteAmount)
    }

    companion object {
        const val TEST_FILE = "staff-salary-test-data.xlsx"
        val TOMMY = Staff().apply {
            firstName = "TOMMY"
            lastName = "SALAMI"
            position = "Primary Cat"
            totalSalary = 100000.0
            benefits = 15000.0
            fteType = FTEType.Certificated
            fteAmount = 1.0
        }
        val DOCTOR = Staff().apply {
            firstName = "DOCTOR"
            lastName = "KEN"
            position = "Funny Man"
            totalSalary = 85000.0
            benefits = 50000.0
            fteType = FTEType.Classified
            fteAmount = 0.8
        }
        val MICHELLE = Staff().apply {
            firstName = "MICHELLE"
            lastName = "OBAMA"
            position = "Forever First Lady"
            totalSalary = 1000000.0
            benefits = 150000.0
            fteType = FTEType.Certificated
            fteAmount = 0.5
        }
    }
}