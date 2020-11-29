package sps.budget.datareaders

import it.skrape.core.htmlDocument
import it.skrape.selects.html5.table
import it.skrape.selects.html5.td
import it.skrape.selects.html5.tr
import sps.budget.School
import java.io.File

class SchoolNCESHTMLReader(private val resourcePath: String) : DataReader<School> {
    override fun readData(): List<School> {
        // school name --> school id
        val fileURI = this::class.java.classLoader.getResource(resourcePath).toURI()
        val file = File(fileURI)
        return htmlDocument(file) {
            table {
                tr {
                    withAttribute = "height" to "17"

                    findAll {
                        map { row ->
                            School().also { school ->
                                row.td {
                                    findByIndex(NAME_COL) {
                                        school.name = text
                                    }
                                    findByIndex(DISTRICT_BUILDING_COL) {
                                        // district code is format: WA-<DISTRICT>-<BUILDING>
                                        val parts = text.split("-")
                                        school.districtNum = parts.getOrElse(1) { "" }
                                        school.buildingNum = parts.getOrElse(2) { "" }
                                    }
                                    findByIndex(TITLE_ONE_COL) {
                                        school.titleOneStatus = (text == "Yes")
                                    }
                                    findByIndex(TEACHER_COUNT_COL) {
                                        school.teacherCount = text.toDoubleOrNull() ?: 0.0
                                    }
                                    findByIndex(STUDENT_COUNT_COL) {
                                        school.studentCount = text.toDoubleOrNull() ?: 0.0
                                    }
                                    findByIndex(FREE_LUNCH_COL) {
                                        school.freeLunch = text.toDoubleOrNull() ?: 0.0
                                    }
                                    findByIndex(REDUCED_LUNCH_COL) {
                                        school.reducedLunch = text.toDoubleOrNull() ?: 0.0
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }.drop(1)
    }

    companion object {
        const val NAME_COL = 6
        const val DISTRICT_BUILDING_COL = 1
        const val TITLE_ONE_COL = 19
        const val TEACHER_COUNT_COL = 22
        const val STUDENT_COUNT_COL = 21
        const val FREE_LUNCH_COL = 24
        const val REDUCED_LUNCH_COL = 25
    }
}