package chapter3.exercises.ex13

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import chapter3.foldLeft
import chapter3.foldRight
import chapter3.reverse
import chapter9.sec6_3.cons
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

// tag::init[]
fun <A> append(a1: List<A>, a2: List<A>): List<A> =
    foldRight(a1, a2) { item, accum -> Cons(item, accum) }
// end::init[]

fun <A> appendL(a1: List<A>, a2: List<A>): List<A> =
    foldLeft(reverse(a1), a2) { accum, item -> Cons(item, accum) }

//TODO: Enable tests by removing `!` prefix
class Exercise13 : WordSpec({
    "list append" should {
        "append two lists to each other using foldRight" {
            append(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }

    "list appendL" should {
        "append two lists to each other using foldLeft" {
            appendL(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
