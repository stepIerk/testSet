package ru.fmsha.krastd.labs.sets;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.OptionalInt;
import java.util.OptionalDouble;
import static org.assertj.core.api.Assertions.assertThat;

public class SortedIntSetTest extends TestCase {

    @Test
    public void testCreateWithListOfElements() {
        SortedIntSet set = new SortedIntSet(new int[]{1,2,3});
        assertThat(set.getSize()).isEqualTo(3);
        assertThat(set).containsOnly(1,2,3);
    }


    @Test
    public void testEmpty() {
        SortedIntSet set = new SortedIntSet(10);
        assertThat(set.isEmpty()).isTrue();
        assertThat(set.getSize()).isEqualTo(0);
    }

    @Test
    public void testAdd() {
        SortedIntSet set = new SortedIntSet(10);
        set.add(1);

        assertThat(set.getSize()).isEqualTo(1);
        assertThat(set).containsOnly(1);
    }

    @Test
    public void testAddDuplicates() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,1,1});

        assertThat(set.getSize()).isEqualTo(1);
        assertThat(set).containsOnly(1);
    }

    @Test
    public void testAddAll() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});

        assertThat(set.getSize()).isEqualTo(3);
        assertThat(set).containsOnly(1,2,3);
    }

    @Test
    public void testAddWithIcreaseSize() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3,4,5,6,7,8,9,10,11});

        assertThat(set.getSize()).isEqualTo(11);
        assertThat(set).containsOnly(1,2,3,4,5,6,7,8,9,10,11);
    }

    @Test
    public void testGetMax() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});
        OptionalInt optionalInt = set.getMax();
        assertThat(optionalInt).isEqualTo(OptionalInt.of(3));
    }


    @Test
    public void testGetMin() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});
        OptionalInt optionalInt = set.getMin();
        assertThat(optionalInt).isEqualTo(OptionalInt.of(1));
    }

    @Test
    public void testGetAvg() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});

        OptionalDouble optionalDouble = set.getAvg();
        assertThat(optionalDouble).isEqualTo(OptionalDouble.of(2));
    }

    @Test
    public void testGetMaxEmptySet() {
        SortedIntSet set = new SortedIntSet(10);
        OptionalInt optionalInt = set.getMax();
        assertThat(optionalInt).isEqualTo(OptionalInt.empty());
    }

    @Test
    public void testGetMinEmptySet() {
        SortedIntSet set = new SortedIntSet(10);
        OptionalInt optionalInt = set.getMin();
        assertThat(optionalInt).isEqualTo(OptionalInt.empty());
    }

    @Test
    public void testGetAvgEmptySet() {
        SortedIntSet set = new SortedIntSet(10);
        OptionalDouble optionalDouble = set.getAvg();
        assertThat(optionalDouble).isEqualTo(OptionalDouble.empty());
    }


    @Test
    public void testRemove() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});
        assertThat(set.remove(1)).isEqualTo(true);
        assertThat(set.getSize()).isEqualTo(2);
        assertThat(set).containsOnly(2,3);
    }

    @Test
    public void testRemoveFalse() {
        SortedIntSet set = new SortedIntSet(10);
        assertThat(set.remove(1)).isEqualTo(false);
    }

    @Test
    public void testClear() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});
        set.clear();
        assertThat(set.isEmpty()).isEqualTo(true);
        assertThat(set.getSize()).isEqualTo(0);
    }


    @Test
    public void testEqualsTrue() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});
        SortedIntSet set1 = new SortedIntSet(10);
        set1.addAll(new int[]{1,2,3});

        assertThat(set.equals(set1)).isEqualTo(true);
    }

    @Test
    public void testEqualsFalse() {
        SortedIntSet set = new SortedIntSet(10);
        set.addAll(new int[]{1,2,3});
        SortedIntSet set1 = new SortedIntSet(10);
        set1.addAll(new int[]{1,2,4});

        assertThat(set.equals(set1)).isEqualTo(false);
    }

}