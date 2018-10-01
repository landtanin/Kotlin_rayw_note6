
// all classes are final by default
// open and sealed classes

// 'open' allows it to be subclassed

// 'sealed' makes it impossible to create a subclass unless they're in the same file
// the sealed classes are abstract
// sealed classes cannot have a public constructor

sealed class Expression

data class Num(val number: Double) : Expression()
data class Sum(val e1: Expression, val e2: Expression) : Expression()
object NotANumber: Expression()

fun eval(expr: Expression): Double = when (expr) {
    is Num -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

// Singleton
object MySingleton {
    fun doStuff(data: String) {
        println("This is my data $data")
    }

    val myConstant = "My constant"
}

// Singleton challenge
data class Student(val firstName: String, val lastName: String)

object StudentRegistry {
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
    }

    fun removeStudent(student: Student) {
        allStudents.remove(student)
    }
}

fun main(args: Array<String>) {

    // sealed classes
    val num1 = Num(5.5)
    val num2 = Num(10.0)
    println("The sum is ${eval(Sum(num1, num2))}")

    // singleton
    MySingleton.doStuff("data ${MySingleton.myConstant}" )                  // This is my data data My constant

    // Singleton challenge
    val steve = Student("Steve", "Miller")
    val john = Student("John", "Smith")
    StudentRegistry.addStudent(steve)
    StudentRegistry.addStudent(john)
    StudentRegistry.allStudents.forEach {
        println(it.firstName)
    }


}