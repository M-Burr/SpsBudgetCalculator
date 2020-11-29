package sps.budget.datareaders

import org.apache.poi.ss.usermodel.WorkbookFactory
import sps.budget.FTEType
import sps.budget.Staff

class StaffSalaryXlsxReader(private val resourcePath: String): DataReader<Staff> {
    override fun readData(): List<Staff> {
        val input = this::class.java.classLoader.getResourceAsStream(resourcePath)
        val workbook = WorkbookFactory.create(input)
        val excelSheet = workbook.getSheetAt(0)
        val staffList = mutableListOf<Staff>()

        excelSheet.forEachIndexed { index, row ->
            if (index == 0 || row.getCell(FIRST_NAME_COL) == null) {
                return@forEachIndexed
            }

            val staff = Staff().apply {
                this.firstName = row.getCell(FIRST_NAME_COL).toString()
                this.lastName = row.getCell(LAST_NAME_COL).toString()
                this.position = row.getCell(POSITION_COL).toString()
                this.totalSalary = row.getCell(TOTAL_SALARY_COL).numericCellValue
                this.benefits = row.getCell(MANDATORY_BENEFITS_COL).numericCellValue

                val classFte = row.getCell(CLASS_FTE_COL).numericCellValue
                if (classFte > 0) {
                    this.fteType = FTEType.Classified
                    this.fteAmount = classFte
                } else {
                    this.fteType = FTEType.Certificated
                    this.fteAmount = row.getCell(CERT_FTE_COL).numericCellValue
                }
            }
            staffList.add(staff)
        }

       return staffList
    }

    companion object {
        const val FIRST_NAME_COL = 13
        const val LAST_NAME_COL = 10
        const val POSITION_COL = 2
        const val CERT_FTE_COL = 3
        const val CLASS_FTE_COL = 4
        const val TOTAL_SALARY_COL = 6
        const val MANDATORY_BENEFITS_COL = 8
    }

}