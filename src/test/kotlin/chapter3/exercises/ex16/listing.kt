package chapter3.exercises.ex16

import chapter3.Cons
import chapter3.List
import chapter3.foldLeft
import chapter3.foldRight
import chapter3.reverse
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun doubleToString(xs: List<Double>): List<String> =
    foldLeft(reverse(xs), List.empty()) { accum, item -> Cons(item.toString(), accum) }
// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise16 : WordSpec({
    "list doubleToString" should {
        "convert every double element to a string" {
            doubleToString(List.of(1.1, 1.2, 1.3, 1.4)) shouldBe
                List.of("1.1", "1.2", "1.3", "1.4")
        }
    }
})
