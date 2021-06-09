package chapter4.exercises.ex4

import chapter3.Cons
import chapter3.List
import chapter3.exercises.ex13.append
import chapter3.foldLeft
import chapter3.foldRight
import chapter4.None
import chapter4.Option
import chapter4.Some
import chapter5.sec1.filter
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import utils.SOLUTION_HERE

//tag::init[]
fun <A> sequence(xs: List<Option<A>>): Option<List<A>> =
    foldRight(xs, Some(List.empty<A>())) { item: Option<A>, accum: Option<List<A>> ->
        accum.flatMap {
            accum.flatMap { list ->
                item.map { a ->
                    Cons(
                        a,
                        list
                    )
                }
            }
        }
    }
//end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise4 : WordSpec({

    "sequence" should {
        "turn a list of some options into an option of list" {
            val lo =
                List.of(Some(10), Some(20), Some(30))
            sequence(lo) shouldBe Some(List.of(10, 20, 30))
        }
        "turn a list of options containing none into a none" {
            val lo =
                List.of(Some(10), None, Some(30))
            sequence(lo) shouldBe None
        }
    }
})
