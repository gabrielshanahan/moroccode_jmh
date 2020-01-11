package io.github.gabrielshanahan

import BenchmarkObject
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit


@State(Scope.Thread)
open class BenchmarkState {
    lateinit var obj1 : BenchmarkObject
    lateinit var obj2 : BenchmarkObject

    @Setup
    fun setup(){
        fun makeObj() = BenchmarkObject(1,
                "Hello World",
                Math.PI,
                true,
                listOf("A", "B", "C", "D", "E")
        )
        obj1 = makeObj()
        obj2 = makeObj()
    }
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class Benchmark {

    @Benchmark
    fun moroccodeCompareUsingFields(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.moroccodeCompareUsingFields(state.obj2))
    }

    @Benchmark
    fun moroccodeCompareUsingGetters(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.moroccodeCompareUsingGetters(state.obj2))
    }

    @Benchmark
    fun moroccodeCompareUsing(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.moroccodeCompareUsing(state.obj2))
    }

    @Benchmark
    fun hashkodeCompareFields(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.hashkodeCompareFields(state.obj2))
    }

    @Benchmark
    fun haskodeRegular(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.hashkodeRegular(state.obj2))
    }

    @Benchmark
    fun arhipov(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.nikarh(state.obj2))
    }

    @Benchmark
    fun kassava(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.kassava(state.obj2))
    }

    @Benchmark
    fun apache(state: BenchmarkState, blackhole: Blackhole) {
        blackhole.consume(state.obj1.apache(state.obj2))
    }
}