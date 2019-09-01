package com.harium.loader;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ByteToIntTest {

  @Test
  public void testIntToByteBigEndian() {
    assertArrayEquals(new byte[]{108, 108, 6, 0}, ByteToInt.intToByteBigEndian(420972));
    assertArrayEquals(new byte[]{-1, -1, -1, 127},
        ByteToInt.intToByteBigEndian(Integer.MAX_VALUE));
    assertArrayEquals(new byte[]{0, 0, 0, -128}, ByteToInt.intToByteBigEndian(Integer.MIN_VALUE));
  }

  @Test
  public void readIntBigEndian() {
    assertEquals(ByteToInt.readIntBigEndian(new byte[]{-1, -1, -1, 127}), Integer.MAX_VALUE);
    assertEquals(ByteToInt.readIntBigEndian(new byte[]{0, 0, 0, -128}), Integer.MIN_VALUE);
  }

}
