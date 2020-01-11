# moroccode_jmh
Benchmarks for [Moroccode](https://github.com/gabrielshanahan/moroccode) implemented using JMH.

Benchamrks are currently implemented implementing the `equals` method using one of the following libraries:
- [HashKode](https://github.com/PvdBerg1998/HashKode)
   - [compareUsing](https://github.com/PvdBerg1998/HashKode#regular-x--y) (most efficient)
   - [compareFields](https://github.com/PvdBerg1998/HashKode#comparefield) (most concise)
- [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/builder/EqualsBuilder.html)
- [nikarh/equals-builder](https://github.com/nikarh/equals-builder)
- [consoleau/kassava](https://github.com/consoleau/kassava)
