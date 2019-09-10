package com.harium.loader;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ByteUtilsTest {

  @Test
  public void testIntToByteLittleEndian() {
    assertArrayEquals(new byte[]{108, 108, 6, 0}, ByteUtils.intToByteLittleEndian(420972));
    assertArrayEquals(new byte[]{-1, -1, -1, 127},
        ByteUtils.intToByteLittleEndian(Integer.MAX_VALUE));
    assertArrayEquals(new byte[]{0, 0, 0, -128}, ByteUtils.intToByteLittleEndian(Integer.MIN_VALUE));
  }

  @Test
  public void readIntLittleEndian() {
    assertEquals(ByteUtils.readIntLittleEndian(new byte[]{-1, -1, -1, 127}), Integer.MAX_VALUE);
    assertEquals(ByteUtils.readIntLittleEndian(new byte[]{0, 0, 0, -128}), Integer.MIN_VALUE);
  }

  @Test
  public void readIntBigEndian() {
    assertEquals(ByteUtils.readIntBigEndian(new byte[]{0, 0, 50, -108}), 12948);
  }

}
