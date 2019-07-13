/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.openmessaging.connector.api.data;

import java.nio.ByteBuffer;

/**
 * SourceDataEntries are generated by SourceTasks and passed to specific message queue to store.
 *
 * @version OMS 0.1.0
 * @since OMS 0.1.0
 */
public class SourceDataEntry extends DataEntry {

    public SourceDataEntry(ByteBuffer sourcePartition,
        ByteBuffer sourcePosition,
        Long timestamp,
        EntryType entryType,
        String queueName,
        Schema schema,
        Object[] payload) {
        this(sourcePartition, sourcePosition, timestamp, entryType, queueName, schema, null, payload);
    }

    public SourceDataEntry(ByteBuffer sourcePartition,
        ByteBuffer sourcePosition,
        Long timestamp,
        EntryType entryType,
        String queueName,
        Schema schema,
        String shardingKey,
        Object[] payload) {
        super(timestamp, entryType, queueName, schema, shardingKey, payload);
        this.sourcePartition = sourcePartition;
        this.sourcePosition = sourcePosition;
    }

    /**
     * Partition of the data source.
     */
    private ByteBuffer sourcePartition;

    /**
     * Position of current data entry of {@link SourceDataEntry#sourcePartition}.
     */
    private ByteBuffer sourcePosition;

    public ByteBuffer getSourcePartition() {
        return sourcePartition;
    }

    public void setSourcePartition(ByteBuffer sourcePartition) {
        this.sourcePartition = sourcePartition;
    }

    public ByteBuffer getSourcePosition() {
        return sourcePosition;
    }

    public void setSourcePosition(ByteBuffer sourcePosition) {
        this.sourcePosition = sourcePosition;
    }

    @Override public String toString() {
        return "SourceDataEntry{" +
            "sourcePartition=" + sourcePartition +
            ", sourcePosition=" + sourcePosition +
            "} " + super.toString();
    }
}
