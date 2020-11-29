package sps.budget

enum class FTEType {
    Certificated,
    Classified
}

class Staff {
    var firstName = ""
    var lastName = ""
    var schoolAllocations = mutableMapOf<String, Float>() //based on school name && FTE at that school
    var position = ""
    var totalSalary = 0.0
    var benefits = 0.0

    var fteType = FTEType.Certificated
    var fteAmount = 0.0
}