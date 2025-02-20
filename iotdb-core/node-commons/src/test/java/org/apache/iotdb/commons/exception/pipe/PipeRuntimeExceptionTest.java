/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iotdb.commons.exception.pipe;

import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;

public class PipeRuntimeExceptionTest {
  @Test
  public void testPipeRuntimeNonCriticalException() {
    PipeRuntimeNonCriticalException e = new PipeRuntimeNonCriticalException("test");
    Assert.assertEquals(new PipeRuntimeNonCriticalException("test"), e);
    ByteBuffer buffer = ByteBuffer.allocate(32);
    e.serialize(buffer);
    buffer.position(0);
    try {
      PipeRuntimeNonCriticalException e1 =
          (PipeRuntimeNonCriticalException) PipeRuntimeExceptionType.deserializeFrom(buffer);
      Assert.assertEquals(e.hashCode(), e1.hashCode());
    } catch (ClassCastException classCastException) {
      Assert.fail();
    }
  }

  @Test
  public void testPipeRuntimeCriticalException() {
    PipeRuntimeCriticalException e = new PipeRuntimeCriticalException("test");
    Assert.assertEquals(new PipeRuntimeCriticalException("test"), e);
    ByteBuffer buffer = ByteBuffer.allocate(32);
    e.serialize(buffer);
    buffer.position(0);
    try {
      PipeRuntimeCriticalException e1 =
          (PipeRuntimeCriticalException) PipeRuntimeExceptionType.deserializeFrom(buffer);
      Assert.assertEquals(e.hashCode(), e1.hashCode());
    } catch (ClassCastException classCastException) {
      Assert.fail();
    }
  }

  @Test
  public void testPipeRuntimeConnectorCriticalException() {
    PipeRuntimeConnectorCriticalException e = new PipeRuntimeConnectorCriticalException("test");
    Assert.assertEquals(new PipeRuntimeConnectorCriticalException("test"), e);
    ByteBuffer buffer = ByteBuffer.allocate(32);
    e.serialize(buffer);
    buffer.position(0);
    try {
      PipeRuntimeConnectorCriticalException e1 =
          (PipeRuntimeConnectorCriticalException) PipeRuntimeExceptionType.deserializeFrom(buffer);
      Assert.assertEquals(e.hashCode(), e1.hashCode());
    } catch (ClassCastException classCastException) {
      Assert.fail();
    }
  }
}
