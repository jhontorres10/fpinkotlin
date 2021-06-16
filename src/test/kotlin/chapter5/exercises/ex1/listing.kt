package chapter5.exercises.ex1

import chapter3.Cons
import chapter3.List
import chapter5.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

//TODO: Enable tests by removing `!` prefix
class Exercise1 : WordSpec({
    //tag::init[]
    fun <A> Stream<A>.toList(): List<A> =
        this.foldRight({ -> List.empty() }, { item, accum -> Cons(item, accum()) } )
    //end::init[]

    "Stream.toList" should {
        "force the stream into an evaluated list" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.toList() shouldBe List.of(1, 2, 3, 4, 5)
        }
    }
})
