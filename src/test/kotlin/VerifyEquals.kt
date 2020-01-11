package io.github.gabrielshanahan

import BenchmarkObject
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class VerifyEquals: StringSpec({
    val one = BenchmarkObject(1, "Hello", Math.PI, true, listOf("1", "2", "3"))
    val two = BenchmarkObject(1, "Hello", Math.PI, true, listOf("1", "2", "4"))

    "Verify equals" {

        forall(
            row(BenchmarkObject::moroccodeCompareUsingFields),
            row(BenchmarkObject::moroccodeCompareUsingGetters),
            row(BenchmarkObject::moroccodeCompareUsing),
            row(BenchmarkObject::hashkodeCompareFields),
            row(BenchmarkObject::hashkodeRegular),
            row(BenchmarkObject::nikarh),
            row(BenchmarkObject::kassava),
            row(BenchmarkObject::apache)
        ) { f ->
            f(one, one) shouldBe true
            f(one, two) shouldBe false
            f(two, one) shouldBe false
        }
    }
})