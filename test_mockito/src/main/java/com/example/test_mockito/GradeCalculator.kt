package com.example.test_mockito

class GradeCalculator {

    var public_variable = "I am public variable"
    private var private_variable = "I am private variable"

    fun getGrades(scores : List<Int>): List<String>{
        var grades = ArrayList<String>()
        for( score in scores){
            grades.add(computeGrade(score))
        }
        return grades
    }

    private fun computeGrade(score: Int): String {
        return when(score){
            75 -> "Distinction"
            in 60..74 -> "1st Division"
            in 50..59 -> "2nd Division"
            in 40..40 -> "3rd Division"
            in 35..39 -> "Pass"
            else -> "Fail"
        }
    }
}