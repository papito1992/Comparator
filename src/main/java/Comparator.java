import java.util.PrimitiveIterator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Comparator {
    private static final int MASK = 0b11111111;

    long generatorFilter(int seedA, int seedB) {
        PrimitiveIterator.OfLong generatorA = createGenerator(seedA, 16807, 2147483647);
        PrimitiveIterator.OfLong generatorB = createGenerator(seedB, 48271,2147483647);

        return Stream.generate(() -> new long[]{generatorA.nextLong(), generatorB.nextLong()})
                .limit(1000000)
                .filter(ll -> ((ll[0] ^ ll[1]) & MASK) == 0)
                .count();
    }

    private static PrimitiveIterator.OfLong createGenerator(long seed, long multiplier, long modulus) {
        return LongStream.iterate(seed, x -> (x * multiplier) % modulus)
                .iterator();
    }
}
