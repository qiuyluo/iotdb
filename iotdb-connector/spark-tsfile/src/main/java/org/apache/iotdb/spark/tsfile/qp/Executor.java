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
package org.apache.iotdb.spark.tsfile.qp;

import org.apache.iotdb.tsfile.read.TsFileReader;
import org.apache.iotdb.tsfile.read.expression.QueryExpression;
import org.apache.iotdb.tsfile.read.query.dataset.QueryDataSet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** This class used to execute Queries on TSFile */
public class Executor {
  private Executor() {}

  public static List<QueryDataSet> query(
      TsFileReader reader, List<QueryExpression> queryExpressions, long start, long end) {
    List<QueryDataSet> dataSets = new ArrayList<>();
    try {
      for (QueryExpression expression : queryExpressions) {
        QueryDataSet queryDataSet = reader.query(expression, start, end);
        dataSets.add(queryDataSet);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return dataSets;
  }
}
