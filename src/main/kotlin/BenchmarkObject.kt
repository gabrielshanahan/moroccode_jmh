import au.com.console.kassava.kotlinEquals
import io.github.gabrielshanahan.moroccode.compareUsing
import io.github.gabrielshanahan.moroccode.compareUsingFields
import net.arhipov.equalsbuilder.EqualsBuilder as nikarhEqualsBuilder
import nl.pvdberg.hashkode.compareFields
import org.apache.commons.lang3.builder.EqualsBuilder

class BenchmarkObject(
        val anInt: Int,
        val aString: String,
        val aDouble: Double,
        val aBool: Boolean,
        val aList: List<String>
) {

    fun moroccodeCompareUsingFields(other: Any?) = compareUsingFields(other) {
        fields { anInt } and { aString } and { aDouble } and { aBool } and { aList }
    }

    fun moroccodeCompareUsingGetters(other: Any?) = compareUsingFields(other) {
        fields(BenchmarkObject::anInt) and
                BenchmarkObject::aString and
                BenchmarkObject::aDouble and
                BenchmarkObject::aBool and
                BenchmarkObject::aList
    }

    fun moroccodeCompareUsing(other: Any?) = compareUsing(other) {
        anInt == it.anInt &&
                aString == it.aString &&
                aDouble == it.aDouble &&
                aBool == it.aBool &&
                aList == it.aList
    }

    fun hashkodeCompareFields(other: Any?) = compareFields(other) {
        compareField(BenchmarkObject::anInt)
        compareField(BenchmarkObject::aString)
        compareField(BenchmarkObject::aDouble)
        compareField(BenchmarkObject::aBool)
        compareField(BenchmarkObject::aList)
    }

    fun hashkodeRegular(other: Any?) = compareFields(other) {
        equal = one.anInt == two.anInt &&
                one.aString == two.aString &&
                one.aDouble == two.aDouble &&
                one.aBool == two.aBool &&
                one.aList == two.aList
    }

    fun nikarh(other: Any?) = nikarhEqualsBuilder.test(this, other)
            .comparing(BenchmarkObject::anInt)
            .comparing(BenchmarkObject::aString)
            .comparing(BenchmarkObject::aDouble)
            .comparing(BenchmarkObject::aBool)
            .comparing(BenchmarkObject::aList)
            .areEqual()

    fun kassava(other: Any?) = kotlinEquals(other = other,
            properties = arrayOf(
                    BenchmarkObject::anInt,
                    BenchmarkObject::aString,
                    BenchmarkObject::aDouble,
                    BenchmarkObject::aBool,
                    BenchmarkObject::aList
            ))

    fun apache(other: Any?) = other is BenchmarkObject && EqualsBuilder()
            .append(anInt, other.anInt)
            .append(aString, other.aString)
            .append(aDouble, other.aDouble)
            .append(aBool, other.aBool)
            .append(aList, other.aList)
            .isEquals

}